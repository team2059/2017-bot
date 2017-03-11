package org.usfirst.frc.team2059.robot.commands.auto;
import org.usfirst.frc.team2059.robot.commands.CommandBase;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;
import org.usfirst.frc.team2059.robot.Robot;
public class RoutineCenterGearPeg extends CommandGroup {
  public RoutineCenterGearPeg() {
      addSequential(new AutoEncoderY(84, 4));
      addSequential(new AutoSetGearAngle(-.7,.2));
      addSequential(new AutoEncoderY(-60, 3));
      addSequential(new AutoSetGearAngle(1,.4));
//    if(CommandBase.visionHelper.getCenterContourX()!=0){
//      addSequential(new AutoDriveIntoPeg(84, 4));
//      addSequential(new AutoSetGearAngle(-.7,.2));
//      addSequential(new AutoEncoderY(-60, 3));
//      addSequential(new AutoSetGearAngle(1,.4));
//    }
  //  addSequential(new AutoRotate(65,2));
    //Drive forward for 24 units (inches???) with a timeout of 4
//    addSequential(new AutoEncoderY(12, 5));
//    //Wait
//
//    addSequential(new WaitCommand(2));
//    //Drive backward for 12 units (inches???) with a timeout of 2
//    addSequential(new AutoEncoderY(-36, 5));
    //Strafe to the right for 36 with a timeout of 5
//    addSequential(new AutoEncoderX(-12, 5));
//    addSequential(new WaitCommand(2));
//    addSequential(new AutoEncoderX(12, 5));
    //Drive forward for 48 inches with a timeout of 6
//   addSequential(new AutoEncoderY(48, 5));
  }
}
