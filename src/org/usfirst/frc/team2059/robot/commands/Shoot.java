package org.usfirst.frc.team2059.robot.commands;

import org.usfirst.frc.team2059.robot.subsystems.Shooter;

public class Shoot extends CommandBase {
	  double speed;
	  public Shoot(double s) {
	    speed = s;
	  }
	  protected void initialize() {
	  }

	  protected void execute() {
	    shooter.shootAtSpeed(speed);
	    shooter.feed(speed);
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
