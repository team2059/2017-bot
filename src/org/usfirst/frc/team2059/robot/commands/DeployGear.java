package org.usfirst.frc.team2059.robot.commands;
import org.usfirst.frc.team2059.robot.subsystems.GearCollector;

public class DeployGear extends CommandBase {
  public DeployGear(){
  }

  protected void initialize() {
  }

  protected void execute() {
    gearCollector.setDeployMode(true);
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
