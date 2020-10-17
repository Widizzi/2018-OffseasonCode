/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

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

    public static WPI_TalonSRX cart;

    public Motors() {
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

}
