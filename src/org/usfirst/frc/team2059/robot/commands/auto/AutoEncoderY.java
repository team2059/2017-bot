package org.usfirst.frc.team2059.robot.commands.auto;
import org.usfirst.frc.team2059.robot.commands.CommandBase;
import org.usfirst.frc.team2059.robot.Robot;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class AutoEncoderY extends CommandBase {
  double distance;
  public AutoEncoderY(double a, double timeout) {
    requires(driveBase);
    setTimeout(timeout);
    distance = a;
  }
  protected void initialize() {
    driveBase.resetyEncoderCount();
    driveBase.resetGyro();
    driveBase.resetxEncoderCount();
  }
  protected void execute() {
    gearCollector.setGearAngleMotorSpeed(.5);
    driveBase.driveStraightYdistance(distance, SmartDashboard.getNumber("GyroCorrection"));
  }
  protected boolean isFinished() {
    return isTimedOut();
  }
  protected void end() {
    gearCollector.setGearAngleMotorSpeed(0);
    driveBase.driveMecanum(0, 0, 0, 0);
  }
  protected void interrupted() {
  }
}
