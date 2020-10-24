/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.InvertType;
import com.ctre.phoenix.motorcontrol.LimitSwitchNormal;
import com.ctre.phoenix.motorcontrol.LimitSwitchSource;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.LimitSwitchNormal;
import com.ctre.phoenix.motorcontrol.LimitSwitchSource;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.StatusFrameEnhanced;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

/**
 * Add your docs here.
 */
public class Motors {

    public static WPI_TalonSRX lift_master;
    public static WPI_TalonSRX lift_follower;

    private static WPI_TalonSRX gripper_motor_right;
    private static WPI_TalonSRX gripper_motor_left;
    public static WPI_TalonSRX gripper_master;

    public static WPI_TalonSRX cart;

    public Motors() {
        configGripperMotors();
        configLiftingUnitMotors();
        configCartMotors();
    }

    private void configCartMotors() {

        if(Constants.IS_CART_SUBSYSTEM_IN_USE) {

            cart = new WPI_TalonSRX(Constants.MOTOR_CART_ID);

            cart.configFactoryDefault();

            cart.setNeutralMode(NeutralMode.Brake);

            cart.setInverted(true);

            cart.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, 0, 30);
            cart.setSensorPhase(false);

            // PID
            cart.configOpenloopRamp(1);
            cart.configClosedloopRamp(0);
            cart.setStatusFramePeriod(StatusFrameEnhanced.Status_13_Base_PIDF0, 10, 30);
            cart.setStatusFramePeriod(StatusFrameEnhanced.Status_10_MotionMagic, 10, 30);
            cart.configNominalOutputForward(0, 30);
            cart.configNominalOutputReverse(0, 30);
            cart.configPeakOutputForward(1, 30);
            cart.configPeakOutputReverse(-1, 30);

            cart.selectProfileSlot(0, 0);
            cart.config_kF(0, 1 * 1023.0 / 22000, 30);
            cart.config_kP(0, 0.8, 30);
            cart.config_kI(0, 0, 30);
            cart.config_kD(0, 80, 30);
            cart.config_IntegralZone(0, 500);
            cart.configMotionCruiseVelocity(22000 / 2, 30);
            cart.configMotionAcceleration(22000, 30);

            // Limit Switches
            cart.configReverseLimitSwitchSource(LimitSwitchSource.FeedbackConnector, LimitSwitchNormal.NormallyClosed);
            cart.configForwardLimitSwitchSource(LimitSwitchSource.FeedbackConnector, LimitSwitchNormal.NormallyOpen);

            // Zero Encoder
            cart.setSelectedSensorPosition(0, 0, 30);
 
        }
    }

    private void configGripperMotors() {

        if(Constants.IS_GRIPPER_SUBSYSTEM_IN_USE) {

            gripper_motor_right = new WPI_TalonSRX(Constants.MOTOR_GRIPPER_RIGHT_ID);
            gripper_motor_left = new WPI_TalonSRX(Constants.MOTOR_GRIPPER_LEFT_ID);

            gripper_motor_right.configFactoryDefault();
            gripper_motor_left.configFactoryDefault();

            gripper_motor_left.follow(gripper_motor_right);
            gripper_motor_left.setInverted(true);

            gripper_master = gripper_motor_right;

        }

    }

    private void configLiftingUnitMotors() {
        if(Constants.IS_LIFTING_UNIT_SUBSYSTEM_IN_USE) {
            lift_master = new WPI_TalonSRX(Constants.MOTOR_LIFTING_UNIT_MASTER_ID);
            lift_follower = new WPI_TalonSRX(Constants.MOTOR_LIFTING_UNIT_FOLLOWER_ID);

            lift_master.configFactoryDefault();
            lift_follower.configFactoryDefault();

            lift_master.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, 0, 30);
            lift_master.configReverseLimitSwitchSource(LimitSwitchSource.FeedbackConnector, LimitSwitchNormal.NormallyClosed);
            // PID
            lift_master.setStatusFramePeriod(StatusFrameEnhanced.Status_13_Base_PIDF0, 10, 30);
            lift_master.setStatusFramePeriod(StatusFrameEnhanced.Status_10_MotionMagic, 10, 30);
            lift_master.configNominalOutputForward(0, 30);
            lift_master.configNominalOutputReverse(0, 30);
            lift_master.configPeakOutputForward(1, 30);
            lift_master.configPeakOutputReverse(-1, 30);

            //PID for primary robot
            lift_master.selectProfileSlot(0, 0);
            lift_master.config_kF(0, 0.8525, 30);
            lift_master.config_kP(0, 1.2, 30);
            lift_master.config_kI(0, 0.0, 30);
            lift_master.config_kD(0, 18.0, 30);
            lift_master.config_IntegralZone(0, 200);
            lift_master.configAllowableClosedloopError(0, 30, 30);
            lift_master.configMotionCruiseVelocity(Constants.LIFTING_UNIT_MAX_VELOCITY_ENCODER_UNITS_PER_100_MS * 4 / 3,
                    30);
            lift_master.configMotionAcceleration(Constants.LIFTING_UNIT_MAX_VELOCITY_ENCODER_UNITS_PER_100_MS, 30);

            lift_master.setSensorPhase(true);

            // Set Directions of Motors
            lift_master.setInverted(false);
            lift_follower.setInverted(InvertType.OpposeMaster);

            // Set Follower
            lift_follower.follow(lift_master);
        }
    } 

}
