package org.usfirst.frc.team2059.robot.commands;
import org.usfirst.frc.team2059.robot.subsystems.GearCollector;

public class SetGearAngleCollect extends CommandBase {
  double speed;
  public SetGearAngleCollect(double s){
    speed = s;
  }

  protected void initialize() {
  }

  protected void execute() {
    gearCollector.setGearAngleMotorSpeed(speed);
  }

  protected boolean isFinished() {
    return false;
  }

  protected void end() {
    gearCollector.setGearAngleMotorSpeed(0);
  }

  protected void interrupted() {
    end();
  }


}
