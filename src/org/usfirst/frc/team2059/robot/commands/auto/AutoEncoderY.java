package org.usfirst.frc.team2059.robot.commands.auto;
import org.usfirst.frc.team2059.robot.commands.CommandBase;
import org.usfirst.frc.team2059.robot.Robot;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class AutoEncoderY extends CommandBase {
  public AutoEncoderY() {
    requires(driveBase);
  }
  protected void initialize() {
    driveBase.resetyEncoderCount();
    driveBase.resetGyro();
  }
  protected void execute() {
    driveBase.yPidDrive(256, SmartDashboard.getNumber("GyroCorrection"));
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
