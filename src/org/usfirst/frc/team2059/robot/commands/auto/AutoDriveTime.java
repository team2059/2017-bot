package org.usfirst.frc.team2059.robot.commands.auto;
import org.usfirst.frc.team2059.robot.commands.CommandBase;
import org.usfirst.frc.team2059.robot.Robot;

public class AutoDriveTime extends CommandBase {
  double speed;
  public AutoDriveTime(double s, double driveTime) {
    speed = s;
    requires(driveBase);
    setTimeout(driveTime);
  }
  protected void initialize() {
  }
  protected void execute() {
    driveBase.driveMecanum(0, speed, 0, 0.8);
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
