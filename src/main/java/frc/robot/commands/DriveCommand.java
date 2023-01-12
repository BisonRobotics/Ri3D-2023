package frc.robot.commands;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DrivetrainSubsystem;

public class DriveCommand extends CommandBase {
    private final double SPEED_FACTOR = 0.75;
    private final DrivetrainSubsystem drivetrainSubsystem;
    private final XboxController driverController;

    public DriveCommand(DrivetrainSubsystem drivetrainSubsystem, XboxController driverController) {
        this.drivetrainSubsystem = drivetrainSubsystem;
        this.driverController = driverController;

        addRequirements(drivetrainSubsystem);
    }

    @Override
    public void execute() {
        SmartDashboard.putBoolean("Slow Mode", drivetrainSubsystem.isSlowMode());
        if (driverController.getLeftBumperPressed() || driverController.getRightBumperPressed()) {
            drivetrainSubsystem.toggleSlowMode();
        }
        drivetrainSubsystem.arcadeDrive(driverController.getLeftY()*SPEED_FACTOR, driverController.getRightX()*SPEED_FACTOR, true);
    }

}
