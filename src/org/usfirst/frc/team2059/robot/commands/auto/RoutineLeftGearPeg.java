package org.usfirst.frc.team2059.robot.commands.auto;
import org.usfirst.frc.team2059.robot.commands.CommandBase;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;
import org.usfirst.frc.team2059.robot.Robot;
public class RoutineLeftGearPeg extends CommandGroup {
  public RoutineLeftGearPeg() {
//    //addSequential(new AutoEncoderY(93,4));
//    addSequential(new AutoEncoderY(40, 3));
//    addSequential(new AutoRotate(45, 1.5));
//    addSequential(new AutoEncoderY(40, 2));
//    addSequential(new AutoDriveIntoPeg(35, 2));
//    addSequential(new AutoDriveIntoPeg(40, 2));
//    addSequential(new AutoEncoderY(-75, 3));
//    addSequential(new AutoRotate(-45, 2));
    addSequential(new AutoEncoderY(20,1));
    addSequential(new AutoRotate(45,1));
    addSequential(new AutoGoToCoords(50,50,4)); //test
  }
}
