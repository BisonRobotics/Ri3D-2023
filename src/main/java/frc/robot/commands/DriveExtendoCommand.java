package frc.robot.commands;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ExtendoSubsystem;

public class DriveExtendoCommand extends CommandBase {
    
    private final XboxController operatorController;
    private final ExtendoSubsystem extendoSubsystem;

    public DriveExtendoCommand(XboxController operatorController, ExtendoSubsystem extendoSubsystem) {
        this.operatorController = operatorController;
        this.extendoSubsystem = extendoSubsystem;

        addRequirements(extendoSubsystem);
    }

    @Override
    public void execute() {
        SmartDashboard.putNumber("Stick", operatorController.getRightY());
        extendoSubsystem.drive(operatorController.getRightY() * .8);
    }

}
