package frc.robot;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.kauailabs.navx.frc.AHRS;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.networktables.*;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;

public class Robot extends TimedRobot {
//Global Variables
// Defines the Auto Command
    private Command m_autonomousCommand;
// Initiate Robot Container
    private RobotContainer m_robotContainer;
//NavX Accelerometer
    public static AHRS gyro = new AHRS(SPI.Port.kMXP);
// Limelight Network Table Global Variables
    public NetworkTableEntry tx;
    public NetworkTableEntry ty;
    public NetworkTableEntry ta;
    public static double x;
    public static double y;
    public static double area;
// Turret Values and Constants
    public static double steeringAdjust = 0.0;
    public final double Kp = -.05;
// Turret Encoder Limits
    public final double posLimTurret = 0 + (6144);
    public final double negLimTurret = 0 - (6144);
// Sensors
    public final static DigitalInput breakBeam = new DigitalInput(0);
// Xbox
    public final XboxController xbox = new XboxController(0);

    @Override
    public void robotInit() {
    // Instantiate our RobotContainer. This will perform all our button bindings.
        m_robotContainer = new RobotContainer();
    // Initiate the limelight network table
        NetworkTable table = NetworkTableInstance.getDefault().getTable("limelight");
        tx = table.getEntry("tx");
        ty = table.getEntry("ty");
        ta = table.getEntry("ta");
        RobotContainer.turretSub.tsrxTurret.setSelectedSensorPosition(0);
    }
    @Override
    public void robotPeriodic() {
        CommandScheduler.getInstance().run();
    // Limelight  Data w/ SmartDashboard
        x = tx.getDouble(0.0);
        y = ty.getDouble(0.0);
        area = ta.getDouble(0.0);
        SmartDashboard.putNumber("Limelight X", x);
        SmartDashboard.putNumber("Limelight Y", y);
        SmartDashboard.putNumber("Limelight Area", area);
        NetworkTableInstance.getDefault().getTable("limelight").getEntry("ledMode").setNumber(3); // LED On
        NetworkTableInstance.getDefault().getTable("limelight").getEntry("camMode").setNumber(0); // Vision Processing
    // Turret Adjustment
        int selSenPosTurret = RobotContainer.turretSub.tsrxTurret.getSelectedSensorPosition(0);
        
        double headingError = -x;
        if (Robot.x > 1 && selSenPosTurret <= posLimTurret){
             steeringAdjust = Kp*headingError;
        }else if(Robot.x < 1 && selSenPosTurret >= negLimTurret){
             steeringAdjust = Kp*headingError;
        }else{
            steeringAdjust = 0;
        }
        SmartDashboard.putNumber("Turret Encoder", selSenPosTurret);
        SmartDashboard.putNumber("Steering Adjust", steeringAdjust);
    }
    @Override
    public void autonomousInit() {
        m_autonomousCommand = m_robotContainer.getAutonomousCommand();
        // schedule the autonomous command (example)
        if (m_autonomousCommand != null) {
            m_autonomousCommand.schedule();
        }
    }
    @Override
    public void autonomousPeriodic() {
    }
    @Override
    public void teleopInit() {
        if (m_autonomousCommand != null) {
            m_autonomousCommand.cancel();
        }
    }
    @Override
    public void teleopPeriodic() {
        if(xbox.getRawButton(1)){
            RobotContainer.storageSub.cStorage(ControlMode.PercentOutput, 1);
        }
    }
}
