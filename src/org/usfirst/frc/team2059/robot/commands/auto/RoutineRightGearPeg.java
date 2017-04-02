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
    addSequential(new AutoEncoderY(84, 2));
    addSequential(new AutoRotate(60, 1.5));
    addSequential(new AutoEncoderY(99, 2));
    addParallel(new AutoSetGearAngle(-36, .5));
    addSequential(new AutoEncoderY(-40, 3));
  }
}
