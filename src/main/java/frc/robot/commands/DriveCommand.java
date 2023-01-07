package frc.robot.commands;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DrivetrainSubsystem;

public class DriveCommand extends CommandBase {
    
    private final DrivetrainSubsystem drivetrainSubsystem;
    private final XboxController driverController;

    public DriveCommand(DrivetrainSubsystem drivetrainSubsystem, XboxController driverController) {
        this.drivetrainSubsystem = drivetrainSubsystem;
        this.driverController = driverController;

        addRequirements(drivetrainSubsystem);
    }

    @Override
    public void execute() {
        // TODO does stuff need to be inverted?
        drivetrainSubsystem.arcadeDrive(driverController.getLeftY(), driverController.getRightX(), true);
    }

}
