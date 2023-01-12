// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import static frc.robot.Constants.ControllerConstants.BUTTON_CLOSE_CLAW;
import static frc.robot.Constants.ControllerConstants.BUTTON_OPEN_CLAW;
import static frc.robot.Constants.ControllerConstants.DEVICE_ID_DRIVER_CONTROLLER;
import static frc.robot.Constants.ControllerConstants.DEVICE_ID_OPERATOR_CONTROLLER;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.DriveArmCommand;
import frc.robot.commands.DriveCommand;
import frc.robot.commands.DriveExtendoCommand;
import frc.robot.subsystems.ArmSubsystem;
import frc.robot.subsystems.ClawSubsystem;
import frc.robot.subsystems.DrivetrainSubsystem;
import frc.robot.subsystems.ExtendoSubsystem;

public class RobotContainer {

  private final XboxController driverController = new XboxController(DEVICE_ID_DRIVER_CONTROLLER);
  private final XboxController operatorController = new XboxController(DEVICE_ID_OPERATOR_CONTROLLER);
  private final DrivetrainSubsystem drivetrainSubsystem = new DrivetrainSubsystem();
  private final ArmSubsystem armSubsystem = new ArmSubsystem();
  private final ExtendoSubsystem extendoSubsystem = new ExtendoSubsystem();
  private final ClawSubsystem clawSubsystem = new ClawSubsystem();

  public RobotContainer() {
    drivetrainSubsystem.setDefaultCommand(new DriveCommand(drivetrainSubsystem, driverController));
    armSubsystem.setDefaultCommand(new DriveArmCommand(operatorController, armSubsystem));
    extendoSubsystem.setDefaultCommand(new DriveExtendoCommand(operatorController, extendoSubsystem));

    configureBindings();
  }

  private void configureBindings() {
    // Claw buttons
    new JoystickButton(operatorController, BUTTON_OPEN_CLAW)
        .onTrue(new RunCommand(clawSubsystem::open, clawSubsystem));

    new JoystickButton(operatorController, BUTTON_CLOSE_CLAW)
        .onTrue(new RunCommand(clawSubsystem::close, clawSubsystem));
  }

  public Command getAutonomousCommand() {
    return Commands.print("No autonomous command configured");
  }

}
