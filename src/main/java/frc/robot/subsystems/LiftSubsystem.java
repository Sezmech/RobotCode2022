// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import frc.robot.Constants;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class LiftSubsystem extends SubsystemBase {

  public enum LiftSwitches {
    rightUpper,
    leftUpper,
    rightLower,
    leftLower;
  }

  public enum Lifts {
    rightLift,
    leftLift;
  }
  
  private static WPI_VictorSPX rightLiftMotor;
  private static WPI_VictorSPX leftLiftMotor;

  //Upper Switch Initializations
  private static DigitalInput rightUpperSwitch;
  private static DigitalInput leftUppperSwitch;

  //Lower Switch Initializations
  private static DigitalInput rightLowerSwitch;
  private static DigitalInput leftLowerSwitch;

  /** Creates a new LiftSubsystem. */
  public LiftSubsystem() {
    rightLiftMotor = new WPI_VictorSPX(Constants.M_RIGHT_LIFT);
    leftLiftMotor = new WPI_VictorSPX(Constants.M_LEFT_LIFT);

    //Upper Switch Assignments
    rightUpperSwitch = new DigitalInput(0);
    leftUppperSwitch = new DigitalInput(2);

    //Lower Switch Assignment
    rightLowerSwitch = new DigitalInput(3);
    leftLowerSwitch = new DigitalInput(4);
  }

  //Move the lift motors together;
  public void move(double speed) {
    rightLiftMotor.set(ControlMode.PercentOutput, speed);
    leftLiftMotor.set(ControlMode.PercentOutput, speed);
  }

  //Move one of the motors
  public void move(double speed, Lifts motor) {
    if (motor == Lifts.rightLift) rightLiftMotor.set(ControlMode.PercentOutput, speed);
    else if (motor == Lifts.leftLift) leftLiftMotor.set(ControlMode.PercentOutput, speed);
  }


  //Get the state of any switch
  public boolean getSwitchState(LiftSwitches switchName) {

    switch(switchName){
      case rightUpper: return !rightUpperSwitch.get();
      case leftUpper: return !leftUppperSwitch.get();
      case rightLower: return !rightLowerSwitch.get();
      case leftLower: return !leftLowerSwitch.get();
    }
    
    return false;
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run

    //Prints switch states
    SmartDashboard.putBoolean("Right Upper", getSwitchState(LiftSwitches.rightUpper));
    SmartDashboard.putBoolean("Left Upper", getSwitchState(LiftSwitches.leftUpper));

    SmartDashboard.putBoolean("Right Lower", getSwitchState(LiftSwitches.rightLower));
    SmartDashboard.putBoolean("Left Lower", getSwitchState(LiftSwitches.leftLower));
    
  }
}
