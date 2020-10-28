/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import frc.robot.commands.SwerveDriveCommand;
import frc.robot.subsystems.SwerveSubsystem;

/**
 * Add your docs here.
 */
public class Commands {

    public Commands() {
        initialize();
    }

    public SwerveSubsystem swerveSubsystem;

    private void initialize() {
        configSwerveCommands();
    }

    private void configSwerveCommands() {
        if(Constants.IS_SWERVE_SUBSYSTEM_IN_USE) {
            swerveSubsystem = new SwerveSubsystem();

            swerveSubsystem.setDefaultCommand(new SwerveDriveCommand(swerveSubsystem));
        }
    }

}
