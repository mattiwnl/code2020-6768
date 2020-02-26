package frc.robot.subsystems;
import com.ctre.phoenix.motorcontrol.*;
import com.ctre.phoenix.motorcontrol.can.*;
import frc.robot.*;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
public class DriveSubsystem extends SubsystemBase {
// Drive Motors
    public final TalonFX tfxLeftMaster = new TalonFX(Constants.DriveMasterLeft);
    public final TalonFX tfxLeftSlave1 = new TalonFX(Constants.DriveSlaveLeft);
    public final TalonFX tfxRightMaster = new TalonFX(Constants.DriveMasterRight);
    public final TalonFX tfxRightSlave1 = new TalonFX(Constants.DriveSlaveRight);
    public DriveSubsystem() {
    // Follows
        tfxLeftSlave1.follow(tfxLeftMaster);
        tfxRightSlave1.follow(tfxRightMaster);
    // Invert Right
        tfxRightMaster.setInverted(true);
        tfxRightSlave1.setInverted(true);
    // Motor Settings
        tfxLeftMaster.setNeutralMode(NeutralMode.Coast);
        tfxRightMaster.setNeutralMode(NeutralMode.Coast);
        tfxLeftSlave1.setNeutralMode(NeutralMode.Coast);
        tfxRightSlave1.setNeutralMode(NeutralMode.Coast);
        tfxLeftMaster.configNeutralDeadband(.1, 0);
        tfxRightMaster.configNeutralDeadband(.1, 0);
    }
    public void splitArcardeDrive(ControlMode mode, double throttle, double rotation){
        tfxLeftMaster.set(mode, throttle/2 + rotation/2);
        tfxRightMaster.set(mode, throttle/2 - rotation/2);
    }
    public void driveDirection(ControlMode mode, double throttle){
        tfxLeftMaster.set(mode, throttle);
        tfxRightMaster.set(mode, throttle);
    }
}