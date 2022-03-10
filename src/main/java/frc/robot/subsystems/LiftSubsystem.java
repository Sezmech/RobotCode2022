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
    liftUpperSwitch = new DigitalInput(Constants.S_UPPER_LIFT);
    liftLowerSwitch = new DigitalInput(Constants.S_LOWER_LIFT);
    liftMotor = new CANSparkMax(Constants.M_LIFT, CANSparkMaxLowLevel.MotorType.kBrushless);
  }
  
  public static void move(double speed) {
      liftMotor.set(speed);
  }

  public boolean upperSwitchState() {
    return !liftUpperSwitch.get();
  }

  public boolean lowerSwitchState() {
    return !liftLowerSwitch.get();
  }

} 