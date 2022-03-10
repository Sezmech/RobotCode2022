// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.SlideSubsystem;

public class SlideCommand extends CommandBase {
  private final SlideSubsystem m_subsystem;
  /** Creates a new SlideCommandLeft. */
  public SlideCommand(SlideSubsystem subsystem) {
    m_subsystem = subsystem;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(m_subsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    // Makes the motor move forward until it hits the right limit switch
    while(!m_subsystem.getRightSwitch()) {
      m_subsystem.move(0.3);
    }

    //After the limit switch is hit te direction is reversed and keeps going until the left switch is hit.
    m_subsystem.move(-0.3);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {}

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_subsystem.move(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return m_subsystem.getLeftSwitch();
  }
}
