/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import frc.robot.subsystems.SwerveModule;

/**
 * Add your docs here.
 */
public class Motors {

    public static SwerveModule swerveModuleFrontRight;
    public static SwerveModule swerveModuleFrontLeft;
    public static SwerveModule swerveModuleBackRight;
    public static SwerveModule swerveModuleBackLeft;

    public Motors() {
        configSwerveMotors();
    }

    private void configSwerveMotors() {

        if(Constants.IS_SWERVE_SUBSYSTEM_IN_USE) {

            swerveModuleFrontRight = new SwerveModule(Constants.MOTOR_SWERVE_FRONT_RIGHT_VELOCITY_ID, Constants.MOTOR_SWERVE_FRONT_RIGHT_ANGLE_ID);
            swerveModuleFrontRight = new SwerveModule(Constants.MOTOR_SWERVE_FRONT_LEFT_VELOCITY_ID, Constants.MOTOR_SWERVE_FRONT_LEFT_ANGLE_ID);
            swerveModuleFrontRight = new SwerveModule(Constants.MOTOR_SWERVE_BACK_RIGHT_VELOCITY_ID, Constants.MOTOR_SWERVE_BACK_RIGHT_ANGLE_ID);
            swerveModuleFrontRight = new SwerveModule(Constants.MOTOR_SWERVE_BACK_LEFT_VELOCITY_ID, Constants.MOTOR_SWERVE_BACK_LEFT_ANGLE_ID);
        
        }

    }

}
