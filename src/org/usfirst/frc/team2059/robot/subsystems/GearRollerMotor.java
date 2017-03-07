package org.usfirst.frc.team2059.robot.subsystems;
import org.usfirst.frc.team2059.robot.RobotMap;
import com.ctre.CANTalon;
import edu.wpi.first.wpilibj.command.Subsystem;

public class GearRollerMotor extends Subsystem {
  CANTalon gearRoller = new CANTalon(RobotMap.gearRollerMotor);

  public void initDefaultCommand() {
  }
  public void gearCollectAtSpeed(double speed) {
    gearRoller.set(speed);
  }
}
