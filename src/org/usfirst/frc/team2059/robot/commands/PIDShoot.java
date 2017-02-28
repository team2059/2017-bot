package org.usfirst.frc.team2059.robot.commands;

import org.usfirst.frc.team2059.robot.subsystems.Shooter;

public class PIDShoot extends CommandBase {

  public PIDShoot() {
  }
  protected void initialize() {
  }

  protected void execute() {
    shooter.PidShoot(1000);
    shooter.feed(1.0);
  }

  protected boolean isFinished() {
    return false;
  }

  protected void end() {
    shooter.shootAtSpeed(0);
  }

  protected void interrupted() {
    end();
  }
}
