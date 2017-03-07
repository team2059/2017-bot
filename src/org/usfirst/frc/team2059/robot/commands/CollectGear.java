package org.usfirst.frc.team2059.robot.commands;
import org.usfirst.frc.team2059.robot.subsystems.GearRollerMotor;

public class CollectGear extends CommandBase {
  double speed;
  public CollectGear(double s) {
    speed = s;
  }

  protected void initialize() {
  }

  protected void execute() {
    gearRoller.gearCollectAtSpeed(speed);
  }

  protected boolean isFinished() {
    return false;
  }

  protected void end() {
    gearRoller.gearCollectAtSpeed(0);
  }

  protected void interrupted() {
    end();
}
}
