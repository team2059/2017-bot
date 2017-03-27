package org.usfirst.frc.team2059.robot.commands;
import org.usfirst.frc.team2059.robot.subsystems.GearCollector;

public class SetGearAngle extends CommandBase {
  double degrees;
  public SetGearAngle(double d){
    degrees = d;
  }

  protected void initialize() {
  }

  protected void execute() {
    gearCollector.setDegrees(degrees);
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
