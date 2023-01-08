package frc.robot.subsystems;

import static frc.robot.Constants.ExtendoConstants.DEVICE_ID_EXTENDO;
import static frc.robot.Constants.ExtendoConstants.EXTENSION_SPEED;
import static frc.robot.Constants.ExtendoConstants.RAMP_RATE;
import static frc.robot.Constants.ExtendoConstants.RETRACTION_RATE;

import com.ctre.phoenix.motorcontrol.can.TalonSRXConfiguration;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ExtendoSubsystem extends SubsystemBase {
    
    private final WPI_TalonSRX motor = new WPI_TalonSRX(DEVICE_ID_EXTENDO);

    public ExtendoSubsystem() {
        TalonSRXConfiguration talonConfig = new TalonSRXConfiguration();
        talonConfig.openloopRamp = RAMP_RATE;   
    }

    public void extend() {
        motor.set(EXTENSION_SPEED);
    }

    public void retract() {
        motor.set(RETRACTION_RATE);
    }

}
