package org.usfirst.frc.team2059.robot.commands.auto;
import org.usfirst.frc.team2059.robot.commands.CommandBase;
import org.usfirst.frc.team2059.robot.Robot;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class AutoGoToCoords extends CommandBase {
  double x,y;
  public AutoGoToCoords(double xC, double yC, double timeout) {
    requires(driveBase);
    setTimeout(timeout);
    x=xC;
    y=yC;
  }
  protected void initialize() {
    driveBase.resetyEncoderCount();
    driveBase.resetGyro();
    driveBase.resetxEncoderCount();
  }
  protected void execute() {
    driveBase.driveRelativeCoordinates(x,y,SmartDashboard.getNumber("GyroCorrection"));
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
