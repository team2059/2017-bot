package org.usfirst.frc.team2059.robot.commands.drivetrain;
import org.usfirst.frc.team2059.robot.commands.CommandBase;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc.team2059.robot.Robot;
/**
 *
 */
public class PIDDrive extends CommandBase {
  double count;
  public PIDDrive(double c) {
    requires(driveBase);
    count = c;
  }
  // Called just before this Command runs the first time
  protected void initialize() {
  }
  // Called repeatedly when this Command is scheduled to run
  protected void execute() {
    driveBase.pidDrive(count);
  }
  // Make this return true when this Command no longer needs to run execute()
  protected boolean isFinished() {
    return false;
  }
  // Called once after isFinished returns true
  protected void end() {
  }
  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  protected void interrupted() {
  }
}
// vim: sw=2:ts=2:sts=2
