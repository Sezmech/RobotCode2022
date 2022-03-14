// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.LiftSubsystem;
import frc.robot.subsystems.SlideSubsystem;
import frc.robot.subsystems.LiftSubsystem.Lifts;
import frc.robot.subsystems.SlideSubsystem.HookMode;
import frc.robot.subsystems.SlideSubsystem.SlideSwitches;
import frc.robot.subsystems.LiftSubsystem.LiftSwitches;

public class ClimbCommand extends CommandBase {
  private final LiftSubsystem m_lift;
  private final SlideSubsystem m_slide;
  /** Creates a new ClimbCommand. */
  public ClimbCommand(LiftSubsystem subsystemLift, SlideSubsystem subsystemSlide) {
    m_lift = subsystemLift;
    m_slide = subsystemSlide;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(m_lift, m_slide);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    //Run both lift motors down
    m_lift.move(0.4);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    // 1) Shutdown each lift motor seperately
    while(!(m_lift.getSwitchState(LiftSwitches.rightLower) && m_lift.getSwitchState(LiftSwitches.leftLower))) {
      if(m_lift.getSwitchState(LiftSwitches.rightLower)) {
        m_lift.move(0, Lifts.rightLift);
      }

      if(m_lift.getSwitchState(LiftSwitches.leftLower)) {
        m_lift.move(0, Lifts.leftLift);
      }
    }
  
  
    // 2) Ensure slides are near lift
    m_slide.slideMove(0.4);

    while(!m_slide.getSwitchState(SlideSwitches.back)) {
      if(m_slide.getSwitchState(SlideSwitches.back)) {
        m_slide.slideMove(0);
      }
    }

    // 3) Close hook
    m_slide.hookMove(0.7, HookMode.close, 0.5);

  
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return true;
  }
}
