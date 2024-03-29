// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
    ///Motor CAN IDs
        //Joystick Ports
        public static final int JOYSTICK_D = 0; //Driver Joystick
        public static final int JOYSTICK_C = 1; //Controller Joystick

        //Drive Motor IDs
        public static final int M_FRONTRIGHT = 1;
        public static final int M_FRONTLEFT = 2;
        public static final int M_BACKRIGHT = 3;
        public static final int M_BACKLEFT = 4;
  
        //SparkMax ID
        public static final int M_LIFT = 5;
    
    ///Sensor Ports
        //Limit Switches
        public static final int S_UPPER_LIFT = 0;
        public static final int S_LOWER_LIFT = 2;

    
}
