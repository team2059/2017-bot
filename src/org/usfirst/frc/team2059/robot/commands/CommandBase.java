package org.usfirst.frc.team2059.robot.commands;
import org.usfirst.frc.team2059.robot.subsystems.DriveBase;
import org.usfirst.frc.team2059.robot.subsystems.Pneumatics;
import edu.wpi.first.wpilibj.command.Command;
public abstract class CommandBase extends Command {
  public static DriveBase driveBase;
  public static Pneumatics pneumatics;
  public static void init() {
    driveBase = new DriveBase();
    pneumatics = new Pneumatics();
  }
}
// vim: sw=2:ts=2:sts=2
