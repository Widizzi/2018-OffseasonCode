/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

/**
 * This class is where the bulk of the robot should be declared. Since
 * Command-based is a "declarative" paradigm, very little robot logic should
 * actually be handled in the {@link Robot} periodic methods (other than the
 * scheduler calls). Instead, the structure of the robot (including subsystems,
 * commands, and button mappings) should be declared here.
 */
public class RobotContainer extends Commands {

  public static Joystick driveJoystick;
  public static Joystick controlJoystick;

  public static JoystickButton gripperForwardButton;
  public static JoystickButton gripperReverseButton;

  public RobotContainer() {

    configureJoysticks();
    configureButtonBindings();

  }

  private void configureJoysticks() {

    driveJoystick = new Joystick(Constants.DRIVE_JOYSTICK_ID);
    controlJoystick = new Joystick(Constants.CONTROL_JOYSTICK_ID);
    
  }
  
  private void configureButtonBindings() {

    if(Constants.IS_GRIPPER_SUBSYSTEM_IN_USE) {
      gripperForwardButton = new JoystickButton(controlJoystick, Constants.GRIPPER_FORWARD_BUTTON_ID);
      gripperReverseButton = new JoystickButton(controlJoystick, Constants.GRIPPER_REVERSE_BUTTON_ID);

      gripperForwardButton.whenPressed(gripperForwardConditionalCommand);
      gripperReverseButton.whenPressed(gripperReverseConditionalCommand);
    }
  }
}
