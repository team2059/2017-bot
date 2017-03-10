package org.usfirst.frc.team2059.robot.commands.auto;
import org.usfirst.frc.team2059.robot.commands.CommandBase;
import org.usfirst.frc.team2059.robot.subsystems.GearCollector;

public class AutoSetGearAngle extends CommandBase {
  double speed;
  public AutoSetGearAngle(double s, double timeout){
    speed = s;
    setTimeout(timeout);
  }

  protected void initialize() {
  }

  protected void execute() {
    CommandBase.gearCollector.setGearAngleMotorSpeed(speed);
  }

  protected boolean isFinished() {
    return isTimedOut();
  }

  protected void end() {
    CommandBase.gearCollector.setGearAngleMotorSpeed(0);
  }

  protected void interrupted() {
    end();
  }


}
