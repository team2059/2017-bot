package org.usfirst.frc.team2059.robot.commands.auto;
import org.usfirst.frc.team2059.robot.commands.CommandBase;
import org.usfirst.frc.team2059.robot.Robot;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class AutoStrafeAlignVision extends CommandBase {
  public AutoStrafeAlignVision() {
    requires(driveBase);
  }
  protected void initialize() {
    driveBase.resetyEncoderCount();
    driveBase.resetGyro();
    driveBase.getyEncoderController().enable();
  }
  protected void execute() {
    driveBase.yPidDrive(visionHelper.getTranslationDistance(), SmartDashboard.getNumber("GyroCorrection"));
  }
  protected boolean isFinished() {
    return isTimedOut();
  }
  protected void end() {
    driveBase.driveMecanum(0, 0, 0, 0);
    driveBase.getyEncoderController().disable();
  }
  protected void interrupted() {
    driveBase.driveMecanum(0, 0, 0, 0);
    driveBase.getyEncoderController().disable();
  }
}
