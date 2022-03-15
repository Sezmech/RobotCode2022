// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.CatapultSubsystem;

public class FeedCommand extends CommandBase {
  private final CatapultSubsystem m_catapult;
  /** Creates a new FeedCommand. */
  public FeedCommand(CatapultSubsystem subsystem) {
    m_catapult = subsystem;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(m_catapult);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_catapult.feed(0.7);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
