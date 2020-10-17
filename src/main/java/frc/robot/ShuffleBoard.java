/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.wpilibj.shuffleboard.BuiltInWidgets;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;

public class ShuffleBoard {

    private static ShuffleboardTab speeds = Shuffleboard.getTab("Speeds");

    public static NetworkTableEntry gripperForwardSpeed =
        speeds.add("GRIPPER FORWARD SPEED", Constants.GRIPPER_FORWARD_SPEED)
        .getEntry();

    public static NetworkTableEntry gripperReverseSpeed = 
        speeds.add("GRIPPER REVERSE SPEED", Constants.GRIPPER_REVERSE_SPEED)
        .getEntry();

        
    public static NetworkTableEntry gripperCurrent =
        speeds.add("CURRENT GRIPPER SPEED", 0)
        .withWidget(BuiltInWidgets.kNumberBar)
        .getEntry();

    public void updateSpeeds() {
        Constants.GRIPPER_FORWARD_SPEED = gripperForwardSpeed.getDouble(Constants.GRIPPER_FORWARD_SPEED);
        Constants.GRIPPER_REVERSE_SPEED = gripperReverseSpeed.getDouble(Constants.GRIPPER_REVERSE_SPEED);
    }

}
