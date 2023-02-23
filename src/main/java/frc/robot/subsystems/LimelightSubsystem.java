// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

//import com.revrobotics.CANSparkMax;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;


public class LimelightSubsystem extends SubsystemBase {
  //private static CANSparkMax hookMotor;

 // double first_motor_speed = -0.1;
  //double first_area = 10;
  //double motor_speed;
  double x;
  double y;
  double l;
  double v;
  double area;
  double slope;
  double targetHeight;
  double limelightHeight = 113;
  double limelightAngle = 90;
  // how many degrees back is your limelight rotated from perfectly vertical?
  //double limelightMountAngleDegrees = 20.0;
  double t_speed;
  // distance from the center of the Limelight lens to the floor
  //double limelightLensHeightCM = 95.0;
  // distance from the target to the floor
 // double goalHeightCM = 100.0;



  NetworkTable table = NetworkTableInstance.getDefault().getTable("limelight");

  NetworkTableEntry tx;
  NetworkTableEntry ty;
  NetworkTableEntry tl;
  NetworkTableEntry ta;
  NetworkTableEntry tv;
  NetworkTableEntry tspeed;
  
  
  
  



  /** Creates a new LimelightSubsystem. */
  public LimelightSubsystem() {
    

  }
 // public void hookMove(double speed) {
  //  hookMotor.set(speed);
   // SmartDashboard.putNumber("motor speed", speed);
 // }
  double currentDist;

  @Override
  public void periodic() {
   
    x = table.getEntry("tx").getDouble(0.0);
    y = table.getEntry("ty").getDouble(0.0);
    l = table.getEntry("tl").getDouble(0.0);
    area = table.getEntry("ta").getDouble(0.0);
    v = table.getEntry("tv").getDouble(0.0);
    //motor_speed = table.getEntry("tspeed").getDouble(0.0);
    double ll_radian = Math.toRadians(limelightAngle);
    double a2 = y;
    double currentDist = (Math.abs(targetHeight - limelightHeight) / Math.tan(ll_radian + a2));
    

    SmartDashboard.putNumber("Limelight_VALID", v);
    SmartDashboard.putNumber("Limelight_X", x);
    SmartDashboard.putNumber("Limelight_Y", y);
    SmartDashboard.putNumber("Limelight_L", l);
    SmartDashboard.putNumber("Limelight_Area", area);
    SmartDashboard.putNumber("Slope", slope);
    SmartDashboard.putNumber("distance", currentDist);
    /**
   * getDist() - calculates approximate distance from a fixed angled limelight to
   * the target.
   * 
   * @param targetHeight = target height in meters
   * @param limelightHeight = height of limelight from the ground in meters, 
   * @param limelightAngle = angle in degrees of the limelight on the robot.
   * @param debug = Enable printing current distance to console
   * @return approx distance in meters
   */
  
  }



    

  
  
  
}
