// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel;
import frc.robot.Constants;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class LiftSubsystem extends SubsystemBase {
  
  private static CANSparkMax liftMotor;

  /** Creates a new LiftSubsystem. */
  public LiftSubsystem() {
    liftMotor = new CANSparkMax(Constants.M_LIFT, CANSparkMaxLowLevel.MotorType.kBrushless);
  }

  public void move(double speed) {
    liftMotor.set(speed);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
