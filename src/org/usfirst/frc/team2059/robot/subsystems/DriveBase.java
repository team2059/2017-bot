package org.usfirst.frc.team2059.robot.subsystems;
import org.usfirst.frc.team2059.robot.RobotMap;
import org.usfirst.frc.team2059.robot.commands.drivetrain.Drive;
import edu.wpi.first.wpilibj.command.Subsystem;
import com.ctre.CANTalon;
public class DriveBase extends Subsystem{
	  public void initDefaultCommand(){
		    setDefaultCommand(new Drive());
      }
}
// vim: sw=2:ts=2:sts=2