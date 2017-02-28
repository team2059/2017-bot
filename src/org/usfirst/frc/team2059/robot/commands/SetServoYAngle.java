package org.usfirst.frc.team2059.robot.commands;
import org.usfirst.frc.team2059.robot.subsystems.VisionHelper;

public class SetServoYAngle extends CommandBase {
  double angle;

  public SetServoYAngle(double s) {
    angle = s;
  }

  protected void initialize() {
  }

  protected void execute() {
    visionHelper.setServoAngleY(angle);
  }

  protected boolean isFinished() {
    return false;
  }

  protected void end() {
  }

  protected void interrupted() {
    end();
  }
}
