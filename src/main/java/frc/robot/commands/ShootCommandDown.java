// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ShootSubsystem;
import frc.robot.subsystems.LimelightSubsystem;
//import frc.robot.subsystems.LimelightSubsystem;
import frc.robot.RobotContainer;
import frc.robot.Robot;


public class ShootCommandDown extends CommandBase {
  private final ShootSubsystem m_shoot;
  
  

  /** Creates a new HookCommandDown. */
  public ShootCommandDown(ShootSubsystem subsystem) {
    m_shoot = subsystem;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(m_shoot);
  }
  
  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
   if(Robot.enval <= 100000){
    m_shoot.feedMove(0.1);
   }else{
     m_shoot.feedMove(0);
   }
    /*m_shoot.hookMove(0.2);
    try {
      Thread.sleep(2000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    m_shoot.feedMove(0);
    */
    
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  
    m_shoot.feedMove(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}