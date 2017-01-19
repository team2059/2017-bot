package org.usfirst.frc.team2059.robot.subsystems;
import org.usfirst.frc.team2059.robot.RobotMap;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.networktables.NetworkTable;

public class VisionHelper{
  NetworkTable contoursTable;
	public VisionHelper(){
		contoursTable = NetworkTable.getTable("GRIP/contours");
  }
}
