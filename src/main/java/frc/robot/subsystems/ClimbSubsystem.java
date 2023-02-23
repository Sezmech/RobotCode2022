// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.ClimbConstants;

public class ClimbSubsystem extends SubsystemBase {
  /**
   * Creates a new ClimbSubsystem.
   */
  public boolean compressorState = false;
  public boolean climbState = false;
  private final Compressor compressor = new Compressor(PneumaticsModuleType.CTREPCM);
  private final DoubleSolenoid climbSolenoid = new DoubleSolenoid(PneumaticsModuleType.CTREPCM,
      ClimbConstants.kClimbDoubleSolenoidPort1, ClimbConstants.kClimbDoubleSolenoidPort2);


  public ClimbSubsystem() {
  }
  
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    SmartDashboard.putBoolean("climber/compressorState", compressorState);
    SmartDashboard.putBoolean("climber/climberState", climbState);
  }

  public void climberUp() {
    climbSolenoid.set(Value.kForward);
  }

  public void climberDown() {
    climbSolenoid.set(Value.kReverse);
  }

  public void stopCyclinders() {
    climbSolenoid.set(Value.kOff);
  }

  public void openCompressor() {
    compressor.enabled();
  }

  public void closeCompressor() {
    compressor.disable();
  }
}


/** 
*package frc.robot.subsystems;
*import edu.wpi.first.wpilibj2.command.button.JoystickButton;
*import edu.wpi.first.wpilibj.XboxController;
*import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
*import frc.robot.RobotContainer;
*import edu.wpi.first.wpilibj.TimedRobot;

import java.util.Set;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import frc.robot.Constants;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Subsystem;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
*/
//public class PneumaticsSubsystem extends SubsystemBase {
  /** Creates a new ExampleSubsystem. */
  /**   public DoubleSolenoid arm;
    public Compressor compressor;

  public PneumaticsSubsystem() {
    Compressor compressor = new Compressor(PneumaticsModuleType.CTREPCM); 
    arm = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, 2, 3);

  }

  

  @Override
  public void periodic() {
    // This method will be called once per scheduler run

  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }


}
*/
