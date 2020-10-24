/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.Motors;
import frc.robot.ShuffleBoard;

public class GripperSubsystem extends SubsystemBase {

  public void gripperForward() {
    Motors.gripper_master.set(Constants.GRIPPER_FORWARD_SPEED);
  }

  public void gripperReverse() {
    Motors.gripper_master.set(-Constants.GRIPPER_REVERSE_SPEED);
  }

  public void gripperStop() {
    Motors.gripper_master.stopMotor();
  }

  public boolean isTurningForward() {
    if (Motors.gripper_master.getMotorOutputPercent() > 0) {
      return true;
    } else {
      return false;
    }
  }

  public boolean isTurningReverse() {
    if (Motors.gripper_master.getMotorOutputPercent() < 0) {
      return true;
    } else {
      return false;
    }
  }

  @Override
  public void periodic() {
    ShuffleBoard.gripperCurrent.setDouble(Motors.gripper_master.getMotorOutputPercent());
  }
}
