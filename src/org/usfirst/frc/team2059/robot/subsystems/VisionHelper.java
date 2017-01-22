package org.usfirst.frc.team2059.robot.subsystems;
import org.usfirst.frc.team2059.robot.RobotMap;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.networktables.NetworkTable;
import edu.wpi.first.wpilibj.CameraServer;

public class VisionHelper {
	NetworkTable contoursTable;
	public VisionHelper() {
		contoursTable = NetworkTable.getTable("GRIP/contours");
	}
	public double getCenterContourX(){
		int highestAreaIndex = 0;
		int index = 0;
		double areas[] = contoursTable.getNumberArray("area", new double[0]);
		for(double area : areas){
			if(area >= areas[highestAreaIndex]){
				highestAreaIndex=index;
			}
			index++;
		}
		try{
			return contoursTable.getNumberArray("centerX",new double[0])[highestAreaIndex];
		}catch(Exception e){
			return 0;
		}
	}
}
