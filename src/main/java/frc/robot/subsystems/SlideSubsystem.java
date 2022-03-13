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

public class SlideSubsystem extends SubsystemBase {

  private static WPI_VictorSPX slideMotor;
  private static WPI_VictorSPX hookMotor;

  /** Creates a new SlideSubsystem. */
  public SlideSubsystem() {

    slideMotor = new WPI_VictorSPX(Constants.M_SLIDE);
    hookMotor = new WPI_VictorSPX(Constants.M_HOOK);
    
  }

  public void slideMove(double speed) {
    slideMotor.set(ControlMode.PercentOutput, speed);
  }

  public void hookMove(double speed) {
    hookMotor.set(ControlMode.PercentOutput, speed);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
