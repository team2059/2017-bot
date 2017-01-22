package org.usfirst.frc.team2059.robot.commands.auto;
import org.usfirst.frc.team2059.robot.commands.CommandBase;
import org.usfirst.frc.team2059.robot.Robot;

public class AutoCircleDrive extends CommandBase {
  double radius;
  public AutoCircleDrive(double r) {
    requires(driveBase);
    radius=r;
  }
  protected void initialize() {
  }
  protected void execute() {
    driveBase.circleDrive(radius);
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
