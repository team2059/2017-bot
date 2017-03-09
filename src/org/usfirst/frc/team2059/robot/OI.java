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
import org.usfirst.frc.team2059.robot.commands.CollectAll;
import org.usfirst.frc.team2059.robot.commands.SetGearAngleCollect;
import org.usfirst.frc.team2059.robot.commands.SetGearAngleDeploy;
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
//    joystickButtons[0][0].whileHeld(new Collect(-1));
    joystickButtons[0][0].whileHeld(new CollectAll(-1));
    joystickButtons[0][1].whileHeld(new DriveIntoPeg());
    joystickButtons[0][10].whenPressed(new SetGearAngleCollect(1));
    joystickButtons[0][10].whenPressed(new SetGearAngleDeploy(1));

//    joystickButtons[0][11].whenPressed(new CollectGear(1));
//    joystickButtons[0][12].whenPressed(new SetGearAngle(1));
//    joystickButtons[0][0].whileHeld(new Collect(1));
    //joystickButtons[0][0].whileHeld(new AutoStrafeAlignVision());
//    joystickButtons[0][3].whileHeld(new GearSystem(1));
//    joystickButtons[0][4].whileHeld(new GearSystem(-1));
    //Button 8 drives straight
//    joystickButtons[1][0].whileHeld(new Climb(1));
//    joystickButtons[1][1].whileHeld(new Climb(1));
    joystickButtons[1][6].whenPressed(new SetDeflectorUp(true));
    joystickButtons[1][7].whileHeld(new Climb(-1));
    joystickButtons[1][8].whileHeld(new Climb(-0.25));
    joystickButtons[1][10].whileHeld(new Shoot(-0.4, true));
    joystickButtons[1][11].whileHeld(new Shoot(-1.0, false));
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
