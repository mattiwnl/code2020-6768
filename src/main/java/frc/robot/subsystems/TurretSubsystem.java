package frc.robot.subsystems;
import com.ctre.phoenix.motorcontrol.*;
import com.ctre.phoenix.motorcontrol.can.*;
import frc.robot.*;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
public class TurretSubsystem extends SubsystemBase {
    public final TalonSRX tsrxTurret = new TalonSRX(Constants.Turret);
    public TurretSubsystem() {
    // Neutral Mode
        tsrxTurret.setNeutralMode(NeutralMode.Brake);
    }
    public void cTurret(ControlMode mode, double pow) {
    // Turret
        tsrxTurret.set(mode, pow);
    }
}