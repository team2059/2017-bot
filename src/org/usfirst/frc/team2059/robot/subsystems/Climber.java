package org.usfirst.frc.team2059.robot.subsystems;
import org.usfirst.frc.team2059.robot.RobotMap;
import com.ctre.CANTalon;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Climber extends Subsystem {
  CANTalon climberMotor = new CANTalon(RobotMap.climbermotor);
  CANTalon climberMotor2 = new CANTalon(RobotMap.climbermotor2);

  public void initDefaultCommand() {
  }
  public void climbAtSpeed(double speed) {
    climberMotor.set(speed);
    climberMotor2.set(-speed);
  }
}
