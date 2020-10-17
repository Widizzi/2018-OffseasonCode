/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.CartDriveToLimitCommand;
import frc.robot.commands.CartSetPositionCommand;

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

  public static JoystickButton cartDriveToLimitButton;
  public static JoystickButton cartDriveToCenter;
  public static JoystickButton cartDriveToFront;


  public RobotContainer() {

    configureJoysticks();
    configureButtonBindings();

  }

  private void configureJoysticks() {

    driveJoystick = new Joystick(Constants.DRIVE_JOYSTICK_ID);
    controlJoystick = new Joystick(Constants.CONTROL_JOYSTICK_ID);
    
  }
  
  private void configureButtonBindings() {

    if(Constants.IS_CART_SUBSYSTEM_IN_USE) {
      cartDriveToLimitButton = new JoystickButton(controlJoystick, Constants.CART_DRIVE_TO_LIMIT_BUTTON_ID);
      cartDriveToCenter = new JoystickButton(controlJoystick, Constants.CART_DRIVE_TO_CENTER_BUTTON_ID);
      cartDriveToFront = new JoystickButton(controlJoystick, Constants.CART_DRIVE_TO_FRONT_BUTTON_ID);

      cartDriveToLimitButton.whenPressed(new CartDriveToLimitCommand(cartSubsystem, Constants.CART_ZEROING_SPEED));
      cartDriveToCenter.whenPressed(new CartSetPositionCommand(cartSubsystem, Constants.CART_CENTER_POSITION));
      cartDriveToFront.whenPressed(new CartSetPositionCommand(cartSubsystem, Constants.CART_DRIVE_LENGTH));
    }

  }
}
