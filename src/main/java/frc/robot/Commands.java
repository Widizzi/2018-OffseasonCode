/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import frc.robot.subsystems.LiftingUnitSubsystem;

/**
 * Add your docs here.
 */
public class Commands {

    public Commands() {
        initialize();
    }

    public LiftingUnitSubsystem liftingUnitSubsystem;

    private void initialize() {
        configLiftingUnitCommands();
    }

    private void configLiftingUnitCommands() {
        if(Constants.IS_LIFTING_UNIT_SUBSYSTEM_IN_USE) {
            liftingUnitSubsystem = new LiftingUnitSubsystem();
        }
    }

}
