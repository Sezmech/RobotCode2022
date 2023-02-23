// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.LimelightSubsystem;

public class AutoShoot extends CommandBase {
  private final DriveSubsystem m_drive;
  private final LimelightSubsystem m_lime;
  private PIDController pid;
   
  
  
  /** Creates a new LiftCommandDown. */
  public AutoShoot(DriveSubsystem subsystemDrive, LimelightSubsystem subsystemLimelight) {
    m_drive = subsystemDrive;
    m_lime = subsystemLimelight;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(m_drive, m_lime);

  }
  
  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    pid = new PIDController(1,0,0);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
   //if(!(|m_lime.tx| <= 0.0087 ))
   //m_drive.drive(0,pid.calculate(m_lime.tx,0.0));
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}


