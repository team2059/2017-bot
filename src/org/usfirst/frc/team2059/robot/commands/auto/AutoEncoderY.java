package org.usfirst.frc.team2059.robot.commands.auto;
import org.usfirst.frc.team2059.robot.commands.CommandBase;
import org.usfirst.frc.team2059.robot.Robot;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class AutoEncoderY extends CommandBase {
  double distance;
  public AutoEncoderY(double a) {
    requires(driveBase);
    distance = a;
  }
  protected void initialize() {
    driveBase.resetyEncoderCount();
    driveBase.resetGyro();
    driveBase.resetyEncoderCount();
  }
  protected void execute() {
    driveBase.yPidDrive(distance, SmartDashboard.getNumber("GyroCorrection"));
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
