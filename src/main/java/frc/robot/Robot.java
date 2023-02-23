// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.subsystems.DriveSubsystem;
import java.lang.ModuleLayer.Controller;
import frc.robot.subsystems.ShootSubsystem;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.SerialPort;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import edu.wpi.first.wpilibj2.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
//mport edu.wpi.first.wpilibj.drive.DifferentialDrive;
//import edu.wpi.first.wpilibj.drive.MecanumDrive;
//import com.revrobotics.CANSparkMaxLowLevel.MotorType;
//import com.revrobotics.CANSparkMax;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.subsystems.LimelightSubsystem;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import frc.robot.RobotContainer;
import frc.robot.commands.BalanceNavxcommand;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.util.Color;
import frc.robot.Constants;
import com.revrobotics.ColorSensorV3;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import com.revrobotics.ColorMatchResult;
import com.revrobotics.CANSparkMax;
import com.revrobotics.ColorMatch;
import com.kauailabs.navx.frc.AHRS;
import edu.wpi.first.cameraserver.CameraServer;
import frc.robot.subsystems.ShootSubsystem;
import frc.robot.commands.BalanceNavxcommand;



/**
 * The VM is configured to automatically run this class, and to call the functions corresponding to
 * each mode, as described in the TimedRobot documentation. If you change the name of this class or
 * the package after creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
  private Command m_autonomousCommand;
  private RobotContainer m_robotContainer;
  private ShootSubsystem m_shoot;
  public BalanceNavxcommand m_balancenavx;
  private DriveSubsystem m_drive;

 private Encoder encoder = new Encoder(0, 1, true, EncodingType.k4X);
 private final double kDriveTick2Feet = 1.0 / 4096 * 6 * Math.PI / 12;
 
 
 
 //lkl
 public static AHRS navx = new AHRS(SerialPort.Port.kMXP);
 public static String ANGLE = "ANGLE";
 public static String DISZ = "Displacement in meters";
 public static double cPitch = 0;
 public static double cDisZ = 0;
 public static double cDisY = 0;
 public static double cDisX = 0;
 public static double cDisW = 0;
 //public static double cVelX = 0;
 public static double cVelY = 0;
 public static double cVelZ = 0;
 public static double cDec = 0;
 public static double enval = 0;
 public static void setcVelX(double cVelX) {
     //Robot.cVelX = 0 < cVelX;
    }
    private double error;
    private double currentAngle;
    private double drivePower;
 
  /**
   * Change the I2C port below to match the connection of your color sensor
   */
  private final I2C.Port i2cPort = I2C.Port.kOnboard;
 
  /**
   * A Rev Color Sensor V3 object is constructed with an I2C port as a 
   * parameter. The device will be automatically initialized with default 
   * parameters.
   */
  private final ColorSensorV3 m_colorSensor = new ColorSensorV3(i2cPort);
 
  /**
   * A Rev Color Match object is used to register and detect known colors. This can 
   * be calibrated ahead of time or during operation.
   * 
   * This object uses a simple euclidian distance to estimate the closest match
   * with given confidence range.
   */
  private final ColorMatch m_colorMatcher = new ColorMatch();

  /**
   * Note: Any example colors should be calibrated as the user needs, these
   * are here as a basic example.
   */
  private final Color kBlueTarget = new Color(0.143, 0.427, 0.429);
  private final Color kGreenTarget = new Color(0.197, 0.561, 0.240);
  private final Color kRedTarget = new Color(0.561, 0.232, 0.114);
  private final Color kYellowTarget = new Color(0.361, 0.524, 0.113);

  //public static void m_speed() {
    //if (RobotContainer.joystickC.getRawButton(10) == true){
      //m_speed.set(-0.2);
    //}
  
  //}
  public void shoot(Double distance) {
    // Here, spin motors necessary to shoot a ball
    // NOTE: distance will always be -1.0, as it has not yet been implemented
  }
   
  /**
   * This function is run when the robot is first started up and should be used for any
   * initialization code.
   */
  @Override
  public void robotInit() {
    // Instantiate our RobotContainer.  This will perform all our button bindings, and put our
    // autonomous chooser on the dashboard.
    m_robotContainer = new RobotContainer();
    m_colorMatcher.addColorMatch(kBlueTarget);
    m_colorMatcher.addColorMatch(kGreenTarget);
    m_colorMatcher.addColorMatch(kRedTarget);
    m_colorMatcher.addColorMatch(kYellowTarget);  
    
    CameraServer.startAutomaticCapture();
    
    navx.reset();
    encoder.reset();
    
  }


  public static double getPitch() {
    return navx.getPitch();
  }
  
  
  /**
   * This function is called every robot packet, no matter the mode. Use this for items like
   * diagnostics that you want ran during disabled, autonomous, teleoperated and test.
   *
   * <p>This runs after the mode specific periodic functions, but before LiveWindow and
   * SmartDashboard integrated updating.
   */
  @Override
  public void robotPeriodic() {
    // Runs the Scheduler.  This is responsible for polling buttons, adding newly-scheduled
    // commands, running already-scheduled commands, removing finished or interrupted commands,
    // and running subsystem periodic() methods.  This must be called from the robot's periodic
    // block in order for anything in the Command-based framework to work.
     
    enval = encoder.get();
    SmartDashboard.putNumber("Encoder Value", encoder.get());
    


    /*cDisW = navx.getQuaternionW();
    cDisX = navx.getQuaternionX();
    cDisY = navx.getQuaternionY();
    cDisZ = navx.getQuaternionZ();
    //cVelX = navx.getVelocityX();
    cVelY = navx.getVelocityY();
    cVelZ = navx.getVelocityZ(); */
    cPitch = navx.getPitch();
    //cDec = navx.getDisplacementX();

    SmartDashboard.putNumber(ANGLE, cPitch);
    /*SmartDashboard.putNumber(DISZ, cDisZ);
    SmartDashboard.putNumber("QY", cDisY);
    SmartDashboard.putNumber("QX", cDisX);
    SmartDashboard.putNumber("QWX", cDisW);
    SmartDashboard.putNumber("dis X", cDec);
    //SmartDashboard.putNumber("VX", cVelX);
    SmartDashboard.putNumber("VY", cVelY);
    SmartDashboard.putNumber("VZ", cVelZ);
    */
    


    CommandScheduler.getInstance().run();
    /**
     * The method GetColor() returns a normalized color value from the sensor and can be
     * useful if outputting the color to an RGB LED or similar. To
     * read the raw color, use GetRawColor().
     * 
     * The color sensor works best when within a few inches from an object in
     * well lit conditions (the built in LED is a big help here!). The farther
     * an object is the more light from the surroundings will bleed into the 
     * measurements and make it difficult to accurately determine its color.
     */
    Color detectedColor = m_colorSensor.getColor();

    /**
     * Run the color match algorithm on our detected color
     */
    String colorString;
    ColorMatchResult match = m_colorMatcher.matchClosestColor(detectedColor);

    if (match.color == kBlueTarget) {
      colorString = "Blue";
    } else if (match.color == kRedTarget) {
      colorString = "Red";
    } else if (match.color == kGreenTarget) {
      colorString = "Green";
    } else if (match.color == kYellowTarget) {
      colorString = "Yellow";
    } else {
      colorString = "Unknown";
    }

    /**
     * Open Smart Dashboard or Shuffleboard to see the color detected by the 
     * sensor.
     */
    SmartDashboard.putNumber("Red", detectedColor.red);
    SmartDashboard.putNumber("Green", detectedColor.green);
    SmartDashboard.putNumber("Blue", detectedColor.blue);
    SmartDashboard.putNumber("Confidence", match.confidence);
    SmartDashboard.putString("Detected Color", colorString);

  }

  /** This function is called once each time the robot enters Disabled mode. */
  @Override
  public void disabledInit() {}

  @Override
  public void disabledPeriodic() {}

  /** This autonomous runs the autonomous command selected by your {@link RobotContainer} class. */
  @Override
  public void autonomousInit() {
    m_autonomousCommand = m_robotContainer.getAutonomousCommand();

    // schedule the autonomous command (example)
     if (m_autonomousCommand != null) {
     m_autonomousCommand.schedule();
     }
  }

  /** This function is called periodically during autonomous. */
  @Override
  public void autonomousPeriodic() {
     // To Run in Auto:
    //aimAssist.auto(true); // to start
    //aimAssist.auto(false); // to stop
  }

  @Override
  public void teleopInit() {
    // This makes sure that the autonomous stops running when
    // teleop starts running. If you want the autonomous to
    // continue until interrupted by another command, remove
    // this line or comment it out.
    
        //if (m_autonomousCommand != null) {
    //  m_autonomousCommand.cancel();
   // }

  }

  /** This function is called periodically during operator control. */
  @Override
  public void teleopPeriodic() {
    
    

  
    
    if(RobotContainer.joystickD.getRawButton(11)){}
    
    
    //}else if (RobotContainer.joystickC.getRawButton(7)){
      //7m_shoot.changeSpeed(-0.6);
    
    //}else if (RobotContainer.joystickC.getRawButton(10)){
     // m_shoot.changeSpeed(-0.7);
    
    //}else if (RobotContainer.joystickC.getRawButton(9)){
      //m_shoot.changeSpeed(-0.8);
    
    //}else if (RobotContainer.joystickC.getRawButton(12)){
      //m_shoot.changeSpeed(-0.9);
    
   // }else if (RobotContainer.joystickC.getRawButton(11)){
     // m_shoot.changeSpeed(-1);
    //}
   
   }

  @Override
  public void testInit() {
    // Cancels all running commands at the start of test mode.
   // CommandScheduler.getInstance().cancelAll();
  }

  /** This function is called periodically during test mode. */
  @Override
  public void testPeriodic() {}

  /** This function is called once when the robot is first started up. */
  //@Override
  //public void simulationInit() {}

  /** This function is called periodically whilst in simulation. */
 // @Override
  //public void simulationPeriodic() {}

}
