package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.LiftSubsystem;

public class LiftCommandGroup extends SequentialCommandGroup {
     public LiftCommandGroup(LiftSubsystem m_lift) {
            addCommands(
                new LiftCommandUP(m_lift),
                new LiftCommandDOWN(m_lift));
     }
}
