/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj.smartdashboard.SendableBuilder;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Motors;

public class LiftingUnitSubsystem extends SubsystemBase {

  int targetPosition;
  boolean autonomous, isHomed;

  public LiftingUnitSubsystem() {
    targetPosition = 0;
    autonomous = false;
    isHomed = false;
  }


  public void resetSubsystem() {
    isHomed = false;
    targetPosition = 0;
    autonomous = false;
  }

  public boolean isHomed() {
    return isHomed;
  }

  public void enableAutonomous(boolean enable) {
    autonomous = enable;
  }

  public double getPosition() {
    return Motors.lift_master.getSelectedSensorPosition();
  }

  public void setPosition(int position) {
    targetPosition = position;
  }

  public void drive(double value) {
    if (autonomous) {
      driveAutonomous();
    } else {
      driveManual(value);
    }
  }

  public void drive() {
    drive(0);
  }

  private void driveAutonomous() {
    if(isHomed()) {
      Motors.lift_master.set(ControlMode.MotionMagic, targetPosition);
    }
  }

  private void driveManual(double speed) {
    Motors.lift_master.set(ControlMode.PercentOutput, speed);
  }

  public void stop() {
    Motors.lift_master.set(ControlMode.PercentOutput, 0);
  }

  public void checkLimitSwitches() {
    if (isRevLimitSwitchClosed()) {
      Motors.lift_master.setSelectedSensorPosition(0);
      isHomed = true;
    } 
  }

  public boolean isRevLimitSwitchClosed() {
    return Motors.lift_master.isRevLimitSwitchClosed() == 0;
  }

  @Override
  public void periodic() {
    checkLimitSwitches();
  }

  @Override
  public void initSendable(SendableBuilder builder) {
    super.initSendable(builder);
    builder.addBooleanProperty("Homed", this::isHomed, null);
    builder.addDoubleProperty("Motor Speed", Motors.lift_master::get, Motors.lift_master::set);
    builder.addBooleanProperty("Reverse Limit", this::isRevLimitSwitchClosed, null);
    builder.addDoubleProperty("Position", this::getPosition, null);
  }
}