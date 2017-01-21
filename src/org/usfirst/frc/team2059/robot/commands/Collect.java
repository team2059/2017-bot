package org.usfirst.frc.team2059.robot.commands;
import org.usfirst.frc.team2059.robot.subsystems.Collector;


public class Collect extends CommandBase {
  double speed;
  public Collect(double s) {
    speed = s;
  }

  protected void initialize(){
  }

  protected void execute() {
    collector.collectAtSpeed(speed);
  }

  protected boolean isFinished() {
    return false;
  }

  protected void end() {
    collector.collectAtSpeed(0);
  }

  protected void interrupted() {
    end();
  }
}
