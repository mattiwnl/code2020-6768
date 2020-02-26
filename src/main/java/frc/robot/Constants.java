package frc.robot;
public final class Constants {
// Drive Constants
    // Motor IDs
    public static final int DriveMasterLeft = 1; // TalonFX
    public static final int DriveSlaveLeft = 2; // TalonFX
    public static final int DriveMasterRight = 3; // TalonFX
    public static final int DriveSlaveRight = 4; // TalonFX
    // Power
    public static final double drivePowAuto = .55;
// Intake Constants
    // Motor IDs
    public static final int Intake = 3; // VictorSPX
    public static final int VertIntake = 4; // VictorSPX
    // Power
    public static final double intakePow = 0.5; // Editable - Don't go above .75
    public static final double vertintakePow = 0.55; // Editable - Don't go above .75
// Storage Constants
    // Motor IDs
    public static final int Storage = 2; // VictorSPX
    // Power
    public static final int storagePow = 1;
// Turret Constants
    // Motor IDs
    public static final int Turret = 7; // TalonSRX
// Shooter Constants
    // Motor IDs
    public static final int Shooter = 5; // TalonFX
    public static final int Shooter2 = 6; // TalonFX
    // Power
    public static final double shooterPowAuto = -.85;
    public static final double shooterPowTeleop = -1;
//Elevator Constants
    // Motor IDs
    public static final int Elevator = 1; // VictorSPX
    //Power
    public static final int elevatorPowUp = 1;
    public static final int elevatorPowDown = -1;
    //Limit Switches
    public static final int upLimit = 0;
    public static final int downLimit = 1; 
} 