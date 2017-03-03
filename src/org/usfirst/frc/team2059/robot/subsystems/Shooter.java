package org.usfirst.frc.team2059.robot.subsystems;

import org.usfirst.frc.team2059.robot.RobotMap;
import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Servo;

public class Shooter extends Subsystem {
  CANTalon shooterMotor = new CANTalon(RobotMap.shooterMotor);
  CANTalon shooterfeeder = new CANTalon(RobotMap.shooterfeeder);
  CANTalon ballAgitator = new CANTalon(RobotMap.agitatorMotor);
  Encoder CIMEncoder = new Encoder(RobotMap.CIMEncoderA, RobotMap.CIMEncoderB, false, Encoder.EncodingType.k2X);
  PIDController CIMEncoderController = new PIDController(0.2, 0.002, 0.017, new CIMEncoderPIDSource(), new CIMEncoderPIDOutput());
  Servo feederServo = new Servo(RobotMap.feederServo);
  Servo deflectorServo = new Servo(RobotMap.deflectorServo);

  protected void initDefaultCommand() {
  }
  public void shootAtSpeed(double speed) {
    shooterMotor.set(speed);
  }
  public class CIMEncoderPIDSource implements PIDSource {
    public double pidGet() {
      return getCIMEncoderRate();
    }
    public PIDSourceType getPIDSourceType() {
      return PIDSourceType.kDisplacement;
    }
    public void setPIDSourceType(PIDSourceType type) {
    }
  }
  public class CIMEncoderPIDOutput implements PIDOutput {
    public void pidWrite(double output) {
      shooterMotor.set(-output);
    }
  }
  public PIDController getCIMEncoderController() {
    return CIMEncoderController;
  }
  public void PidShoot(double setpoint) {
    CIMEncoderController.setSetpoint(setpoint);
    CIMEncoderController.enable();
  }
  public double getCIMEncoderRate() {
    return CIMEncoder.getRate();
  }
  public void setDeflectorUp(boolean state) {
    if (state) {
      deflectorServo.setAngle(RobotMap.deflectorUpDegrees);
    } else {
      deflectorServo.setAngle(RobotMap.deflectorDownDegrees);
    }
  }
  public void setDeflectorAngle(double angle){
    deflectorServo.setAngle(angle);
  }
  public void feed(double i) {
    shooterfeeder.set(i);
  }
  public void agitateBalls(double speed) {
    ballAgitator.set(speed);
  }
  public void setFeederServoAngle(double angle) {
    feederServo.setAngle(angle);
  }
  public double getFeederServoAngle() {
    return feederServo.getAngle();
  }
  public void setFeederServoOpen(boolean state) {
    if (state) {
      feederServo.setAngle(RobotMap.feederOpenDegrees);
    } else {
      feederServo.setAngle(RobotMap.feederCloseDegrees);
    }
  }
}

