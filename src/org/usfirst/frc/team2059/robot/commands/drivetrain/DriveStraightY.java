package org.usfirst.frc.team2059.robot.commands.drivetrain;
import org.usfirst.frc.team2059.robot.commands.CommandBase;
import org.usfirst.frc.team2059.robot.Robot;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class DriveStraightY extends CommandBase {
  double distance;
  public DriveStraightY(double d) {
    requires(driveBase);
    distance = d;
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
