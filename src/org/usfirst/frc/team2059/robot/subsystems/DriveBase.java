package org.usfirst.frc.team2059.robot.subsystems;
import org.usfirst.frc.team2059.robot.RobotMap;
import org.usfirst.frc.team2059.robot.commands.drivetrain.Drive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.PIDController;
import com.ctre.CANTalon;

public class DriveBase extends Subsystem {
  boolean driveEnabled = true;
  CANTalon leftFrontMotor = new CANTalon(RobotMap.driveLeftFrontMotor);
  CANTalon leftRearMotor = new CANTalon(RobotMap.driveLeftRearMotor);
  CANTalon rightFrontMotor = new CANTalon(RobotMap.driveRightFrontMotor);
  CANTalon rightRearMotor = new CANTalon(RobotMap.driveRightRearMotor);
  AnalogGyro gyro = new AnalogGyro(RobotMap.gyro);
  Encoder xEncoder = new Encoder(RobotMap.xEncoderA, RobotMap.xEncoderB, false, Encoder.EncodingType.k4X);
  Encoder yEncoder = new Encoder(RobotMap.yEncoderA, RobotMap.yEncoderB, false, Encoder.EncodingType.k4X);
  PIDController xEncoderController = new PIDController(0.2, 0.002, 0.017, new xEncoderPIDSource(), new xEncoderPIDOutput());
  PIDController yEncoderController = new PIDController(0.2, 0.002, 0.017, new yEncoderPIDSource(), new yEncoderPIDOutput());
  PIDController gyroController = new PIDController(0.02, 0.002, 0.017, new gyroPIDSource(), new gyroPIDOutput());
  double correctedGyroAngle = .1;
  double previousError = 0;
  public void initDefaultCommand() {
    setDefaultCommand(new Drive());
  }

  public void setDriveEnabled(boolean enabled) {
    driveEnabled = enabled;
  }

  public void driveMecanum(double x, double y, double z) {
    if (driveEnabled) {
      rightFrontMotor.set(-x + y - z);
      leftFrontMotor.set(-(x + y + z));
      rightRearMotor.set(x + y - z);
      leftRearMotor.set(-(-x + y + z));
    }
  }

  public void driveMecanum(double x, double y, double z, double sensitivity) {
    if (driveEnabled) {
      if (x < 0.1 && x > -0.1) {
        x = 0;
      }
      if (y < 0.05 && y > -0.1) {
        y = 0;
      }
      if (z < 0.1 && z > -0.1) {
        z = 0;
      }
      x = -x * sensitivity;
      y = y * sensitivity;
      z = -z * sensitivity;
      rightFrontMotor.set(-x + y - z);
      leftFrontMotor.set(-(x + y + z));
      rightRearMotor.set(x + y - z);
      leftRearMotor.set(-(-x + y + z));
    }
  }

  public void rotateAngle(double angle) {
    gyroController.enable();
    gyroController.setSetpoint(angle);
  }

  public void yPidDrive(double setpoint, double correction) {
    yEncoderController.setSetpoint(setpoint);
    correctedGyroAngle = -gyro.getAngle() * correction;
    SmartDashboard.putNumber("CorrectedGyroAngle", correctedGyroAngle);
  }

  public void xPidDrive(double setpoint, double correction) {
    xEncoderController.setSetpoint(setpoint);
    xEncoderController.enable();
    correctedGyroAngle = -gyro.getAngle() * correction;
    SmartDashboard.putNumber("CorrectedGyroAngle", correctedGyroAngle);
  }

  public void driveStraightX(double speed, double correction) {
    double kP = SmartDashboard.getNumber("driveStraightkP");
    double kD = SmartDashboard.getNumber("driveStraightkD");
    double kI = SmartDashboard.getNumber("driveStraightkI");
    double error = getxEncoderCount(); 

    SmartDashboard.putNumber("previousError",previousError);
    SmartDashboard.putNumber("error",error);
    //double yPower = -((kP*error)+(kD*error-previousError)+kI);
    double yPower = ((kP*error)+kI);
    double zPower = -gyro.getAngle() * correction;
    SmartDashboard.putNumber("yPower",yPower);
    driveMecanum(speed, yPower, zPower, 1);
    previousError = error;
  }

  public void circleDrive(double radius) {
    driveMecanum(0.1, 0, 360 / (3.14 * radius * 2));
  }

  //Reset sensor counts
  public void resetxEncoderCount() {
    xEncoder.reset();
  }
  public void resetyEncoderCount() {
    yEncoder.reset();
  }
  public void resetGyro() {
    gyro.reset();
  }

  //Get sensor counts
  public double getxEncoderCount() {
    return xEncoder.get();
  }
  public double getyEncoderCount() {
    return yEncoder.get();
  }
  public AnalogGyro getGyro() {
    return gyro;
  }
  public double getxEncoderDistance() {
    double x = this.getxEncoderCount();
    double z = (x / 128) * 3.14 * 8;
    return z;
  }
  public double getyEncoderDistance() {
    double y = this.getyEncoderCount();
    //TODO change to physical wheel size
    double z = (y / 128) * 3.14 * 8;
    return -z;
  }



  //PID Controller get methods
  public PIDController getxEncoderController() {
    return xEncoderController;
  }
  public PIDController getyEncoderController() {
    return yEncoderController;
  }
  public PIDController getGyroController() {
    return gyroController;
  }

  //PID Output classes
  public class xEncoderPIDOutput implements PIDOutput {
    @Override
    public void pidWrite(double output) {
      driveMecanum(output, 0, correctedGyroAngle, 1);
    }
  }
  public class yEncoderPIDOutput implements PIDOutput {
    @Override
    public void pidWrite(double output) {
      driveMecanum(0, output, correctedGyroAngle, 1);
      SmartDashboard.putNumber("tmpOutput", output);
    }
  }
  public class gyroPIDOutput implements PIDOutput {
    @Override
    public void pidWrite(double output) {
      rightFrontMotor.set(output);
      leftFrontMotor.set(output);
      rightRearMotor.set(output);
      leftRearMotor.set(output);
    }
  }

  //PID Source classes
  public class gyroPIDSource implements PIDSource {
    @Override
    public double pidGet() {
      return gyro.getAngle();
    }
    public PIDSourceType getPIDSourceType() {
      return PIDSourceType.kDisplacement;
    }
    public void setPIDSourceType(PIDSourceType type) {
    }
  }
  public class xEncoderPIDSource implements PIDSource {
    @Override
    public double pidGet() {
      return getxEncoderDistance();
    }
    public PIDSourceType getPIDSourceType() {
      return PIDSourceType.kDisplacement;
    }
    public void setPIDSourceType(PIDSourceType type) {
    }
  }
  public class yEncoderPIDSource implements PIDSource {
    @Override
    public double pidGet() {
      return getyEncoderDistance();
    }
    public PIDSourceType getPIDSourceType() {
      return PIDSourceType.kDisplacement;
    }
    public void setPIDSourceType(PIDSourceType type) {
    }
  }
}
// vim: sw=2:ts=2:sts=2
