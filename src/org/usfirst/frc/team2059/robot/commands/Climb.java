package org.usfirst.frc.team2059.robot.commands;
import org.usfirst.frc.team2059.robot.subsystems.Climber;


public class Climb extends CommandBase {
  double speed;
  public Climb(double s) {
    speed = s;
  }

  protected void initialize(){
  }

  protected void execute() {
    climber.climbAtSpeed(speed);
  }

  protected boolean isFinished() {
    return false;
  }

  protected void end() {
    climber.climbAtSpeed(0);
  }

  protected void interrupted() {
    end();
  }
}
