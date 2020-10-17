/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import frc.robot.subsystems.CartSubsystem;

/**
 * Add your docs here.
 */
public class Commands {

    public Commands() {
        initialize();        
    }

    public CartSubsystem cartSubsystem;

    private void initialize() {
        configCartCommands();
    }

    private void configCartCommands() {
        if(Constants.IS_CART_SUBSYSTEM_IN_USE) {
            cartSubsystem = new CartSubsystem();
        }
    }

}
