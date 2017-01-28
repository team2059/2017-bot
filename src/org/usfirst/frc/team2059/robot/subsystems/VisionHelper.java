package org.usfirst.frc.team2059.robot.subsystems;
import org.usfirst.frc.team2059.robot.RobotMap;
import java.util.Arrays;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.networktables.NetworkTable;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.AnalogInput;

public class VisionHelper {
  NetworkTable contoursTable;
  double imageWidth = 640;
  double imageHeight = 480;
  AnalogInput sonar;
  public VisionHelper() {
    contoursTable = NetworkTable.getTable("GRIP/contours");
    sonar = new AnalogInput(RobotMap.sonar);
  }
  public double getCenterContourX() {
    int highestAreaIndex = 0;
    int index = 0;
    double areas[] = contoursTable.getNumberArray("area", new double[0]);
    for (double area : areas) {
      if (area >= areas[highestAreaIndex]) {
        highestAreaIndex = index;
      }
      index++;
    }
    try {
      return contoursTable.getNumberArray("centerX", new double[0])[highestAreaIndex];
    } catch (Exception e) {
      return 0;
    }
  }
  public double getHorizontalError() {
    return ((180 / Math.PI) * (Math.atan((getCenterContourX() - (RobotMap.imageWidth / 2)) / RobotMap.fWidth))) + 3.5;
  }
  public double getSonar() {
    return (sonar.getAverageValue()/9.76562f);
  }

}
