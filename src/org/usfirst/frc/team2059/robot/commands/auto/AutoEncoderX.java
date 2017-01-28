package org.usfirst.frc.team2059.robot.commands.auto;
import org.usfirst.frc.team2059.robot.commands.CommandBase;
import org.usfirst.frc.team2059.robot.Robot;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class AutoEncoderX extends CommandBase {
  double distance;
  public AutoEncoderX(double a) {
    requires(driveBase);
    distance = a;
  }
  protected void initialize() {
    driveBase.resetxEncoderCount();
    driveBase.resetGyro();
    driveBase.resetxEncoderCount();
  }
  protected void execute() {
    driveBase.xPidDrive(distance, SmartDashboard.getNumber("GyroCorrection"));
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
