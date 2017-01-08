package org.usfirst.frc.team2059.robot.subsystems;
import org.usfirst.frc.team2059.robot.RobotMap;
import org.usfirst.frc.team2059.robot.commands.drivetrain.Drive;
import edu.wpi.first.wpilibj.command.Subsystem;
import com.ctre.CANTalon;
public class DriveBase extends Subsystem{
	  CANTalon leftFrontMotor = new CANTalon(RobotMap.driveLeftFrontMotor);
	  CANTalon leftRearMotor = new CANTalon(RobotMap.driveLeftRearMotor);
	  CANTalon rightFrontMotor = new CANTalon(RobotMap.driveRightFrontMotor);
	  CANTalon rightRearMotor = new CANTalon(RobotMap.driveRightRearMotor);
	  public void initDefaultCommand(){
		    setDefaultCommand(new Drive());
      }
}
// vim: sw=2:ts=2:sts=2