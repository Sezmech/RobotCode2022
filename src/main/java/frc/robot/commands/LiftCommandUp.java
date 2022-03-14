// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.LiftSubsystem;
import frc.robot.subsystems.LiftSubsystem.Lifts;
import frc.robot.subsystems.LiftSubsystem.LiftSwitches;

public class LiftCommandUp extends CommandBase {
  private final LiftSubsystem m_lift;
  /** Creates a new LiftCommandUp. */
  public LiftCommandUp(LiftSubsystem subsystem) {
    m_lift = subsystem;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(m_lift);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    m_lift.move(-0.4);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {

    //Shut down motors seperately when they hit their switches
    if(m_lift.getSwitchState(LiftSwitches.rightUpper)) {
      m_lift.move(0, Lifts.rightLift);
    }

    if(m_lift.getSwitchState(LiftSwitches.leftUpper)) {
      m_lift.move(0, Lifts.leftLift);
    }
    
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_lift.move(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    //Finish when both switches are pressed
    return (m_lift.getSwitchState(LiftSwitches.rightUpper) && m_lift.getSwitchState(LiftSwitches.leftUpper));
  }
}
