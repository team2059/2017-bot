package org.usfirst.frc.team2059.robot;

import org.usfirst.frc.team2059.robot.commands.CommandBase;
import org.usfirst.frc.team2059.robot.commands.auto.AutoDriveDelay;
import org.usfirst.frc.team2059.robot.commands.auto.AutoEncoderY;
import org.usfirst.frc.team2059.robot.commands.auto.AutoEncoderX;
import org.usfirst.frc.team2059.robot.commands.auto.AutoDriveTime;
import org.usfirst.frc.team2059.robot.commands.auto.AutoCircleDrive;
import org.usfirst.frc.team2059.robot.commands.auto.AutoRotate;
import org.usfirst.frc.team2059.robot.commands.auto.AutoStrafeAlignVision;
import org.usfirst.frc.team2059.robot.commands.auto.RoutineCenterGearPeg;
import org.usfirst.frc.team2059.robot.commands.auto.RoutineCenterGearPegFallback;
import org.usfirst.frc.team2059.robot.commands.auto.RoutineRightGearPeg;
import org.usfirst.frc.team2059.robot.commands.auto.RoutineLeftGearPeg;
import org.usfirst.frc.team2059.robot.commands.auto.RoutineCenterPegVision;
import org.usfirst.frc.team2059.robot.subsystems.Shooter;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.CameraServer;



public class Robot extends IterativeRobot {

  public static OI oi;

  Command autonomousCommand;
  SendableChooser chooser = new SendableChooser();


  @Override
  public void robotInit() {
    CameraServer.getInstance().startAutomaticCapture();
    CommandBase.init();
    oi = new OI();
    SmartDashboard.putNumber("driveStraightError1xkP", 0.04);
    SmartDashboard.putNumber("driveStraightError1xkI", 0.0);
    SmartDashboard.putNumber("driveStraightError1ykP", 0.03);
    SmartDashboard.putNumber("GyroCorrection", 0.06);
    SmartDashboard.putNumber("xEncoderTarget", 0);
    SmartDashboard.putNumber("yEncoderTarget", 0);
    SmartDashboard.putNumber("shooterPower", 0.9);
    SmartDashboard.putNumber("AutoXTarget", -45);
    SmartDashboard.putNumber("AutoYTarget", 104);
    SmartDashboard.putNumber("driveStraightxkP", 0.35);
    SmartDashboard.putNumber("driveStraightxkD", 0.03);
    SmartDashboard.putNumber("driveStraightxkI", 0.003);
    SmartDashboard.putNumber("driveStraightykP", 0.015);
    SmartDashboard.putNumber("driveStraightykD", 0.003);
    SmartDashboard.putNumber("driveStraightykI", 0.004);
    SmartDashboard.putNumber("driveStraightErrorxkP", 0.04);
    SmartDashboard.putNumber("driveStraightErrorxkD", 0.04);
    SmartDashboard.putNumber("driveStraightErrorxkI", 0.0);
    SmartDashboard.putNumber("driveStraightErrorykP", 0.003);
    SmartDashboard.putNumber("driveStraightErrorykD", 0.03);
    SmartDashboard.putNumber("driveStraightErrorykI", 0.0);
    SmartDashboard.putNumber("shooterPower", 0.9);
    SmartDashboard.putNumber("cameraX", 0);
    SmartDashboard.putNumber("cameraY", 0);
    SmartDashboard.putNumber("servoAngleFeeder", 0);
    SmartDashboard.putNumber("deflectorAngle", 0);
    SmartDashboard.putData("Auto mode", chooser);
    SmartDashboard.putData("xEncoderController", CommandBase.driveBase.getxEncoderController());
    SmartDashboard.putData("yEncoderController", CommandBase.driveBase.getyEncoderController());
    SmartDashboard.putData("gyroController", CommandBase.driveBase.getGyroController());
    SmartDashboard.putData("shooterController", CommandBase.shooter.getCIMEncoderController());
    SmartDashboard.putData("gearAngleController", CommandBase.gearCollector.getAngleController());
    SmartDashboard.putInt("Automode", 3);
    CommandBase.gearCollector.resetAngleEncoderCount();
  }

  @Override
  public void disabledInit() {
  }

  @Override public void disabledPeriodic() {
    Scheduler.getInstance().run();
  }

  @Override
  public void autonomousInit() {
    switch (SmartDashboard.getInt("Automode")) {
      case 0:
        return;
      case 1:
        autonomousCommand = new AutoEncoderY(82, 2);
        break;
      case 2:
        CommandBase.gearCollector.setEncoderTarget(0);
        autonomousCommand = new RoutineLeftGearPeg();
        break;
      case 3:
        autonomousCommand = new RoutineCenterGearPeg();
        break;
      case 4:
        CommandBase.gearCollector.setEncoderTarget(0);
        autonomousCommand = new RoutineRightGearPeg();
        break;
      case 43:
        autonomousCommand = new RoutineCenterPegVision();
        break;
      case 44:
        autonomousCommand = new RoutineCenterGearPegFallback();
        break;
      default:
        break;
    }
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
    CommandBase.gearCollector.getAngleController().enable();
    CommandBase.gearCollector.setEncoderTarget(-4);
//    CommandBase.shooter.setDeflectorAngle(0);
  }

  @Override
  public void teleopPeriodic() {
    Scheduler.getInstance().run();
    //CommandBase.shooter.setDeflectorAngle(SmartDashboard.getNumber("deflectorAngle"));
//   CommandBase.shooter.setFeederServoAngle(SmartDashboard.getNumber("servoAngleFeeder"));
    SmartDashboard.putNumber("xEncoderCount", CommandBase.driveBase.getxEncoderCount());
    //SmartDashboard.putNumber("yEncoderCount", CommandBase.driveBase.getyEncoderCount());
    SmartDashboard.putNumber("yEncoderDistance", CommandBase.driveBase.getyEncoderDistance());
    SmartDashboard.putNumber("centerXvalue", CommandBase.visionHelper.getCenterContourX());
    SmartDashboard.putNumber("GyroAngle", CommandBase.driveBase.getGyro().getAngle());
    SmartDashboard.putNumber("horizontalError", CommandBase.visionHelper.getHorizontalError());
    SmartDashboard.putNumber("sonar distance", CommandBase.visionHelper.getSonar());
    SmartDashboard.putNumber("TranslationDistance", CommandBase.visionHelper.getTranslationDistance());
    SmartDashboard.putNumber("CIMEncoder Rate", CommandBase.shooter.getCIMEncoderRate());
    SmartDashboard.putNumber("joystick1throttle", oi.getJoystickThrottle(0));
    SmartDashboard.putNumber("gearAngleEncoderCount", CommandBase.gearCollector.getAngleEncoderCount());
  }
  @Override
  public void testPeriodic() {
    LiveWindow.run();
  }
}
// vim: sw=2:ts=2:sts=2
