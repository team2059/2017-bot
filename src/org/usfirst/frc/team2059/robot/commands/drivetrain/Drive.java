package org.usfirst.frc.team2059.robot.commands.drivetrain;
import org.usfirst.frc.team2059.robot.commands.CommandBase;
import org.usfirst.frc.team2059.robot.OI;
import org.usfirst.frc.team2059.robot.Robot;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

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
    if(Robot.oi.getJoystick(0).getRawButton(8)){
      driveBase.driveStraightX(x, SmartDashboard.getNumber("GyroCorrection"));
    }else{ 
      driveBase.driveMecanum(x, y, z, 0.5);
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
