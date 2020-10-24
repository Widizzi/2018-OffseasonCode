/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants.  This class should not be used for any other purpose.  All constants should be
 * declared globally (i.e. public static).  Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {

    /* Subsystems */
    public static final boolean IS_GRIPPER_SUBSYSTEM_IN_USE = true;

    /* Motors */
    public static final int MOTOR_GRIPPER_RIGHT_ID = 1;
    public static final int MOTOR_GRIPPER_LEFT_ID = 13;

    /* Joysticks */
    public static final int DRIVE_JOYSTICK_ID = 0;
    public static final int CONTROL_JOYSTICK_ID = 1;

    /* Buttons */
    public static final int GRIPPER_FORWARD_BUTTON_ID = 5;
    public static final int GRIPPER_REVERSE_BUTTON_ID = 6;

    /* Speeds */
    public static double GRIPPER_FORWARD_SPEED = 0.5;
    public static double GRIPPER_REVERSE_SPEED = 0.5;

}
