// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class SlideSubsystem extends SubsystemBase {

  private static DigitalInput slideRightSwitch;
  private static DigitalInput slideLeftSwitch;

  private static CANSparkMax slideMotor;
  private static WPI_VictorSPX hookMotor;

  /** Creates a new SlideSubsystem. */
  public SlideSubsystem() {
    slideRightSwitch = new DigitalInput(Constants.S_RIGHT_SLIDE);
    slideLeftSwitch = new DigitalInput(Constants.S_LEFT_SLIDE);

    slideMotor = new CANSparkMax(Constants.M_SLIDE, CANSparkMaxLowLevel.MotorType.kBrushless);
    hookMotor = new WPI_VictorSPX(2);
  }

  public static void hookSet(double speed) {
    hookMotor.set(speed);
  }

  public static void set(double speed) {
    slideMotor.set(speed);
  }

  public boolean getRightSwitch() {
    return !slideRightSwitch.get();
  }

  public boolean getLeftSwitch() {
    return !slideLeftSwitch.get();
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
