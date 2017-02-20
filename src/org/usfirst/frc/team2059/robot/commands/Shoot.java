package org.usfirst.frc.team2059.robot.commands;

import org.usfirst.frc.team2059.robot.subsystems.Shooter;
import org.usfirst.frc.team2059.robot.Robot;

public class Shoot extends CommandBase {
	  double speed;
	  public Shoot(double s) {
	    speed = s;
	  }
	  protected void initialize() {
	  }

	  protected void execute() {
      shooter.agitateBalls(1.0);
	    shooter.shootAtSpeed(-Robot.oi.getJoystickThrottle(0));
	    shooter.feed(speed);
	  }

	  protected boolean isFinished() {
	    return false;
	  }

	  protected void end() {
      shooter.agitateBalls(0);
	    shooter.shootAtSpeed(0);
	    shooter.feed(0);
	  }

	  protected void interrupted() {
	    end();
	  }

}
