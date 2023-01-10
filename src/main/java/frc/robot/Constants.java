package frc.robot;

import edu.wpi.first.wpilibj.XboxController;

public class Constants {
    
    public static class DrivetrainConstants {
        public static final int DEVIDE_ID_LEFT_LEADER = 1;
        public static final int DEVIDE_ID_LEFT_FOLLOWER = 2;
        public static final int DEVIDE_ID_RIGHT_LEADER = 3;
        public static final int DEVIDE_ID_RIGHT_FOLLOWER = 4;

        public static final double RAMP_RATE = .5;
    }

    public static class ArmConstants {
        public static final int DEVIDE_ID_ARM = 5;
    }

    public static class ExtendoConstants {
        public static final int DEVICE_ID_EXTENDO = 6;
    
        public static final double RAMP_RATE = 0.02;
        public static final double EXTENSION_SPEED = 0.5;
        public static final double RETRACTION_RATE = 0.5;
    }

    public static class ClawConstants {
        public static final int CHANNEL_SOLENOID_OPEN = 0;
        public static final int CHANNEL_SOLENOID_CLOSE = 1;
    }

    public static class ControllerConstants {
        public static final int DEVICE_ID_DRIVER_CONTROLLER = 0;
        public static final int DEVICE_ID_OPERATOR_CONTROLLER = 1;

        public static final int BUTTON_OPEN_CLAW = XboxController.Button.kRightBumper.value;
        public static final int BUTTON_CLOSE_CLAW = XboxController.Button.kLeftBumper.value;

        public static final int BUTTON_ARM_PICKUP = XboxController.Button.kX.value;
        public static final int BUTTON_ARM_DRIVE = XboxController.Button.kY.value;
        public static final int BUTTON_ARM_LOW = XboxController.Button.kLeftBumper.value;
        public static final int BUTTON_ARM_MID = XboxController.Button.kRightBumper.value;
        public static final int BUTTON_ARM_HIGH = XboxController.Button.kStart.value;
    }

}
