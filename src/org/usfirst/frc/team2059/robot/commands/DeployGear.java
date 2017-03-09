package org.usfirst.frc.team2059.robot.commands;
import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc.team2059.robot.subsystems.Collector;


public class DeployGear extends CommandGroup{
  public DeployGear(){
    addSequential(new SetGearAngleCollect(1));
    addParallel(new CollectGear(-1));
  }
}
