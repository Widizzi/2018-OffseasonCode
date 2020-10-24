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
import com.ctre.phoenix.motorcontrol.StatusFrameEnhanced;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

/**
 * Add your docs here.
 */
public class Motors {

    public static WPI_TalonSRX lift_master;
    public static WPI_TalonSRX lift_follower;

    public Motors() {
        configLiftingUnitMotors();
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
