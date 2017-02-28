package org.usfirst.frc.team2059.robot.commands;

import org.usfirst.frc.team2059.robot.subsystems.Shooter;

public class SetDeflectorUp extends CommandBase {
  boolean state;
  public SetDeflectorUp(boolean s) {
    state = s;
  }
  protected void initialize() {
  }

  protected void execute() {
    shooter.setDeflectorUp(state);
  }

  protected boolean isFinished() {
    return false;
  }

  protected void end() {
  }

  protected void interrupted() {
    end();
  }


}
