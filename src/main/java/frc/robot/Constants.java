package frc.robot;

public class Constants {
    
    public static class DrivetrainConstants {
        public static final int DEVIDE_ID_LEFT_LEADER = 0;
        public static final int DEVIDE_ID_LEFT_FOLLOWER = 1;
        public static final int DEVIDE_ID_RIGHT_LEADER = 2;
        public static final int DEVIDE_ID_RIGHT_FOLLOWER = 3;

        public static final double SLEW_RATE = 0.2;
    }

    public static class ArmConstants {
        public static final int DEVIDE_ID_ARM_LEADER = 4;
        public static final int DEVIDE_ID_ARM_FOLLOWER = 5;
    }

    public static class ClawConstants {
        public static final int CHANNEL_SOLENOID_OPEN = 0;
        public static final int CHANNEL_SOLENOID_CLOSE = 1;
    }

    public static class ControllerConstants {
        public static final int DEVICE_ID_DRIVER_CONTROLLER = 0;
        public static final int DEVICE_ID_OPERATOR_CONTROLLER = 1;
    }

}
