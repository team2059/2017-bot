package org.usfirst.frc.team2059.robot.subsystems;
import org.usfirst.frc.team2059.robot.RobotMap;
import com.ctre.CANTalon;
import edu.wpi.first.wpilibj.command.Subsystem;

public class GearAngleMotor extends Subsystem {
  CANTalon gearAngle = new CANTalon(RobotMap.gearAngleMotor);

  public void initDefaultCommand() {
  }
  public void gearAngleSetTo(double speed) {
    gearAngle.set(speed);
  }
}
