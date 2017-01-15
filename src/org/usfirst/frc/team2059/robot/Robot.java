
package org.usfirst.frc.team2059.robot;

import org.usfirst.frc.team2059.robot.commands.CommandBase;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


public class Robot extends IterativeRobot {

  public static OI oi;

  Command autonomousCommand;
  SendableChooser chooser = new SendableChooser();

  @Override
  public void robotInit() {
	CommandBase.init();
    oi = new OI();
    SmartDashboard.putData("Auto mode", chooser);
    SmartDashboard.putData("xEncoderController", CommandBase.driveBase.getxEncoderController());
  }

  @Override
  public void disabledInit() {
  }

  @Override
  public void disabledPeriodic() {
    Scheduler.getInstance().run();
  }

  @Override
  public void autonomousInit() {
    autonomousCommand = (Command)chooser.getSelected();
    if (autonomousCommand != null) {
      autonomousCommand.start();
    }
  }

  @Override
  public void autonomousPeriodic() {
    Scheduler.getInstance().run();
  }

  @Override
  public void teleopInit() {
    if (autonomousCommand != null) {
      autonomousCommand.cancel();
    }
    CommandBase.driveBase.getGyro().reset();
    CommandBase.driveBase.getxEncoderController().disable();
    CommandBase.driveBase.getxEncoderController().setSetpoint(768);
  }

  @Override
  public void teleopPeriodic() {
    Scheduler.getInstance().run();
    SmartDashboard.putNumber("xEncoderCount",CommandBase.driveBase.getxEncoderCount());
    SmartDashboard.putNumber("GyroAngle",CommandBase.driveBase.getGyro().getAngle());
  }

  @Override
  public void testPeriodic() {
    LiveWindow.run();
  }
}
// vim: sw=2:ts=2:sts=2
