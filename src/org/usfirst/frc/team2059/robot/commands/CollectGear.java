package org.usfirst.frc.team2059.robot.commands;
import org.usfirst.frc.team2059.robot.subsystems.Collector;
import edu.wpi.first.wpilibj.PIDController;


public class CollectGear extends CommandBase {
  double speed;
  public CollectGear(double s) {
    speed = s;
  }

  protected void initialize() {
  }

  protected void execute() {
    gearCollector.setEncoderTarget(1);
    gearCollector.gearCollectAtSpeed(speed);
  }

  protected boolean isFinished() {
    return false;
  }

  protected void end() {
    gearCollector.setEncoderTarget(-40);
    gearCollector.gearCollectAtSpeed(0);
  }

  protected void interrupted() {
    end();
  }
}
