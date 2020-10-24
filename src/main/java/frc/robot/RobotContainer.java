/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.LiftingUnitSetPositionCommand;
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

  public static JoystickButton liftDriveToScaleButton;
  public static JoystickButton liftDriveToSwitchButton;
  public static JoystickButton liftDriveToBaseButton;
  public static JoystickButton liftDriveToLimitButton;

  public static JoystickButton gripperForwardButton;
  public static JoystickButton gripperReverseButton;

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

    if(Constants.IS_LIFTING_UNIT_SUBSYSTEM_IN_USE) {
      liftDriveToLimitButton = new JoystickButton(controlJoystick, Constants.LIFTING_UNIT_DRIVE_TO_LIMIT_BUTTON_ID);
      liftDriveToScaleButton = new JoystickButton(controlJoystick, Constants.LIFTING_UNIT_SCALE_HEIGHT_BUTTON_ID);
      liftDriveToSwitchButton = new JoystickButton(controlJoystick, Constants.LIFTING_UNIT_SWITCH_HEIGHT_BUTTON_ID);
      liftDriveToBaseButton = new JoystickButton(controlJoystick, Constants.LIFTING_UNIT_BASE_HEIGHT_BUTTON_ID);

      liftDriveToScaleButton.whenPressed(new LiftingUnitSetPositionCommand(liftingUnitSubsystem, Constants.LIFTING_UNIT_SCALE_POSITION));
      liftDriveToSwitchButton.whenPressed(new LiftingUnitSetPositionCommand(liftingUnitSubsystem, Constants.LIFTING_UNIT_SWITCH_POSITION));
      liftDriveToBaseButton.whenPressed(new LiftingUnitSetPositionCommand(liftingUnitSubsystem, Constants.LIFTING_UNIT_BASE_POSITION));
    }

    if(Constants.IS_GRIPPER_SUBSYSTEM_IN_USE) {
      gripperForwardButton = new JoystickButton(controlJoystick, Constants.GRIPPER_FORWARD_BUTTON_ID);
      gripperReverseButton = new JoystickButton(controlJoystick, Constants.GRIPPER_REVERSE_BUTTON_ID);

      gripperForwardButton.whenPressed(gripperForwardConditionalCommand);
      gripperReverseButton.whenPressed(gripperReverseConditionalCommand);
    }

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
