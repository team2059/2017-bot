package org.usfirst.frc.team2059.robot.commands;

import org.usfirst.frc.team2059.robot.subsystems.Shooter;

public class DeflectorUp extends CommandBase {
	
	  public DeflectorUp() {
	 
	  }
	  protected void initialize() {
	  }

	  protected void execute() {
		  if(shooter.getDeflectorUp()!=true)
			  shooter.moveDeflector(0.5);
		  else
			  this.end();
	  }

	  protected boolean isFinished() {
	    return false;
	  }

	  protected void end() {
	    shooter.moveDeflector(0);
	  }

	  protected void interrupted() {
	    end();
	  }
	

}
