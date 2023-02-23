  // Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
//import frc.robot.subsystems.CatapultSubsystem;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.ShootSubsystem;
//import frc.robot.commands.SlideCommandForward;
//import frc.robot.subsystems.SlideSubsystem;

public class AutonomusCommand extends CommandBase {
  private final DriveSubsystem m_drive;
  private final ShootSubsystem m_shoot;
  private double error;
  private double currentAngle;
  private double drivePower;

  //private final SlideSubsystem m_slide;
  /** Creates a new AutonomusCommand. */
  public AutonomusCommand(DriveSubsystem subsystemDrive, ShootSubsystem subsystemshoot) {
    m_drive = subsystemDrive;
    m_shoot = subsystemshoot;
    //m_slide = subsystemSlide;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(m_drive, m_shoot);

  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    
    
    
    
    
    
    /*m_drive.drive(-0.7, 0);
    
    try {
      Thread.sleep(3 * 1000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    m_drive.drive(0, 0);


   // m_shoot.changeSpeed(-0.7);
    //m_shoot.hookMove();

    try {
      Thread.sleep(2000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    m_shoot.feedMove(0.4);

    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    */
    //m_shoot.changeSpeed(0.0);
    //m_shoot.feedMove(0);
  
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
   //m_slide.slideMove(1);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_drive.stop();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return true;
  }
}
