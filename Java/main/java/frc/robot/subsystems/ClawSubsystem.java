package frc.robot.subsystems;

import static frc.robot.Constants.ClawConstants.CHANNEL_SOLENOID_CLOSE;
import static frc.robot.Constants.ClawConstants.CHANNEL_SOLENOID_OPEN;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ClawSubsystem extends SubsystemBase {
    
    private final DoubleSolenoid solenoid;

    public ClawSubsystem() {
        this.solenoid = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, CHANNEL_SOLENOID_OPEN, CHANNEL_SOLENOID_CLOSE);
    }

    public void open() {
        solenoid.set(Value.kForward);
    }

    public void close() {
        solenoid.set(Value.kReverse);
    }

}
