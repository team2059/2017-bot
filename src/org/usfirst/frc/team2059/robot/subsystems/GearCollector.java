package org.usfirst.frc.team2059.robot.subsystems;
import org.usfirst.frc.team2059.robot.RobotMap;
import com.ctre.CANTalon;
import edu.wpi.first.wpilibj.command.Subsystem;

public class GearCollector extends Subsystem {
  CANTalon gearMotor = new CANTalon(RobotMap.gearMotor);

  public void initDefaultCommand() {
  }
  public void gearCollectAtSpeed(double speed) {
    gearMotor.set(speed);
  }
}
