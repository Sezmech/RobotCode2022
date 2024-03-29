 // Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.LiftSubsystem;

public class LiftCommand extends CommandBase {
  /** Creates a new LiftCommand. */
  private final LiftSubsystem m_subsystem;

  public LiftCommand(LiftSubsystem subsystem){
    m_subsystem = subsystem;
    addRequirements(m_subsystem);
    // Use addRequirements() here to declare subsystem dependencies. 
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    while(!m_subsystem.upperSwitchState()) {
      m_subsystem.moveUp();
    }

    m_subsystem.moveDown();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {}

  // Called once the command ends or is interrupted.
  @Override
  public void end (boolean interrupted) { 
    m_subsystem.motorStop();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return m_subsystem.lowerSwitchState(); 
  }
}
