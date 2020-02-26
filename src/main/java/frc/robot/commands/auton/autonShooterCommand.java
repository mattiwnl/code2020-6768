package frc.robot.commands.auton;
import com.ctre.phoenix.motorcontrol.ControlMode;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.*;
public class autonShooterCommand extends CommandBase {
    public autonShooterCommand() {
    }
    @Override
    public void initialize() {
        RobotContainer.shootSub.cShoot(ControlMode.PercentOutput, Constants.shooterPowAuto);
    }
    @Override
    public void end(boolean interrupted) {
        super.end(interrupted);
        RobotContainer.shootSub.cShoot(ControlMode.PercentOutput, 0);
    }
    @Override
    public boolean isFinished() {
        return false;
    }
}