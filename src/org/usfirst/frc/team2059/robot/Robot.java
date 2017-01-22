package org.usfirst.frc.team2059.robot;

import org.usfirst.frc.team2059.robot.commands.CommandBase;
import org.usfirst.frc.team2059.robot.commands.auto.AutoDriveDelay;
import org.usfirst.frc.team2059.robot.commands.auto.AutoEncoderY;
import org.usfirst.frc.team2059.robot.commands.auto.AutoEncoderX;
import org.usfirst.frc.team2059.robot.commands.auto.AutoCircleDrive;
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
    SmartDashboard.putNumber("GyroCorrection", .1);
    SmartDashboard.putData("Auto mode", chooser);
    SmartDashboard.putData("xEncoderController", CommandBase.driveBase.getxEncoderController());
    SmartDashboard.putData("yEncoderController", CommandBase.driveBase.getyEncoderController());
    SmartDashboard.putData("gyroController", CommandBase.driveBase.getGyroController());
    SmartDashboard.putInt("Automode", 0);
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
    switch (SmartDashboard.getInt("Automode")) {
      case 0:
        return;
      case 1:
        autonomousCommand = new AutoEncoderX(256);
      case 2:
        autonomousCommand = new AutoEncoderY(256);
      case 3:
        autonomousCommand = new AutoCircleDrive(1);
    }
    if (autonomousCommand != null) {
      autonomousCommand.start();
    }
  }

  @Override
  public void autonomousPeriodic() {
    Scheduler.getInstance().run();
    SmartDashboard.putNumber("xEncoderCount", CommandBase.driveBase.getxEncoderCount());
    SmartDashboard.putNumber("GyroAngle", CommandBase.driveBase.getGyro().getAngle());
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
    SmartDashboard.putNumber("xEncoderCount", CommandBase.driveBase.getxEncoderCount());
    SmartDashboard.putNumber("GyroAngle", CommandBase.driveBase.getGyro().getAngle());
    SmartDashboard.putNumber("centerX", CommandBase.visionHelper.getCenterContourX());
  }

  @Override
  public void testPeriodic() {
    LiveWindow.run();
  }
}
// vim: sw=2:ts=2:sts=2
