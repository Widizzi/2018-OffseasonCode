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
    public static final boolean IS_LIFTING_UNIT_SUBSYSTEM_IN_USE = true;
    public static final boolean IS_GRIPPER_SUBSYSTEM_IN_USE = true;

    /* Motors */
    public static final int MOTOR_LIFTING_UNIT_MASTER_ID = 12;
    public static final int MOTOR_LIFTING_UNIT_FOLLOWER_ID = 9;

    public static final int MOTOR_GRIPPER_RIGHT_ID = 1;
    public static final int MOTOR_GRIPPER_LEFT_ID = 13;

    /* Joysticks */
    public static final int DRIVE_JOYSTICK_ID = 0;
    public static final int CONTROL_JOYSTICK_ID = 1;

    /* Buttons */
    public static final int LIFTING_UNIT_DRIVE_TO_LIMIT_BUTTON_ID = 10;
    public static final int LIFTING_UNIT_SWITCH_HEIGHT_BUTTON_ID = 3;
    public static final int LIFTING_UNIT_SCALE_HEIGHT_BUTTON_ID = 4;
    public static final int LIFTING_UNIT_BASE_HEIGHT_BUTTON_ID = 2;

    public static final int GRIPPER_FORWARD_BUTTON_ID = 5;
    public static final int GRIPPER_REVERSE_BUTTON_ID = 6;

    /* Speeds */
    public static double MANUAL_LIFTING_UNIT_SPEED = 0.2;
    public static double LIFTING_UNIT_ZEROING_SPEED = 0.2;

    public static double GRIPPER_FORWARD_SPEED = 0.5;
    public static double GRIPPER_REVERSE_SPEED = 0.5;

    /* Encoder Ticks */
    public static final int LIFTING_UNIT_MAX_VELOCITY_ENCODER_UNITS_PER_100_MS = 4000;

    public static final int LIFTING_UNIT_DRIVE_LENGTH = 200000;
    public static final int LIFTING_UNIT_SCALE_POSITION = 150000;
    public static final int LIFTING_UNIT_SWITCH_POSITION = 60000;
    public static final int LIFTING_UNIT_BASE_POSITION = 5000;

}
