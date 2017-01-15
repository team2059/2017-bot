package org.usfirst.frc.team2059.robot.subsystems;
import org.usfirst.frc.team2059.robot.RobotMap;
import org.usfirst.frc.team2059.robot.commands.drivetrain.Drive;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.PIDController;
import com.ctre.CANTalon;

public class DriveBase extends Subsystem {
  CANTalon leftFrontMotor = new CANTalon(RobotMap.driveLeftFrontMotor);
  CANTalon leftRearMotor = new CANTalon(RobotMap.driveLeftRearMotor);
  CANTalon rightFrontMotor = new CANTalon(RobotMap.driveRightFrontMotor);
  CANTalon rightRearMotor = new CANTalon(RobotMap.driveRightRearMotor);
  Encoder xEncoder = new Encoder(RobotMap.xEncoderA, RobotMap.xEncoderB, false, Encoder.EncodingType.k2X);
  PIDController xEncoderController = new PIDController(0.02, 0.002, 0.017, xEncoder, new xEncoderPIDOutput());
  public void initDefaultCommand() {
    setDefaultCommand(new Drive());
  }
  public void driveMecanum(double x, double y, double z, double s) {
	  if(x<0.1 && x>-0.1){x=0;}
	  if(y<0.05 && y>-0.1){y=0;}
	  if(z<0.1 && z>-0.1){z=0;}
	  x=-x*s;
	  y=y*s;
	  z=-z*s;
    rightFrontMotor.set(-x + y - z);
    leftFrontMotor.set(-(x + y + z));
    rightRearMotor.set(x + y - z);
    leftRearMotor.set(-(-x + y + z));
  }
  public double getxEncoderCount(){
    return xEncoder.get();
  }
  public void resetxEncoderCount(){
    xEncoder.reset();
  }

  public PIDController getxEncoderController(){
    return xEncoderController;
  }
  public class xEncoderPIDOutput implements PIDOutput{
    @Override
    public void pidWrite(double output){
      driveMecanum(output*.25,0,0,1);
    }
  }
}
// vim: sw=2:ts=2:sts=2
