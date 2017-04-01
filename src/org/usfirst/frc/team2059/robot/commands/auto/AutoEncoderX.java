package org.usfirst.frc.team2059.robot.commands.auto;
import org.usfirst.frc.team2059.robot.commands.CommandBase;
import org.usfirst.frc.team2059.robot.Robot;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class AutoEncoderX extends CommandBase {
  double distance;
  public AutoEncoderX(double a, double t) {
    requires(driveBase);
    distance = a;
    setTimeout(t);
  }
  protected void initialize() {
    driveBase.resetxEncoderCount();
    driveBase.resetGyro();
    driveBase.resetyEncoderCount();
  }
  protected void execute() {
    driveBase.driveStraightXdistance(distance, SmartDashboard.getNumber("GyroCorrection"));
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
