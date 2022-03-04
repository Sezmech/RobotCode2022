// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class DriveSubsystem extends SubsystemBase {

  //Drive motor obejcts declaration
  static WPI_VictorSPX motorFrontRight = new WPI_VictorSPX(Constants.M_FRONTRIGHT);
  static WPI_VictorSPX motorFrontLeft = new WPI_VictorSPX(Constants.M_FRONTLEFT);
  static WPI_VictorSPX motorBackRight = new WPI_VictorSPX(Constants.M_BACKRIGHT);
  static WPI_VictorSPX motorBackLeft = new WPI_VictorSPX(Constants.M_BACKLEFT);

  //Combine two motors that are on the same side into one object
  static MotorControllerGroup motorGroupRight = new MotorControllerGroup(motorFrontRight, motorBackRight);
  static MotorControllerGroup motorGroupLeft = new MotorControllerGroup(motorFrontLeft, motorBackLeft);

  //Combine the two motor controller groups to make a chasiss object. This is the object for driving.
  static DifferentialDrive chassis = new DifferentialDrive(motorGroupRight, motorGroupLeft);
  

  /** Creates a new ExampleSubsystem. */
  public DriveSubsystem() {
  }

  /* Method that will be called with joystick inputs. 
     > speed needs to be assigned joysticks Z Axis
     > rotation needs to be assigned to joysticks Y Axis
    So while it makes more sense for the speed to be assigned to Y and rotation assigned to Z unfotunately
    the code doesn't work and tries to turn when holding forward on the Y axis. So don't change anything here
  */
  public static void dirve(double speed, double rotation) {
    chassis.arcadeDrive(speed, rotation);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}
