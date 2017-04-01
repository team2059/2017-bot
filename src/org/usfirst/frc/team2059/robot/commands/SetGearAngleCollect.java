package org.usfirst.frc.team2059.robot.commands;
import org.usfirst.frc.team2059.robot.subsystems.GearCollector;

public class SetGearAngleCollect extends CommandBase {
  double speed;
  public SetGearAngleCollect(double s) {
    speed = s;
  }

  protected void initialize() {
    gearCollector.getAngleController().enable();
    gearCollector.setEncoderTarget(-34);
  }

  protected void execute() {
  }

  protected boolean isFinished() {
    return false;
  }

  protected void end() {
    gearCollector.getAngleController().disable();
  }

  protected void interrupted() {
    end();
  }


}
