package frc.robot;

public enum ArmPosition {
    
    PICKUP(0, false),
    DRIVE(0, false),
    LOW(0, false),
    MID(0, false),
    HIGH(0, true);

    private final int armPosition;
    private final boolean extendo;

    private ArmPosition(int armPosition, boolean extendo) {
        this.armPosition = armPosition;
        this.extendo = extendo;
    }

    public int armPosition() {
        return armPosition;
    }

    public boolean extendo() {
        return extendo;
    }

}
