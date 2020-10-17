/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

/**
 * Add your docs here.
 */
public class Motors {

    private static WPI_TalonSRX gripper_motor_right;
    private static WPI_TalonSRX gripper_motor_left;
    public static WPI_TalonSRX gripper_master;

    public Motors() {
        configGripperMotors();
    }

    private void configGripperMotors() {

        if(Constants.IS_GRIPPER_SUBSYSTEM_IN_USE) {

            gripper_motor_right = new WPI_TalonSRX(Constants.MOTOR_GRIPPER_RIGHT_ID);
            gripper_motor_left = new WPI_TalonSRX(Constants.MOTOR_GRIPPER_LEFT_ID);

            gripper_motor_right.configFactoryDefault();
            gripper_motor_left.configFactoryDefault();

            gripper_motor_left.follow(gripper_motor_right);
            gripper_motor_left.setInverted(true);

            gripper_master = gripper_motor_right;

        }

    }

}
