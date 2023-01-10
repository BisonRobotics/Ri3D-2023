package frc.robot.subsystems;

import static frc.robot.Constants.DrivetrainConstants.DEVIDE_ID_LEFT_LEADER;
import static frc.robot.Constants.DrivetrainConstants.DEVIDE_ID_LEFT_FOLLOWER;
import static frc.robot.Constants.DrivetrainConstants.DEVIDE_ID_RIGHT_LEADER;
import static frc.robot.Constants.DrivetrainConstants.RAMP_RATE;
import static frc.robot.Constants.DrivetrainConstants.DEVIDE_ID_RIGHT_FOLLOWER;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.cscore.UsbCamera;
import edu.wpi.first.math.filter.SlewRateLimiter;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DrivetrainSubsystem extends SubsystemBase {
    
    private final DifferentialDrive diffDrive;
    private final UsbCamera camera;
    private boolean slowMode = false;

    public DrivetrainSubsystem() {
        CANSparkMax leftLeader = new CANSparkMax(DEVIDE_ID_LEFT_LEADER, MotorType.kBrushless);
        CANSparkMax leftFollower = new CANSparkMax(DEVIDE_ID_LEFT_FOLLOWER, MotorType.kBrushless);
        CANSparkMax rightLeader = new CANSparkMax(DEVIDE_ID_RIGHT_LEADER, MotorType.kBrushless);
        CANSparkMax rightFollower = new CANSparkMax(DEVIDE_ID_RIGHT_FOLLOWER, MotorType.kBrushless);

        configureCANSparkMax(leftLeader);
        configureCANSparkMax(leftFollower);
        configureCANSparkMax(rightLeader);
        configureCANSparkMax(rightFollower);

        leftFollower.follow(leftLeader);
        rightFollower.follow(rightLeader);
        leftLeader.setInverted(true);

        this.diffDrive = new DifferentialDrive(leftLeader, rightLeader);

        this.camera =  CameraServer.startAutomaticCapture();
    }

    private void configureCANSparkMax(CANSparkMax controller) {
        controller.restoreFactoryDefaults();
        controller.setIdleMode(IdleMode.kBrake);
        controller.setOpenLoopRampRate(RAMP_RATE);
        controller.setClosedLoopRampRate(RAMP_RATE);
    }

    public void tankDrive(double leftSpeed, double rightSpeed, boolean squareInputs) {
        if (slowMode) {
            leftSpeed *= .5;
            rightSpeed *= .5;
        }
        diffDrive.tankDrive(leftSpeed, rightSpeed, squareInputs);
    }

    public void arcadeDrive(double speed, double turnSpeed, boolean squareInputs) {
        turnSpeed *= .8;
        if (slowMode) {
            speed *= .5;
            turnSpeed *= .5;
        }
        diffDrive.arcadeDrive(speed, turnSpeed, squareInputs);
    }

    public boolean isSlowMode() {
        return slowMode;
    }

    public void toggleSlowMode() {
        slowMode = !slowMode;
    }

}
