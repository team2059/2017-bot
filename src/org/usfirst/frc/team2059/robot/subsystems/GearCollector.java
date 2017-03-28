package org.usfirst.frc.team2059.robot.subsystems;
import org.usfirst.frc.team2059.robot.RobotMap;
import com.ctre.CANTalon;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.PIDController;

public class GearCollector extends Subsystem {
  CANTalon gearMotor = new CANTalon(RobotMap.gearCollectorMotor);
  CANTalon gearAngleMotor = new CANTalon(RobotMap.gearAngleMotor);
  AnalogInput gearAnglePot = new AnalogInput(RobotMap.gearAnglePot);
  PIDController angleController = new PIDController(0.1, 0.0, 0.001, new gearAnglePIDSource(), new gearAnglePIDOutput());

  public void initDefaultCommand() {
  }
  public void gearCollectAtSpeed(double speed) {
    gearMotor.set(speed);
  }
  public void setGearAngleMotorSpeed(double speed) {
    gearAngleMotor.set(speed);
  }
  public double potToDegrees(double pot) {
    double min = RobotMap.gearCollectDegrees;
    double max = RobotMap.gearDeployDegrees;
    return (pot - min) / (Math.abs(min - max) / 90);
  }
  public double getDegrees() {
    return potToDegrees(gearAnglePot.getAverageVoltage());
  }
  public PIDController getAngleController() {
    return angleController;
  }
  public void setDegrees(double degrees) {
    angleController.setSetpoint(degrees);
  }

  //PID Source for gear angle pot
  public class gearAnglePIDSource implements PIDSource {
    @Override
    public double pidGet() {
      return potToDegrees(gearAnglePot.getAverageVoltage());
    }
    public PIDSourceType getPIDSourceType() {
      return PIDSourceType.kDisplacement;
    }
    public void setPIDSourceType(PIDSourceType type) {
    }
  }

  public class gearAnglePIDOutput implements PIDOutput {
    @Override
    public void pidWrite(double output) {
      setGearAngleMotorSpeed(output);
    }
  }
}
