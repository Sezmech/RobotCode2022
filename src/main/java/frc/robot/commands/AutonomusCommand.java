  // Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.CatapultSubsystem;
import frc.robot.subsystems.DriveSubsystem;

public class AutonomusCommand extends CommandBase {
  private final DriveSubsystem m_drive;
  private final CatapultSubsystem m_catapult;
  /** Creates a new AutonomusCommand. */
  public AutonomusCommand(DriveSubsystem subsystemDrive, CatapultSubsystem subsystemCatapult) {
    m_drive = subsystemDrive;
    m_catapult = subsystemCatapult;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(m_drive, m_catapult);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    m_drive.drive(-0.6, 0);

    try {
      Thread.sleep(2000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    m_drive.drive(0, 0);

  /*
    m_catapult.fire(0.7, false);

    try {
      Thread.sleep(2000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    m_catapult.intake(0.6);

    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    m_catapult.fire(0, true);
    m_catapult.intake(0);
  */
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {}

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return true;
  }
}
