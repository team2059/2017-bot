package org.usfirst.frc.team2059.robot.commands;
import org.usfirst.frc.team2059.robot.subsystems.Collector;


public class CollectAll extends CommandBase {
  double speed;
  public CollectAll(double s) {
    speed = s;
  }

  protected void initialize() {
  }

  protected void execute() {
    collector.collectAtSpeed(speed);
    gearCollector.gearCollectAtSpeed(-speed);
  }

  protected boolean isFinished() {
    return false;
  }

  protected void end() {
    collector.collectAtSpeed(0);
    gearCollector.gearCollectAtSpeed(0);
  }

  protected void interrupted() {
    end();
  }
}
