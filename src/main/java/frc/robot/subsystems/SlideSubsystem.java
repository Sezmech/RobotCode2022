// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class SlideSubsystem extends SubsystemBase {
  public enum SlideSwitches {
    front,
    back;
  }

  public enum HookMode {
    close,
    open;
  }

  private WPI_VictorSPX slideMotor;
  private WPI_VictorSPX hookMotor;

  private DigitalInput frontSwitch;
  private DigitalInput backSwitch;

  /** Creates a new SlideSubsystem. */
  public SlideSubsystem() {

    slideMotor = new WPI_VictorSPX(Constants.M_SLIDE);
    hookMotor = new WPI_VictorSPX(Constants.M_HOOK);

    frontSwitch = new DigitalInput(Constants.S_FRONT_SLIDE);
    backSwitch = new DigitalInput(Constants.S_BACK_SLIDE);
    
  }

  //Move slide cart
  public void slideMove(double speed) {
  slideMotor.set(speed);
  }

  //Open/close hooks
  public void hookMove(double speed, HookMode mode, double time) {
    int mod = (mode == HookMode.open) ?(1) :(-1);
    hookMotor.set(ControlMode.PercentOutput, mod * speed);

    try {
      Thread.sleep((long) (time * 1000));
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    hookMotor.set(ControlMode.PercentOutput, 0);
  }

  //Get the state of any switch
  public boolean getSwitchState(SlideSwitches switchName) {

    switch(switchName){
      case front: return !frontSwitch.get();
      case back: return !backSwitch.get();
    }
    
    return false;
  }

  // This method will be called once per scheduler run
  @Override
  public void periodic() {

    //Prints switch states
    SmartDashboard.putBoolean("Front", getSwitchState(SlideSwitches.front));
    SmartDashboard.putBoolean("Back", getSwitchState(SlideSwitches.back));
  }
}
