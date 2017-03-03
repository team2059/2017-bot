package org.usfirst.frc.team2059.robot.commands;

import org.usfirst.frc.team2059.robot.subsystems.Shooter;

public class SetDeflectorUp extends CommandBase {
  boolean state;
  public SetDeflectorUp(boolean s) {
    state = s;
  }
  protected void initialize() {
    shooter.setDeflectorUp(state);
  }

  protected void execute() {
  }

  protected boolean isFinished() {
    return true;
  }

  protected void end() {
    shooter.setDeflectorUp(!state);
  }

  protected void interrupted() {
    end();
  }


}
