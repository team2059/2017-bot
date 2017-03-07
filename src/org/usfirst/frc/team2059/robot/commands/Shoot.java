package org.usfirst.frc.team2059.robot.commands;

import org.usfirst.frc.team2059.robot.subsystems.Shooter;
import org.usfirst.frc.team2059.robot.Robot;

public class Shoot extends CommandBase {
  double speed;
  boolean highgoal;
  public Shoot(double s, boolean high) {
    speed = s;
    highgoal = high;
  }
  protected void initialize() {
  }

  protected void execute() {
    if (highgoal) {
      shooter.setDeflectorAngle(180);
    }
    shooter.shootAtSpeed(speed);
    shooter.agitateBalls(1.0);
    shooter.feed(speed);
    shooter.setFeederServoOpen(true);
  }

  protected boolean isFinished() {
    return false;
  }

  protected void end() {
    shooter.setDeflectorAngle(0);
    shooter.setFeederServoOpen(false);
    shooter.getCIMEncoderController().disable();
    shooter.agitateBalls(0);
    shooter.feed(0);
  }

  protected void interrupted() {
    end();
  }

}
