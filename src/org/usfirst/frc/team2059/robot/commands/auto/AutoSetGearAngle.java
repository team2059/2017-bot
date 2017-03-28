package org.usfirst.frc.team2059.robot.commands.auto;
import org.usfirst.frc.team2059.robot.commands.CommandBase;
import org.usfirst.frc.team2059.robot.subsystems.GearCollector;

public class AutoSetGearAngle extends CommandBase {
  double degrees;
  public AutoSetGearAngle(double d, double timeout) {
    degrees = d;
    setTimeout(timeout);
  }

  protected void initialize() {
  }

  protected void execute() {
    CommandBase.gearCollector.setDegrees(degrees);
  }

  protected boolean isFinished() {
    return isTimedOut();
  }

  protected void end() {
  }

  protected void interrupted() {
    end();
  }


}
