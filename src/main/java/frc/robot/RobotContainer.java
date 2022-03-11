// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.commands.DriveCommand;
import frc.robot.commands.ExampleCommand;
import frc.robot.commands.FeedCommand;
import frc.robot.commands.HookCommandDown;
import frc.robot.commands.HookCommandUp;
import frc.robot.commands.IntakeCommand;
import frc.robot.commands.LiftCommandDown;
import frc.robot.commands.LiftCommandUp;
import frc.robot.commands.ShootCommand;
import frc.robot.commands.SlideCOmmandBackwards;
import frc.robot.commands.SlideCommandForward;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.ExampleSubsystem;
import frc.robot.subsystems.LiftSubsystem;
import frc.robot.subsystems.ShooterSubsystem;
import frc.robot.subsystems.SlideSubsystem;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final ExampleSubsystem m_exampleSubsystem = new ExampleSubsystem();

  private final ExampleCommand m_autoCommand = new ExampleCommand(m_exampleSubsystem);

  // Joystick object initialization
  public static Joystick joystick = new Joystick(Constants.JOYSTICK_D);

  // Subsystem Definitions
  private final DriveSubsystem m_drive = new DriveSubsystem();
  private final LiftSubsystem m_lift = new LiftSubsystem();
  private final SlideSubsystem m_slide = new SlideSubsystem();
  private final ShooterSubsystem m_shoot = new ShooterSubsystem();

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    //Makes it so DriveCommand is always called unless DriveSubsystem is used elsewhere which will not happen
     m_drive.setDefaultCommand(new DriveCommand(m_drive));
    // Configure the button bindings
    configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */

  private void configureButtonBindings() {
    
    new JoystickButton(joystick, 5)
      .whileHeld(new LiftCommandUp(m_lift));

    new JoystickButton(joystick, 7)
      .whileHeld(new LiftCommandDown(m_lift));
    
  
    new JoystickButton(joystick, 4)
      .whileHeld(new SlideCommandForward(m_slide));

    new JoystickButton(joystick, 2)
      .whileHeld(new SlideCOmmandBackwards(m_slide));
    
    new JoystickButton(joystick, 6)
      .whileHeld(new HookCommandUp(m_slide));

    new JoystickButton(joystick, 8)
      .whileHeld(new HookCommandDown(m_slide));

    new JoystickButton(joystick, 1)
      .whileHeld(new ShootCommand(m_shoot));

    new JoystickButton(joystick, 3)
      .whileHeld(new FeedCommand(m_shoot));

      new JoystickButton(joystick, 12)
      .toggleWhenPressed(new IntakeCommand(m_shoot));
      
      
    }
  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return m_autoCommand;
  }
}