package org.usfirst.frc.team2059.robot.commands.auto;
import org.usfirst.frc.team2059.robot.commands.CommandBase;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;
import org.usfirst.frc.team2059.robot.Robot;
public class RoutineRightGearPeg extends CommandGroup {
  public RoutineRightGearPeg() {
    addSequential(new AutoGoToCoords(-20,0,1)); //test
    addSequential(new AutoRotate(30, 2));
    addSequential(new AutoGoToCoords(SmartDashboard.getNumber("AutoXTarget"),SmartDashboard.getNumber("AutoYTarget"),5)); //test
    addSequential(new AutoDriveIntoPeg(25, 3));
    addParallel(new AutoSetGearAngle(-36, .5));
    addSequential(new AutoEncoderY(-40, 3));
  }
}
