/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import frc.robot.subsystems.LiftingUnitSubsystem;
import edu.wpi.first.wpilibj2.command.ConditionalCommand;
import frc.robot.commands.gripper.GripperForwardCommand;
import frc.robot.commands.gripper.GripperReverseCommand;
import frc.robot.commands.gripper.GripperStopCommand;
import frc.robot.subsystems.GripperSubsystem;
import frc.robot.subsystems.CartSubsystem;

/**
 * Add your docs here.
 */
public class Commands {

    public Commands() {
        initialize();
    }

    public LiftingUnitSubsystem liftingUnitSubsystem;
    public GripperSubsystem gripperSubsystem;
    public CartSubsystem cartSubsystem;

    protected ConditionalCommand gripperForwardConditionalCommand;
    protected ConditionalCommand gripperReverseConditionalCommand;

    private void initialize() {
        configLiftingUnitCommands();
        configGripperCommands();
        configCartCommands();
    }

    private void configLiftingUnitCommands() {
        if(Constants.IS_LIFTING_UNIT_SUBSYSTEM_IN_USE) {
            liftingUnitSubsystem = new LiftingUnitSubsystem();
        }
    }

    private void configGripperCommands() {
        if (Constants.IS_GRIPPER_SUBSYSTEM_IN_USE) {
            gripperSubsystem = new GripperSubsystem();
            gripperForwardConditionalCommand = new ConditionalCommand(new GripperStopCommand(gripperSubsystem), new GripperForwardCommand(gripperSubsystem), gripperSubsystem::isTurningForward);
            gripperReverseConditionalCommand = new ConditionalCommand(new GripperStopCommand(gripperSubsystem), new GripperReverseCommand(gripperSubsystem), gripperSubsystem::isTurningReverse);
        }
    }

    private void configCartCommands() {
        if(Constants.IS_CART_SUBSYSTEM_IN_USE) {
            cartSubsystem = new CartSubsystem();
        }
    }

}
