package org.usfirst.frc.team2059.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc.team2059.robot.commands.Climb;
import org.usfirst.frc.team2059.robot.commands.Collect;
import org.usfirst.frc.team2059.robot.commands.Shoot;
import org.usfirst.frc.team2059.robot.commands.drivetrain.DriveStraightX;
import org.usfirst.frc.team2059.robot.commands.drivetrain.DriveIntoPeg;
import org.usfirst.frc.team2059.robot.commands.auto.AutoStrafeAlignVision;
import org.usfirst.frc.team2059.robot.commands.SetServoYAngle;
import org.usfirst.frc.team2059.robot.commands.SetServoXAngle;
import org.usfirst.frc.team2059.robot.commands.SetCameraPosition;
import org.usfirst.frc.team2059.robot.commands.SetDeflectorUp;
import org.usfirst.frc.team2059.robot.commands.SetGearAngleCollect;
import org.usfirst.frc.team2059.robot.commands.SetGearAngleDeploy;
import org.usfirst.frc.team2059.robot.commands.SetGearAngle;
import org.usfirst.frc.team2059.robot.commands.CollectGear;
import org.usfirst.frc.team2059.robot.commands.DeployGear;
/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
  JoystickButton[][] joystickButtons;
  Joystick[] joysticks;
  public OI() {
    joysticks = new Joystick[2];
    joystickButtons = new JoystickButton[2][13];
    // Create joysticks
    joysticks[0] = new Joystick(0);
    joysticks[1] = new Joystick(1);
    // Create buttons
    for (int i = 0; i < 12; i++) {
      joystickButtons[0][i] = new JoystickButton(joysticks[0], i + 1);
      joystickButtons[1][i] = new JoystickButton(joysticks[1], i + 1);
    }
    joystickButtons[0][1].whileHeld(new CollectGear(-1));
    //Deploy
    joystickButtons[0][3].whileHeld(new CollectGear(1));
    joystickButtons[0][5].whileHeld(new DriveIntoPeg());
    joystickButtons[1][7].whileHeld(new Climb(-1));
    joystickButtons[1][8].whileHeld(new Climb(-0.25));
  }
  public Joystick[] getJoysticks() {
    return joysticks;
  }
  public Joystick getJoystick(int stick) {
    return joysticks[stick];
  }
  public JoystickButton[][] getJoystickButtons() {
    return joystickButtons;
  }
  public double getJoystickThrottle(int stick) {
    return (-getJoystick(stick).getRawAxis(3) + 1) / 2;
  }
}
