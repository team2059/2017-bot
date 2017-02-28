package org.usfirst.frc.team2059.robot.commands.drivetrain;
import org.usfirst.frc.team2059.robot.commands.CommandBase;
import org.usfirst.frc.team2059.robot.Robot;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class AutoDriveStraightY extends CommandBase {
  double distance, timeout;
  public AutoDriveStraightY(double d, double to) {
    requires(driveBase);
    distance = d;
    timeout = to;
  }
  protected void initialize() {
    driveBase.resetGyro();
    driveBase.resetyEncoderCount();
    driveBase.resetxEncoderCount();
  }
  protected void execute() {
    driveBase.getyEncoderController().setSetpoint(distance);
  }
  protected boolean isFinished() {
    return isTimedOut();
  }
  protected void end() {
    driveBase.resetGyro();
    driveBase.getxEncoderController().disable();
    driveBase.getyEncoderController().disable();
  }
  protected void interrupted() {
  }
}
