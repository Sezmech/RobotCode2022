package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.SlideSubsystem;

public class SlideCommandGroup extends SequentialCommandGroup {
     public SlideCommandGroup(SlideSubsystem m_Slide) {
            addCommands(
                new SlideCommandFRONT(m_Slide),
                new SlideCommandBACK(m_Slide));
    }