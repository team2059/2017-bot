package org.usfirst.frc.team2059.robot.commands.auto;
import org.usfirst.frc.team2059.robot.commands.CommandBase;
import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc.team2059.robot.Robot;
public class RoutineCenterGearPeg extends CommandGroup {
  public RoutineCenterGearPeg() {
    //Drive forward for 24 units (inches???) with a timeout of 4 
    addSequential(new AutoEncoderX(24, 5));
    //Drive backward for 12 units (inches???) with a timeout of 2 
    addSequential(new AutoEncoderX(-12, 5));
    //Strafe to the right for 36 with a timeout of 5
    addSequential(new AutoEncoderY(-36, 5));
    //Drive forward for 48 inches with a timeout of 6
    addSequential(new AutoEncoderX(48, 5));
  }
}
