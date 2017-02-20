package org.usfirst.frc.team2059.robot.commands.drivetrain;
import org.usfirst.frc.team2059.robot.commands.CommandBase;
import org.usfirst.frc.team2059.robot.Robot;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class DriveStraightX extends CommandBase {
  double speed;
  public DriveStraightX(double s) {
    requires(driveBase);
    speed = s;
  }
  protected void initialize() {
    driveBase.resetGyro();
    driveBase.resetyEncoderCount();
  }
  protected void execute() {
    driveBase.driveStraightX(speed, SmartDashboard.getNumber("GyroCorrection"));
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
