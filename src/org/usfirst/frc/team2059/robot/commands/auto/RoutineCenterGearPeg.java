package org.usfirst.frc.team2059.robot.commands.auto;
import org.usfirst.frc.team2059.robot.commands.CommandBase;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;
import org.usfirst.frc.team2059.robot.Robot;
public class RoutineCenterGearPeg extends CommandGroup {
  public RoutineCenterGearPeg() {
      addSequential(new AutoEncoderY(94, 2.2));
      addSequential(new WaitCommand(.1));
      addParallel(new AutoSetGearAngle(0,.5));
      addSequential(new AutoEncoderY(-60, 3));
  }
}
