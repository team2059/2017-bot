package org.usfirst.frc.team2059.robot.commands.auto;
import org.usfirst.frc.team2059.robot.commands.CommandBase;
import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc.team2059.robot.Robot;
public class RoutineLeftGearPeg extends CommandGroup {
  public RoutineLeftGearPeg() {
    addSequential(new AutoEncoderY(256));
  }
}
