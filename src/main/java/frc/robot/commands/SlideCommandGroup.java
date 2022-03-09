// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.SlideSubsystem;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class SlideCommandGroup extends SequentialCommandGroup {
  public SlideCommandGroup(SlideSubsystem m_slide) {
         addCommands(
             new SlideCommandBack(m_slide),
             new SlideCommandForward(m_slide));
  }
}
