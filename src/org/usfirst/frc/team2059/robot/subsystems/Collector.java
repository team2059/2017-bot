package org.usfirst.frc.team2059.robot.subsystems;
import org.usfirst.frc.team2059.robot.RobotMap;
import com.ctre.CANTalon;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Collector extends Subsystem{
  CANTalon collectorMotor = new CANTalon(RobotMap.collectorMotor);

public void initDefaultCommand() {
  }
public void collectAtSpeed(double speed){
  collectorMotor.set(speed);
}
}
