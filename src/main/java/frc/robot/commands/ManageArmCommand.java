package frc.robot.commands;

import java.util.function.Supplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.ArmPosition;
import frc.robot.subsystems.ArmSubsystem;
import frc.robot.subsystems.ExtendoSubsystem;

public class ManageArmCommand extends CommandBase {
    
    private final ArmSubsystem armSubsystem;
    private final ExtendoSubsystem extendoSubsystem;
    private final Supplier<ArmPosition> armPositionSupplier;

    public ManageArmCommand(ArmSubsystem armSubsystem, ExtendoSubsystem extendoSubsystem, Supplier<ArmPosition> armPositionSupplier) {
        this.armSubsystem = armSubsystem;
        this.extendoSubsystem = extendoSubsystem;
        this.armPositionSupplier = armPositionSupplier;

        addRequirements(armSubsystem, extendoSubsystem);
    }

    @Override
    public void execute() {
        ArmPosition currentPosition = armPositionSupplier.get();

        extendo(currentPosition);
        arm(currentPosition);
    }

    private void extendo(ArmPosition currentPosition) {
        if (currentPosition.extendo()) {
            extendoSubsystem.extend();
        } else {
            extendoSubsystem.retract();
        }
    }

    private void arm(ArmPosition currentPosition) {
        int target = currentPosition.armPosition();

        // TODO write this part
    }

}
