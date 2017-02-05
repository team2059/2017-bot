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

public class Shooter extends Subsystem {
	CANTalon shooterMotor = new CANTalon(RobotMap.shooterMotor);
	Encoder CIMEncoder = new Encoder(RobotMap.CIMEncoderA, RobotMap.CIMEncoderB, false, Encoder.EncodingType.k2X);
	PIDController CIMEncoderController = new PIDController(0.2, 0.002, 0.017, new CIMEncoderPIDSource(), new CIMEncoderPIDOutput());
	
	protected void initDefaultCommand() {		
	}	
	public void shootAtSpeed(double speed){
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
	      shooterMotor.set(output);
	    }
	  }
	public PIDController getCIMEncoderController() {
	    return CIMEncoderController;
	  }
	public void PidShoot(double setpoint) {
	    CIMEncoderController.setSetpoint(setpoint);
	    CIMEncoderController.enable();
	    
	  }
	public double getCIMEncoderRate(){
		return CIMEncoder.getRate();
	}

	
}

