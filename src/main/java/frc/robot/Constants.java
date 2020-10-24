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
    public static final boolean IS_CART_SUBSYSTEM_IN_USE = true;

    /* Motors */
    public static final int MOTOR_CART_ID = 3;

    /* Joysticks */
    public static final int DRIVE_JOYSTICK_ID = 0;
    public static final int CONTROL_JOYSTICK_ID = 1;

    /* Buttons */
    public static final int CART_DRIVE_TO_LIMIT_BUTTON_ID = 9;
    public static final int CART_DRIVE_TO_FRONT_BUTTON_ID = 8;
    public static final int CART_DRIVE_TO_CENTER_BUTTON_ID = 1;

    /* Speeds */
    public static double MANUAL_CART_SPEED = 0.5;
    public static double CART_ZEROING_SPEED = 0.4;

    /* Encoder Ticks */
    public static final int CART_DRIVE_LENGTH = 845790;
    public static final int CART_CENTER_POSITION = 450000;

}
