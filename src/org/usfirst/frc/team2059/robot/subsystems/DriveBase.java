package org.usfirst.frc.team2059.robot.subsystems;
import org.usfirst.frc.team2059.robot.RobotMap;
import org.usfirst.frc.team2059.robot.commands.drivetrain.Drive;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Encoder;
import com.ctre.CANTalon;
public class DriveBase extends Subsystem {
  CANTalon leftFrontMotor = new CANTalon(RobotMap.driveLeftFrontMotor);
  CANTalon leftRearMotor = new CANTalon(RobotMap.driveLeftRearMotor);
  CANTalon rightFrontMotor = new CANTalon(RobotMap.driveRightFrontMotor);
  CANTalon rightRearMotor = new CANTalon(RobotMap.driveRightRearMotor);
  public void initDefaultCommand() {
    setDefaultCommand(new Drive());
  }
  public void driveMecanum(double x, double y, double z) {
    rightFrontMotor.set(-x + y - z);
    leftFrontMotor.set(-(x + y + z));
    rightRearMotor.set(x + y - z);
    leftRearMotor.set(-(-x + y + z));
  }
}
// vim: sw=2:ts=2:sts=2
