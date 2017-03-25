package org.usfirst.frc.team2059.robot.subsystems;
import org.usfirst.frc.team2059.robot.RobotMap;
import com.ctre.CANTalon;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.DigitalInput;

public class GearCollector extends Subsystem {
  boolean deployMode = false;
  CANTalon gearMotor = new CANTalon(RobotMap.gearCollectorMotor);
  CANTalon gearAngleMotor = new CANTalon(RobotMap.gearAngleMotor);
  DigitalInput gearDeploySwitch = new DigitalInput(RobotMap.gearCollectorDeploySwitch);
  DigitalInput gearCollectSwitch = new DigitalInput(RobotMap.gearCollectorCollectSwitch);

  public void initDefaultCommand() {
  }
  public void gearCollectAtSpeed(double speed) {
    gearMotor.set(speed);
  }
  public void setGearAngleMotorSpeed(double speed){
    gearAngleMotor.set(speed);
  }
  public boolean getDeploySwitch(){
    return gearDeploySwitch.get();
  }
  public boolean getCollectSwitch(){
    return gearCollectSwitch.get();
  }
  public void setDeployMode(boolean a){
    deployMode=a;
  }
  public void gearCollectorPeriodic(){
    if(deployMode){
      if(!gearDeploySwitch.get()){
        setGearAngleMotorSpeed(0.3);
      }
    }
  }
}
