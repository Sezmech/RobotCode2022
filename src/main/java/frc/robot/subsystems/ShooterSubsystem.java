// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class ShooterSubsystem extends SubsystemBase {
  private static CANSparkMax shooterMotor;
  private static WPI_VictorSPX feedMotor;
  private static WPI_VictorSPX intakeMotor;
  /** Creates a new ShooterSubsystem. */
  public ShooterSubsystem() {
    shooterMotor = new CANSparkMax(Constants.M_SHOOTER, CANSparkMaxLowLevel.MotorType.kBrushless);
    feedMotor = new WPI_VictorSPX(Constants.M_FEED);
    intakeMotor = new WPI_VictorSPX(Constants.M_INTAKE);
  }

  public void shoot(double speed) {
    shooterMotor.set(speed);
  }

  public void feed(double speed) {
    feedMotor.set(ControlMode.PercentOutput, speed);
  }

  public void intake(double speed) {
    intakeMotor.set(ControlMode.PercentOutput, speed);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
