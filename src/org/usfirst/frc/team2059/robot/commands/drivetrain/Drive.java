package org.usfirst.frc.team2059.robot.commands.drivetrain;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc.team2059.robot.OI;
import org.usfirst.frc.team2059.robot.Robot;
import org.usfirst.frc.team2059.robot.commands.CommandBase;
public class Drive extends CommandBase {
  public Drive() {
    requires(driveBase);
  }
  protected void initialize() {
  }
  protected void execute() {
    double x = Robot.oi.getJoysticks()[0].getRawAxis(0);
    double y = Robot.oi.getJoysticks()[0].getRawAxis(1);
    double z = Robot.oi.getJoysticks()[0].getRawAxis(2);
    if (Robot.oi.getJoystick(0).getRawButton(6)) {
      //dont drive
    } else if (Robot.oi.getJoystick(0).getRawButton(1)) {
      driveBase.driveMecanum(x, y, z/4, 1);
    } else {
      driveBase.driveMecanum(x, y, z, .5);
    }
  }
  protected boolean isFinished() {
    return false;
  }
  protected void end() {
  }
  protected void interrupted() {
  }
}
