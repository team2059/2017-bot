package org.usfirst.frc.team2059.robot.commands.auto;
import org.usfirst.frc.team2059.robot.commands.CommandBase;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;
import org.usfirst.frc.team2059.robot.Robot;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
public class RoutineLeftGearPeg extends CommandGroup {
  public RoutineLeftGearPeg() {
    addSequential(new AutoGoToCoords(20,0,1)); //test
    addSequential(new AutoRotate(-30, 2));
    addSequential(new AutoGoToCoords(48,94,4)); //test
    addSequential(new AutoDriveIntoPeg(25, 3));
    addParallel(new AutoSetGearAngle(-36, .5));
    addSequential(new AutoEncoderY(-40, 3));
  }
}
