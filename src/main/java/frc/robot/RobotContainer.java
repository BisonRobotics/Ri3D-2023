// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import static frc.robot.Constants.ControllerConstants.DEVICE_ID_DRIVER_CONTROLLER;
import static frc.robot.Constants.ControllerConstants.DEVICE_ID_OPERATOR_CONTROLLER;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import frc.robot.commands.DriveCommand;
import frc.robot.subsystems.ArmSubsystem;
import frc.robot.subsystems.DrivetrainSubsystem;

public class RobotContainer {

  private final XboxController driverController = new XboxController(DEVICE_ID_DRIVER_CONTROLLER);
  private final XboxController operatorController = new XboxController(DEVICE_ID_OPERATOR_CONTROLLER);
  private final DrivetrainSubsystem drivetrainSubsystem = new DrivetrainSubsystem();
  private final ArmSubsystem armSubsystem = new ArmSubsystem();

  public RobotContainer() {
    drivetrainSubsystem.setDefaultCommand(new DriveCommand(drivetrainSubsystem, driverController));
    configureBindings();
  }

  private void configureBindings() {}

  public Command getAutonomousCommand() {
    return Commands.print("No autonomous command configured");
  }

}
