// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.subsystems.DriveSubsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.Robot;
/** An example command that uses an example subsystem. */
public class BalanceNavxcommand extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  //private final ExampleSubsystem m_subsystem;
  private final DriveSubsystem m_drive;

  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  public BalanceNavxcommand(DriveSubsystem subsystemDrive) {
    m_drive = subsystemDrive;
    //m_subsystem = subsystem;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(m_drive);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
     m_drive.drive(0.2,0);
  
    //if (Robot.getPitch() < Constants.MAXBALANCEPITCH || Robot.getPitch() > Constants.MINBALANCEPITCH){
     // m_drive.drive(0,0);
     // return;

    //}else if (Robot.getPitch() < Constants.MINBALANCEPITCH){
     // m_drive.drive(-Constants.AUTOBALANCESPEED, 0); // Drive forward
     // return;

   // }else if (Robot.getPitch() > Constants.MAXBALANCEPITCH){
   // m_drive.drive(Constants.AUTOBALANCESPEED, 0); // Drive backward if necessary
  //  }

  }

  

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_drive.drive(0, 0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}

