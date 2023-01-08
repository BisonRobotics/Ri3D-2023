package frc.robot.subsystems;

import static frc.robot.Constants.ArmConstants.DEVIDE_ID_ARM_LEADER;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ArmSubsystem extends SubsystemBase {
    
    private final CANSparkMax leader;

    public ArmSubsystem() {
        this.leader = new CANSparkMax(DEVIDE_ID_ARM_LEADER, MotorType.kBrushless);

        configureCANSparkMax(leader);
    }

    private void configureCANSparkMax(CANSparkMax controller) {
        controller.restoreFactoryDefaults();
        controller.setIdleMode(IdleMode.kBrake);
    }

    public void drive(double speed) {
        leader.set(speed);
    }

}
