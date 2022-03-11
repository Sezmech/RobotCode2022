// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import frc.robot.Constants;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class LiftSubsystem extends SubsystemBase {
  
  private static WPI_VictorSPX liftMotor1;
  private static WPI_VictorSPX liftMotor2;

  /** Creates a new LiftSubsystem. */
  public LiftSubsystem() {
    liftMotor1 = new WPI_VictorSPX(Constants.M_LIFT1);
    liftMotor2 = new WPI_VictorSPX(Constants.M_LIFT2);
  }

  public void move(double speed) {
    liftMotor1.set(ControlMode.PercentOutput, speed);
    liftMotor2.set(ControlMode.PercentOutput, speed);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
