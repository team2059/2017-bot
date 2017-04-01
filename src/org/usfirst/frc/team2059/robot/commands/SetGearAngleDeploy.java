package org.usfirst.frc.team2059.robot.commands;
import org.usfirst.frc.team2059.robot.subsystems.GearCollector;

public class SetGearAngleDeploy extends CommandBase {
  double speed;
  public SetGearAngleDeploy(double s) {
    speed = s;
  }

  protected void initialize() {
    gearCollector.getAngleController().enable();
    gearCollector.setEncoderTarget(0);
  }

  protected void execute() {
  }

  protected boolean isFinished() {
    return false;
  }

  protected void end() {
    //gearCollector.getAngleController().disable();
  }

  protected void interrupted() {
    end();
  }


}
