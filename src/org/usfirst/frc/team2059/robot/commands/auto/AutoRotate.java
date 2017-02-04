package org.usfirst.frc.team2059.robot.commands.auto;
import org.usfirst.frc.team2059.robot.commands.CommandBase;
import org.usfirst.frc.team2059.robot.Robot;

public class AutoRotate extends CommandBase {
  double degrees;
  public AutoRotate (double d, double timeout) {
    requires(driveBase);
    setTimeout(timeout);
    degrees = d;
  }
  protected void initialize() {
    driveBase.resetGyro();
  }
  protected void execute() {
    driveBase.rotateAngle(degrees);
  }
  protected boolean isFinished() {
    return isTimedOut();
  }
  protected void end() {
    driveBase.getGyroController().disable();
    driveBase.driveMecanum(0, 0, 0, 0);
  }
  protected void interrupted() {
  }
}
