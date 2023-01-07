package frc.robot.subsystems;

import static frc.robot.Constants.DrivetrainConstants.DEVIDE_ID_LEFT_LEADER;
import static frc.robot.Constants.DrivetrainConstants.DEVIDE_ID_LEFT_FOLLOWER;
import static frc.robot.Constants.DrivetrainConstants.DEVIDE_ID_RIGHT_LEADER;
import static frc.robot.Constants.DrivetrainConstants.SLEW_RATE;
import static frc.robot.Constants.DrivetrainConstants.DEVIDE_ID_RIGHT_FOLLOWER;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.math.filter.SlewRateLimiter;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DrivetrainSubsystem extends SubsystemBase {
    
    private final DifferentialDrive diffDrive;
    private final SlewRateLimiter rateLimiter = new SlewRateLimiter(SLEW_RATE);

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

        this.diffDrive = new DifferentialDrive(leftLeader, rightLeader);
    }

    private void configureCANSparkMax(CANSparkMax controller) {
        controller.restoreFactoryDefaults();
        controller.setIdleMode(IdleMode.kBrake);
    }

    public void tankDrive(double leftSpeed, double rightSpeed, boolean squareInputs) {
        diffDrive.tankDrive(rateLimiter.calculate(leftSpeed), rateLimiter.calculate(rightSpeed), squareInputs);
    }

    public void arcadeDrive(double speed, double turnSpeed, boolean squareInputs) {
        diffDrive.arcadeDrive(rateLimiter.calculate(speed), rateLimiter.calculate(turnSpeed), squareInputs);
    }

}
