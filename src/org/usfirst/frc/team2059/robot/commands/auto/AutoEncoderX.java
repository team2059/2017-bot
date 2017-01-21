package org.usfirst.frc.team2059.robot.commands.auto;
import org.usfirst.frc.team2059.robot.commands.CommandBase;
import org.usfirst.frc.team2059.robot.Robot;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class AutoEncoderX extends CommandBase {
  public AutoEncoderX() {
    requires(driveBase);
 
  }
  protected void initialize() {
	  driveBase.getxEncoderController().reset();
  }
  protected void execute() {
  	driveBase.xPidDrive(256, SmartDashboard.getNumber("GyroCorrection"));
  }
  protected boolean isFinished() {
    return isTimedOut();
  }
  protected void end() {
    driveBase.driveMecanum(0, 0, 0, 0);
  }
  protected void interrupted() {
  }
}
