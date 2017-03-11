package org.usfirst.frc.team2059.robot.commands.auto;
import org.usfirst.frc.team2059.robot.commands.CommandBase;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;
import org.usfirst.frc.team2059.robot.Robot;
public class RoutineRightGearPeg extends CommandGroup {
  public RoutineRightGearPeg() {
    addSequential(new AutoEncoderY(80,4));
    addSequential(new AutoRotate(-60,2));
    if(CommandBase.visionHelper.getCenterContourX()!=0){
      addSequential(new AutoDriveIntoPeg(73,4));
    }
  }
}
