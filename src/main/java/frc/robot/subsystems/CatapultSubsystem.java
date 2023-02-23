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

public class CatapultSubsystem extends SubsystemBase {
  private CANSparkMax catapult1;
  private CANSparkMax catapult2;

  private WPI_VictorSPX intakeMotor;
  /** Creates a new CatapultSubsystem. */
  public CatapultSubsystem() {
    catapult1 = new CANSparkMax(Constants.M_CATAPULT1, CANSparkMaxLowLevel.MotorType.kBrushless);
    catapult2 = new CANSparkMax(Constants.M_CATAPULT2, CANSparkMaxLowLevel.MotorType.kBrushless);
    intakeMotor = new WPI_VictorSPX(Constants.M_INTAKE);
    
  }

  public void catapultfire(double speed, boolean both) {
    if(both) {
      catapult1.set(speed);
      catapult2.set(speed);
    }
    else {
      catapult1.set(speed);
    }
  }

  public void intake(double speed) {
    intakeMotor.set(ControlMode.PercentOutput, speed);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
