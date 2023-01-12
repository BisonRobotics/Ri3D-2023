package frc.robot.commands;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ArmSubsystem;

public class DriveArmCommand extends CommandBase {
    
    private final XboxController operatorController;
    private final ArmSubsystem armSubsystem;

    public DriveArmCommand(XboxController operatorController, ArmSubsystem armSubsystem) {
        this.armSubsystem = armSubsystem;
        this.operatorController = operatorController;

        addRequirements(armSubsystem);
    }

    @Override
    public void execute() {
        double speed = -operatorController.getLeftY() * .5;
        if (speed < 0) {
            speed *= -speed;
        } else {
            speed *= speed;
        }
        armSubsystem.drive(speed);
    }

}
