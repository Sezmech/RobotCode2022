// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import com.revrobotics.CANSparkMax;
//import com.revrobotics.CANSparkMaxLowLevel;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class SlideSubsystem extends SubsystemBase {

  private static WPI_VictorSPX slideMotor;
  

  /** Creates a new SlideSubsystem. */
  public SlideSubsystem() {

    slideMotor = new WPI_VictorSPX(Constants.M_SLIDE);
    
    
  }

  public void slideMove(double speed) {
    slideMotor.set(ControlMode.PercentOutput, speed);
  }

 

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  
  }

}
