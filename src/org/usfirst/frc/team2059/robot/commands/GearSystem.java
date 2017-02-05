package org.usfirst.frc.team2059.robot.commands;
import org.usfirst.frc.team2059.robot.subsystems.GearCollector;


public class GearSystem extends CommandBase {
  double speed;
  public GearSystem(double s) {
    speed = s;
  }

  protected void initialize() {
  }

  protected void execute() {
    gearCollector.gearCollectAtSpeed(speed);
  }

  protected boolean isFinished() {
    return false;
  }

  protected void end() {
    gearCollector.gearCollectAtSpeed(0);
  }

  protected void interrupted() {
    end();
  }
}
