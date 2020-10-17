/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj2.command.ConditionalCommand;
import frc.robot.commands.gripper.GripperForwardCommand;
import frc.robot.commands.gripper.GripperReverseCommand;
import frc.robot.commands.gripper.GripperStopCommand;
import frc.robot.subsystems.GripperSubsystem;

/**
 * Add your docs here.
 */
public class Commands {

    public Commands() {
        initialize();
    }

    public static GripperSubsystem gripperSubsystem;

    protected ConditionalCommand gripperForwardConditionalCommand;
    protected ConditionalCommand gripperReverseConditionalCommand;

    private void initialize() {

        configGripperCommands();

    }

    private void configGripperCommands() {

        if (Constants.IS_GRIPPER_SUBSYSTEM_IN_USE) {
            gripperSubsystem = new GripperSubsystem();
            gripperForwardConditionalCommand = new ConditionalCommand(new GripperStopCommand(gripperSubsystem), new GripperForwardCommand(gripperSubsystem), gripperSubsystem::isTurningForward);
            gripperReverseConditionalCommand = new ConditionalCommand(new GripperStopCommand(gripperSubsystem), new GripperReverseCommand(gripperSubsystem), gripperSubsystem::isTurningReverse);
        }
    }

}
