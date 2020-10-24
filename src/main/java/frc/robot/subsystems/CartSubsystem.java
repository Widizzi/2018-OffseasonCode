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
import frc.robot.Constants;
import frc.robot.Motors;

public class CartSubsystem extends SubsystemBase {

  int targetPosition;
  boolean autonomous, isHomed;

  public CartSubsystem() {
    System.out.println("init");
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
    return Motors.cart.getSelectedSensorPosition();
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
      Motors.cart.set(ControlMode.MotionMagic, targetPosition);
    }
  }

  private void driveManual(double speed) {
    Motors.cart.set(ControlMode.PercentOutput, speed);
  }

  public void stop() {
    Motors.cart.set(ControlMode.PercentOutput, 0);
  }

  public void checkLimitSwitches() {
    if (isRevLimitSwitchClosed()) {
      Motors.cart.setSelectedSensorPosition(0);
      isHomed = true;
    } 
    else if (isFwdLimitSwitchClosed()) {
      Motors.cart.setSelectedSensorPosition(Constants.CART_DRIVE_LENGTH);
      isHomed = true;
    }
  }

  public boolean isRevLimitSwitchClosed() {
    return Motors.cart.isRevLimitSwitchClosed() == 0;
  }

  public boolean isFwdLimitSwitchClosed() {
    return Motors.cart.isFwdLimitSwitchClosed() == 1;
  }

  @Override
  public void periodic() {
    checkLimitSwitches();
  }

  @Override
  public void initSendable(SendableBuilder builder) {
    super.initSendable(builder);
    builder.addBooleanProperty("Homed", this::isHomed, null);
    builder.addDoubleProperty("Motor Speed", Motors.cart::get, Motors.cart::set);
    builder.addBooleanProperty("Reverse Limit", this::isRevLimitSwitchClosed, null);
    builder.addBooleanProperty("Forward limit", this::isFwdLimitSwitchClosed, null);
    builder.addDoubleProperty("Position", this::getPosition, null);
  }
}
