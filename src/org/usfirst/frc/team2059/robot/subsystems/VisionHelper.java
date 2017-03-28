package org.usfirst.frc.team2059.robot.subsystems;
import org.usfirst.frc.team2059.robot.RobotMap;
import java.util.Arrays;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.networktables.NetworkTable;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.command.Subsystem;

public class VisionHelper extends Subsystem {
  NetworkTable contoursTable;
  Servo servoX, servoY;
  double imageWidth = 640;
  double imageHeight = 480;
  AnalogInput sonar;
  public void initDefaultCommand() {};
  public VisionHelper() {
    contoursTable = NetworkTable.getTable("GRIP/contours");
    sonar = new AnalogInput(RobotMap.sonar);
    servoX = new Servo(RobotMap.servoX);
    servoY = new Servo(RobotMap.servoY);
  }
  public double getCenterContourX() {
    int highestAreaIndex = 0;
    int secondHighestAreaIndex = 0;
    int index = 0;
    double areas[] = contoursTable.getNumberArray("area", new double[0]);
    try {
      double highestArea = contoursTable.getNumberArray("centerX", new double[0])[0];
      double secondHighestArea = contoursTable.getNumberArray("centerX", new double[0])[1];
      SmartDashboard.putNumber("HighestArea", highestArea);
      SmartDashboard.putNumber("SecondHighestArea", secondHighestArea);
      return Math.abs((highestArea + secondHighestArea) / 2);
    } catch (Exception e) {
      return 0;
    }
  }
  public double getHorizontalError() {
    return ((180 / Math.PI) * (Math.atan((getCenterContourX() - (RobotMap.imageWidth / 2)) / RobotMap.fWidth)));
  }
  public double getSonar() {
    return (sonar.getAverageValue() / 9.766);
  }
  public double getTranslationDistance() {
    return getSonar() * Math.tan((Math.PI / 180) * getHorizontalError());
  }
  public void setServoAngleX(double angle) {
    servoX.setAngle(angle);
  }
  public void setServoAngleY(double angle) {
    servoY.setAngle(angle);
  }
  public double getServoAngleX() {
    return servoX.getAngle();
  }
  public double getServoAngleY() {
    return servoY.getAngle();
  }
}
