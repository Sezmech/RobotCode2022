// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.SlideSubsystem;

public class SlideCommandForward extends CommandBase {
  private final SlideSubsystem m_slide;
  /** Creates a new SlideCommandForward. */
  public SlideCommandForward(SlideSubsystem subsystem) {
    m_slide = subsystem;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(m_slide);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_slide.slideMove(-0.4);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_slide.slideMove(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
