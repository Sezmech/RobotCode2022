package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class LiftSubsystem extends SubsystemBase {

  private static DigitalInput liftUpperSwitch;
  private static DigitalInput liftLowerSwitch;

  private static CANSparkMax liftMotor;

  public LiftSubsystem() {
    liftUpperSwitch = new DigitalInput(0);
    liftLowerSwitch = new DigitalInput(1);
    liftMotor = new CANSparkMax(Constants.M_LIFT, CANSparkMaxLowLevel.MotorType.kBrushless);
  }
  
 public void moveUp() {
   if(!liftUpperSwitch.get()) {
    liftMotor.set(0.5);
   }
   else {
     liftMotor.stopMotor();
   }
 }
} 