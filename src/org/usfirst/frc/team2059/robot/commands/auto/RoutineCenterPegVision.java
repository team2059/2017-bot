package org.usfirst.frc.team2059.robot.commands.auto;
import org.usfirst.frc.team2059.robot.commands.CommandBase;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;
import org.usfirst.frc.team2059.robot.Robot;
public class RoutineCenterPegVision extends CommandGroup {
  public RoutineCenterPegVision() {
      //Drive forwards halfway to target
      addSequential(new AutoEncoderY(40,1.5));
      //look for target/drive into it
      addSequential(new AutoDriveIntoPeg(44,1.5));
      //drop gear off on peg
      addSequential(new AutoSetGearAngle(0,.4));
      //back up 
      addSequential(new AutoEncoderY(-60, 3));
      //raise collector
      addSequential(new AutoSetGearAngle(90,1));

//    if(CommandBase.visionHelper.getCenterContourX()!=0){
//      addSequential(new AutoDriveIntoPeg(84, 4));
//      addSequential(new AutoSetGearAngle(-.7,.2));
//      addSequential(new AutoEncoderY(-60, 3));
//      addSequential(new AutoSetGearAngle(1,.4));
//    }
  }
}
