package org.usfirst.frc.team2059.robot.commands.auto;
import org.usfirst.frc.team2059.robot.commands.CommandBase;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;
import org.usfirst.frc.team2059.robot.Robot;
public class RoutineCenterGearPegFallback extends CommandGroup {
  public RoutineCenterGearPegFallback() {
      addSequential(new AutoEncoderY(SmartDashboard.getNumber("AutoDrivePart1Distance"), 4));
    if(CommandBase.visionHelper.getCenterContourX()!=0){
      addSequential(new AutoDriveIntoPeg(SmartDashboard.getNumber("AutoDrivePart2Distance"), 4));
    }else{
      addSequential(new AutoEncoderY(SmartDashboard.getNumber("AutoDrivePart2Distance"),2));
    }
      addSequential(new WaitCommand(.3));
      addParallel(new AutoSetGearAngle(-.3,.8));
      addSequential(new AutoEncoderY(-60, 3));
      addSequential(new AutoSetGearAngle(0.5,.4));
  }
}
