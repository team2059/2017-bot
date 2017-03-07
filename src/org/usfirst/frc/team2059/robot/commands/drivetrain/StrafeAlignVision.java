package org.usfirst.frc.team2059.robot.commands.drivetrain;
import org.usfirst.frc.team2059.robot.commands.CommandBase;
import org.usfirst.frc.team2059.robot.Robot;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class StrafeAlignVision extends CommandBase {
  double distance;
  public StrafeAlignVision() {
    requires(driveBase);
  }
  protected void initialize() {
    distance = visionHelper.getTranslationDistance();
    driveBase.resetyEncoderCount();
    driveBase.resetxEncoderCount();
    driveBase.resetGyro();
  }
  protected void execute() {
    driveBase.driveStraightX(distance, SmartDashboard.getNumber("GyroCorrection"));
  }
  protected boolean isFinished() {
    return false;
  }
  protected void end() {
    driveBase.driveMecanum(0, 0, 0, 0);
  }
  protected void interrupted() {
    end();
  }
}
