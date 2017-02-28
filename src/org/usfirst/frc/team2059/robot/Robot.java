package org.usfirst.frc.team2059.robot;

import org.usfirst.frc.team2059.robot.commands.CommandBase;
import org.usfirst.frc.team2059.robot.commands.auto.AutoDriveDelay;
import org.usfirst.frc.team2059.robot.commands.auto.AutoEncoderY;
import org.usfirst.frc.team2059.robot.commands.auto.AutoEncoderX;
import org.usfirst.frc.team2059.robot.commands.auto.AutoCircleDrive;
import org.usfirst.frc.team2059.robot.commands.auto.AutoRotate;
import org.usfirst.frc.team2059.robot.commands.auto.AutoStrafeAlignVision;
import org.usfirst.frc.team2059.robot.subsystems.Shooter;
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
    SmartDashboard.putNumber("GyroCorrection", 0.1);
    SmartDashboard.putNumber("xEncoderTarget", 0);
    SmartDashboard.putNumber("yEncoderTarget", 0);
    SmartDashboard.putNumber("shooterPower", 0.9);
    SmartDashboard.putNumber("driveStraightxkP", 0.003);
    SmartDashboard.putNumber("driveStraightxkD", 0.03);
    SmartDashboard.putNumber("driveStraightxkI", 0.0);
    SmartDashboard.putNumber("driveStraightykP", 0.003);
    SmartDashboard.putNumber("driveStraightykD", 0.03);
    SmartDashboard.putNumber("driveStraightykI", 0.0);
    SmartDashboard.putNumber("shooterPower", 0.9);
    SmartDashboard.putNumber("cameraX", 0);
    SmartDashboard.putNumber("cameraY", 0);
    SmartDashboard.putNumber("servoAngleFeeder", 0);
    SmartDashboard.putData("Auto mode", chooser);
    SmartDashboard.putData("xEncoderController", CommandBase.driveBase.getxEncoderController());
    SmartDashboard.putData("yEncoderController", CommandBase.driveBase.getyEncoderController());
    SmartDashboard.putData("gyroController", CommandBase.driveBase.getGyroController());
    SmartDashboard.putData("shooterController", CommandBase.shooter.getCIMEncoderController());
    SmartDashboard.putInt("Automode", 0);
  }

  @Override
  public void disabledInit() {
  }

  @Override public void disabledPeriodic() {
    Scheduler.getInstance().run();
  }

  @Override
  public void autonomousInit() {
    //  switch (SmartDashboard.getInt("Automode")) {
    //    case 0:
    //      return;
    //    case 1:
    //      autonomousCommand = new AutoEncoderX(SmartDashboard.getNumber("xEncoderTarget"));
    //    case 2:
    //      autonomousCommand = new AutoEncoderY(256);
    //    case 3:
    //      autonomousCommand = new AutoCircleDrive(1);
    //    case 4:
    //      autonomousCommand = new AutoRotate(15);
    //    default:
    //      break;
    //  }
//        autonomousCommand = new AutoEncoderY(SmartDashboard.getNumber("yEncoderTarget"));
    autonomousCommand = new AutoStrafeAlignVision();
    if (autonomousCommand != null) {
      autonomousCommand.start();
    }
  }

  @Override
  public void autonomousPeriodic() {
    Scheduler.getInstance().run();
    SmartDashboard.putNumber("xEncoderCount", CommandBase.driveBase.getxEncoderCount());
    SmartDashboard.putNumber("yEncoderCount", CommandBase.driveBase.getyEncoderCount());
    SmartDashboard.putNumber("yEncoderDistance", CommandBase.driveBase.getyEncoderDistance());
    SmartDashboard.putNumber("GyroAngle", CommandBase.driveBase.getGyro().getAngle());
  }

  @Override
  public void teleopInit() {
    if (autonomousCommand != null) {
      autonomousCommand.cancel();
    }
    CommandBase.driveBase.getGyro().reset();
    CommandBase.driveBase.getGyroController().disable();
    CommandBase.driveBase.getxEncoderController().disable();
    CommandBase.driveBase.getyEncoderController().disable();
  }

  @Override
  public void teleopPeriodic() {
    Scheduler.getInstance().run();
    CommandBase.shooter.setFeederServoAngle(SmartDashboard.getNumber("servoAngleFeeder"));
    SmartDashboard.putNumber("xEncoderCount", CommandBase.driveBase.getxEncoderCount());
    //SmartDashboard.putNumber("yEncoderCount", CommandBase.driveBase.getyEncoderCount());
    SmartDashboard.putNumber("yEncoderDistance", CommandBase.driveBase.getyEncoderDistance());
    SmartDashboard.putNumber("GyroAngle", CommandBase.driveBase.getGyro().getAngle());
    SmartDashboard.putNumber("horizontalError", CommandBase.visionHelper.getHorizontalError());
    SmartDashboard.putNumber("sonar distance", CommandBase.visionHelper.getSonar());
    SmartDashboard.putNumber("TranslationDistance", CommandBase.visionHelper.getTranslationDistance());
    SmartDashboard.putNumber("CIMEncoder Rate", CommandBase.shooter.getCIMEncoderRate());
    SmartDashboard.putNumber("joystick1throttle", oi.getJoystickThrottle(0));
  }
  @Override
  public void testPeriodic() {
    LiveWindow.run();
  }
}
// vim: sw=2:ts=2:sts=2
