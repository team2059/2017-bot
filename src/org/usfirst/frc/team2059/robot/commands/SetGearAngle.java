package org.usfirst.frc.team2059.robot.commands;
import org.usfirst.frc.team2059.robot.subsystems.GearAngleMotor;

public class SetGearAngle extends CommandBase {
  double speed;
  public SetGearAngle(double s){
    speed = s;
  }

  protected void initialize() {
  }

  protected void execute() {
    gearAngle.gearAngleSetTo(speed);
  }

  protected boolean isFinished() {
    return false;
  }

  protected void end() {
    gearAngle.gearAngleSetTo(0);
  }

  protected void interrupted() {
    end();
  }


}
