// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.LiftSubsystem;

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
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_lift.move(-0.4);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_lift.move(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
