package org.usfirst.frc.team2059.robot.subsystems;
import org.usfirst.frc.team2059.robot.RobotMap;
import com.ctre.CANTalon;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.DigitalInput;

public class Climber extends Subsystem {
  CANTalon climberMotor = new CANTalon(RobotMap.climbermotor);
  CANTalon climberMotor2 = new CANTalon(RobotMap.climbermotor2);
  DigitalInput climberSwitch1 = new DigitalInput(RobotMap.climberSwitch1);
  public void initDefaultCommand() {
  }
  public void climbAtSpeed(double speed) {
    climberMotor.set(speed);
    climberMotor2.set(-speed);
  }
  public boolean getClimberSwitch1() {
    return !climberSwitch1.get();
  }
}
