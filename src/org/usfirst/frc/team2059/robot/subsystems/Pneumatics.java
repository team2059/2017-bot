package org.usfirst.frc.team2059.robot.subsystems;
import org.usfirst.frc.team2059.robot.RobotMap;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Compressor;

public class Pneumatics extends Subsystem {
  Compressor compressor = new Compressor (RobotMap.pcm);
  DoubleSolenoid gearSolenoid = new DoubleSolenoid (RobotMap.pcm, RobotMap.gearsolenoid1, RobotMap.gearsolenoid2);
  boolean gearState = false;
  public Pneumatics() {
    gearSolenoid.set(DoubleSolenoid.Value.kForward);
  }
  public void initDefaultCommand() {
  }
  public void setCompressorEnabled(boolean state){
    compressor.setClosedLoopControl(state);
  }
  public void setGearState (boolean state){
    if (state) {
      gearSolenoid.set(DoubleSolenoid.Value.kReverse);
    } else {
      gearSolenoid.set(DoubleSolenoid.Value.kForward);
    }
    gearState = state;
  }
public boolean getgearState() {
    return gearState;
  }
public boolean getCompressorEnabled() {
    return compressor.enabled();
  }
}
