// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.commands.AutoShoot;
import frc.robot.commands.AutonomusCommand;
import frc.robot.commands.DriveCommand;
import frc.robot.commands.ShootCommandDown;
import frc.robot.commands.ShootCommandUp;
import frc.robot.commands.LiftCommandDown;
import frc.robot.commands.LiftCommandUp;
import frc.robot.commands.LimelightCommand;
import frc.robot.commands.SlideCOmmandBackwards;
import frc.robot.commands.SlideCommandForward;
import frc.robot.commands.Climber.*;
import frc.robot.subsystems.CatapultSubsystem;
import frc.robot.subsystems.DriveSubsystem;
//import frc.robot.subsystems.ExampleSubsystem;
import frc.robot.subsystems.ClimbSubsystem;
import frc.robot.subsystems.LiftSubsystem;
import frc.robot.subsystems.LimelightSubsystem;
import frc.robot.subsystems.ShootSubsystem;
import frc.robot.subsystems.SlideSubsystem;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.commands.BalanceNavxcommand;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
 // private final ExampleSubsystem m_exampleSubsystem = new ExampleSubsystem();

  // Joystick object initialization
  public static Joystick joystickD = new Joystick(Constants.JOYSTICK_D);
  public static Joystick joystickC = new Joystick(Constants.JOYSTICK_C);

  // Subsystem Definitions
  private final DriveSubsystem m_drive = new DriveSubsystem();
  private final LiftSubsystem m_lift = new LiftSubsystem();
  private final SlideSubsystem m_slide = new SlideSubsystem();
  private final CatapultSubsystem m_catapult = new CatapultSubsystem();
  private final LimelightSubsystem m_lime = new LimelightSubsystem();
  private final ShootSubsystem m_shoot = new ShootSubsystem();
  private final ClimbSubsystem m_climb = new ClimbSubsystem();

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
    
    // Lift Up
    new JoystickButton(joystickC, 7)
      .whileHeld(new LiftCommandUp(m_lift), true);

    new JoystickButton(joystickD, 5)
      .whileHeld(new LiftCommandUp(m_lift), true);

    // Lift Down
    new JoystickButton(joystickC, 9)
      .whileHeld(new LiftCommandDown(m_lift), true);

    new JoystickButton(joystickD, 6)
      .whileHeld(new LiftCommandDown(m_lift), true);
    
    //Slide Forward
    new JoystickButton(joystickC, 11)
      .whileHeld(new SlideCommandForward(m_slide), true);

      new JoystickButton(joystickD, 3)
      .toggleWhenPressed(new SlideCommandForward(m_slide), true);
      //whileHeld
    //Slide Back
    new JoystickButton(joystickC, 12)
      .whileHeld(new SlideCOmmandBackwards(m_slide), true);

    new JoystickButton(joystickD, 2)
      .toggleWhenPressed(new SlideCOmmandBackwards(m_slide), true);
    
    //Hook Open/shoot back
    new JoystickButton(joystickC, 3)
      .whenPressed(new ShootCommandUp(m_shoot), true);

    //Hook Close/shoot forward
    new JoystickButton(joystickC, 5)
      .whenPressed(new ShootCommandDown(m_shoot), true);

    //new JoystickButton(joystickC, 4)
      //.whileHeld(new LimelightCommand(m_lime), true);

    new JoystickButton(joystickC, 111111)
      .whileHeld(new AutoShoot(m_drive, m_lime), true);
     // triggerbuttona ata

    new JoystickButton(joystickC, 6)
     .whileHeld(new OpenClimb(m_climb), true);

    new JoystickButton(joystickC, 4)
     .whileHeld(new CloseClimb(m_climb), true);

    new JoystickButton(joystickD, 1)
     
      .whileHeld(new BalanceNavxcommand(m_drive), true);

    }
  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return new AutonomusCommand(m_drive, m_shoot);
  }
}