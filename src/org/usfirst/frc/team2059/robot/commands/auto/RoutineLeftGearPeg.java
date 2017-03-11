package org.usfirst.frc.team2059.robot.commands.auto;
import org.usfirst.frc.team2059.robot.commands.CommandBase;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;
import org.usfirst.frc.team2059.robot.Robot;
public class RoutineLeftGearPeg extends CommandGroup {
  public RoutineLeftGearPeg() {
    addSequential(new AutoEncoderY(93,4));
    addSequential(new AutoRotate(-30,2));
    if(CommandBase.visionHelper.getCenterContourX()!=0){
      addSequential(new AutoDriveIntoPeg(73,4));
    }
  }
}
