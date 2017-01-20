package org.usfirst.frc.team2059.robot.subsystems;
import org.usfirst.frc.team2059.robot.RobotMap;
import com.ctre.CANTalon;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Climber extends Subsystem{
  CANTalon climberMotor = new CANTalon(RobotMap.climbermotor);

public void initDefaultCommand() {
  }
public void climbAtSpeed(double speed){
  climberMotor.set(speed);
}
}
