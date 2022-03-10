// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class SlideSubsystem extends SubsystemBase {

  private static DigitalInput slideRightSwitch;
  private static DigitalInput slideLeftSwitch;

  private static CANSparkMax slideMotor;
  private static WPI_VictorSPX hookMotor;

  private static PIDController pid;

  /** Creates a new SlideSubsystem. */
  public SlideSubsystem() {
    pid = new PIDController(0.006, 0, 0.001);

    slideRightSwitch = new DigitalInput(Constants.S_RIGHT_SLIDE);
    slideLeftSwitch = new DigitalInput(Constants.S_LEFT_SLIDE);

    slideMotor = new CANSparkMax(Constants.M_SLIDE, CANSparkMaxLowLevel.MotorType.kBrushless);
    hookMotor = new WPI_VictorSPX(2);
  }

  public double pidValue(double encValue) {
    return pid.calculate(encValue, 0);
  }

  public void hookSet(double speed) {
    if (speed == 0.0) {
      hookMotor.setNeutralMode(NeutralMode.Brake);
      hookMotor.stopMotor();
    }
    else {
      hookMotor.set(speed);
    }
  }

  public void moveBack() {
    slideMotor.set(0.2);
  }

  public void moveForward() {
    slideMotor.set(-0.2);
  }

  public void motorStop() {
    slideMotor.stopMotor();
  }

  public boolean getRightSwitch() {
    return !slideRightSwitch.get();
  }

  public boolean getLeftSwitch() {
    return !slideLeftSwitch.get();
  }

}
