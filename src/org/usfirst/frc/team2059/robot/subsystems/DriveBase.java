package org.usfirst.frc.team2059.robot.subsystems;
import org.usfirst.frc.team2059.robot.RobotMap;
import org.usfirst.frc.team2059.robot.commands.drivetrain.Drive;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.PIDController;
import com.ctre.CANTalon;

public class DriveBase extends Subsystem {
  boolean driveEnabled = true;
  CANTalon leftFrontMotor = new CANTalon(RobotMap.driveLeftFrontMotor);
  CANTalon leftRearMotor = new CANTalon(RobotMap.driveLeftRearMotor);
  CANTalon rightFrontMotor = new CANTalon(RobotMap.driveRightFrontMotor);
  CANTalon rightRearMotor = new CANTalon(RobotMap.driveRightRearMotor);
  Encoder xEncoder = new Encoder(RobotMap.xEncoderA, RobotMap.xEncoderB, false, Encoder.EncodingType.k2X);
  Encoder yEncoder = new Encoder(RobotMap.yEncoderA, RobotMap.yEncoderB, false, Encoder.EncodingType.k2X);
  PIDController xEncoderController = new PIDController(0.02, 0.002, 0.017, xEncoder, new xEncoderPIDOutput());
  PIDController yEncoderController = new PIDController(0.02, 0.002, 0.017, yEncoder, new yEncoderPIDOutput());
  AnalogGyro gyro = new AnalogGyro(RobotMap.gyro);
  double correctedGyroAngle = .1;
  public void initDefaultCommand() {
    setDefaultCommand(new Drive());
  }
  public void driveMecanum(double x, double y, double z) {
    if(driveEnabled){
      rightFrontMotor.set(-x + y - z);
      leftFrontMotor.set(-(x + y + z));
      rightRearMotor.set(x + y - z);
      leftRearMotor.set(-(-x + y + z));
    }
  }
  public void setDriveEnabled(boolean enabled){
    driveEnabled = enabled;
  }
  public void driveMecanum(double x, double y, double z, double sensitivity) {
    if(driveEnabled){
      if(x<0.1 && x>-0.1){x=0;}
      if(y<0.05 && y>-0.1){y=0;}
      if(z<0.1 && z>-0.1){z=0;}
      x=-x*sensitivity;
      y=y*sensitivity;
      z=-z*sensitivity;
      rightFrontMotor.set(-x + y - z);
      leftFrontMotor.set(-(x + y + z));
      rightRearMotor.set(x + y - z);
      leftRearMotor.set(-(-x + y + z));
    }
  }
  public double getxEncoderCount(){
    return xEncoder.get();
  }
  public double getyEncoderCount(){
    return yEncoder.get();
  }
  public void resetxEncoderCount(){
    xEncoder.reset();
  }
  public void resetyEncoderCount(){
    yEncoder.reset();
  }
  public PIDController getxEncoderController(){
    return xEncoderController;
  }
  public PIDController getyEncoderController(){
    return yEncoderController;
  }
  public void resetGyro(){
    gyro.reset();
  }
  public AnalogGyro getGyro(){
    return gyro;
  }
  public class xEncoderPIDOutput implements PIDOutput{
    @Override
    public void pidWrite(double output){
      driveMecanum(output*.25,0,0,1);
    }
  }
  public class yEncoderPIDOutput implements PIDOutput{
    @Override
    public void pidWrite(double output){
      driveMecanum(0,output,correctedGyroAngle);
    }
  }
  public double GetxEncoderDistance(){
	  double x=this.getxEncoderCount();
	  double z=(x/256)*12.66;
	  
	  return z;
  }
  public double GetyEncoderDistance(){
	  double x=this.getxEncoderCount();
	  double z=(x/256)*12.66;
	  
	  return z;
  }
  public void yPidDrive(double setpoint, double correction) {
      //Reset gyro so it drives straight in whatever direction
      resetGyro();
	    yEncoderController.enable();
	    yEncoderController.setSetpoint(setpoint);
      correctedGyroAngle = -gyro.getAngle() * correction;
	  }
}
// vim: sw=2:ts=2:sts=2
