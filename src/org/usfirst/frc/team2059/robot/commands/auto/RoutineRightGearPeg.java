package org.usfirst.frc.team2059.robot.commands.auto;
import org.usfirst.frc.team2059.robot.commands.CommandBase;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;
import org.usfirst.frc.team2059.robot.Robot;
public class RoutineRightGearPeg extends CommandGroup {
  public RoutineRightGearPeg() {
    addSequential(new AutoSetGearAngle(0, .1));
    addSequential(new AutoEncoderY(70, 3));
    addSequential(new AutoRotate(-60, 2.5));
    addSequential(new AutoEncoderY(50, 3));
    addSequential(new AutoDriveIntoPeg(40, 2));
    addParallel(new AutoSetGearAngle(-36, .5));
    addSequential(new AutoEncoderY(-50, 3));
  }
}
