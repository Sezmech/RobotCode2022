// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;

public class SlideCommandBACK extends CommandBase {
  /** Creates a new LiftCommand. */
  private final SlideSubsystem m_subsystem;

  public SlideCommandBACK(SlideSubsystem subsystem){
    m_subsystem = subsystem;
    addRequirements(m_subsystem);
    // Use addRequirements() here to declare subsystem dependencies. 
  }

  private void addRequirements(frc.robot.commands.SlideSubsystem m_subsystem2) {
}

// Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_subsystem.moveBACK();
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end (boolean interrupted) { 
    m_subsystem.motorStop();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return m_subsystem.backSwitchState(); 
  }
}
