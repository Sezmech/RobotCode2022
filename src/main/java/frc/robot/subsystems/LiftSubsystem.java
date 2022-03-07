package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class LiftSubsystem extends SubsystemBase {

 public static CANSparkMax M_UpDown = new CANSparkMax(5, CANSparkMaxLowLevel.MotorType.kBrushless);

 public void setTimed(double speed, double duration) {
    M_UpDown.set(speed);

    try {
      Thread.sleep((long)(duration * 1000));
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    M_UpDown.stopMotor();
  }
} 