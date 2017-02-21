package org.usfirst.frc.team2059.robot.commands;
import org.usfirst.frc.team2059.robot.subsystems.VisionHelper;

public class SetCameraPosition extends CommandBase{
  double anglex;
  double angley;

  public SetCameraPosition(double x, double y) {
    anglex = x;
    angley = y;
  }

  protected void initialize(){
  }

  protected void execute(){
    visionHelper.setServoAngleX(anglex);
    visionHelper.setServoAngleY(angley);

  }

  protected boolean isFinished() {
    return true;
  }

  protected void end() {
  }

  protected void interrupted() {
    end();
  }
}
