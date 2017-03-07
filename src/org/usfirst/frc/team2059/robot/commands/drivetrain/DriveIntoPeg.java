package org.usfirst.frc.team2059.robot.commands.drivetrain;
import org.usfirst.frc.team2059.robot.commands.CommandBase;
import org.usfirst.frc.team2059.robot.Robot;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class DriveIntoPeg extends CommandBase {
  double angle, distance;
  public DriveIntoPeg() {
    requires(driveBase);
  }
  protected void initialize() {
    angle = visionHelper.getHorizontalError();
    //Subtract 10 to stop 10 inches from wall
    distance = visionHelper.getSonar()-10;
    driveBase.resetyEncoderCount();
    driveBase.resetxEncoderCount();
    driveBase.resetGyro();
  }
  protected void execute() {
    driveBase.driveStraightY(distance, SmartDashboard.getNumber("GyroCorrection"), angle);
  }
  protected boolean isFinished() {
    false;
  }
  protected void end() {
    driveBase.driveMecanum(0, 0, 0, 0);
  }
  protected void interrupted() {
    end();
  }
}
