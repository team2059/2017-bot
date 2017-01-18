package org.usfirst.frc.team2059.robot.commands.auto;
import org.usfirst.frc.team2059.robot.commands.CommandBase;
import org.usfirst.frc.team2059.robot.Robot;


public class AutoEncoder extends CommandBase {
  public AutoEncoder() {
    requires(driveBase);
 
  }
  protected void initialize() {
	  driveBase.getxEncoderController().reset();
  }
  protected void execute() {
	driveBase.pidDrive(256);
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