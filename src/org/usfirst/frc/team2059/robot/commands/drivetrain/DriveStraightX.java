package org.usfirst.frc.team2059.robot.commands.drivetrain;
import org.usfirst.frc.team2059.robot.commands.CommandBase;
import org.usfirst.frc.team2059.robot.Robot;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class DriveStraightX extends CommandBase {
  double distance;
  public DriveStraightX(double d) {
    requires(driveBase);
    distance = d;
  }
  protected void initialize() {
    driveBase.resetGyro();
    driveBase.resetyEncoderCount();
    driveBase.resetxEncoderCount();
  }
  protected void execute() {
  }
  protected boolean isFinished() {
    return true;
  }
  protected void end() {
  }
  protected void interrupted() {
  }
}
