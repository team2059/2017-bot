package org.usfirst.frc.team2059.robot.commands;
import org.usfirst.frc.team2059.robot.subsystems.DriveBase;
import org.usfirst.frc.team2059.robot.subsystems.Pneumatics;
import org.usfirst.frc.team2059.robot.subsystems.Climber;
import org.usfirst.frc.team2059.robot.subsystems.Collector;
import edu.wpi.first.wpilibj.command.Command;
public abstract class CommandBase extends Command {
  public static DriveBase driveBase;
  public static Pneumatics pneumatics;
  public static Climber climber;
  public static Collector collector;
  public static void init() {
    driveBase = new DriveBase();
    pneumatics = new Pneumatics();
    climber = new Climber();
    collector = new Collector();
  }
}
// vim: sw=2:ts=2:sts=2
