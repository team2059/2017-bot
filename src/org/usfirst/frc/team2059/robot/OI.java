package org.usfirst.frc.team2059.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import org.usfirst.frc.team2059.robot.commands.SetGearHolderOpen;
import org.usfirst.frc.team2059.robot.commands.Climb;
import org.usfirst.frc.team2059.robot.commands.Collect;
import org.usfirst.frc.team2059.robot.commands.drivetrain.DriveStraightX;
import org.usfirst.frc.team2059.robot.commands.auto.AutoStrafeAlignVision;

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
    joystickButtons[0][6].whileHeld(new SetGearHolderOpen(true));
    joystickButtons[0][7].whileHeld(new Climb(1));
    joystickButtons[0][2].whileHeld(new Collect(1));
    joystickButtons[0][0].whileHeld(new AutoStrafeAlignVision());
    joystickButtons[0][1].whileHeld(new DriveStraightX());
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
}
