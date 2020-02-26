package frc.robot.commands;
import com.ctre.phoenix.motorcontrol.ControlMode;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.*;
public class StorageCommand extends CommandBase {
    public StorageCommand() {
    }
    @Override
    public void initialize() {
        RobotContainer.storageSub.cStorage(ControlMode.PercentOutput, -Constants.storagePow);
    }
    @Override
    public void execute() {
    }
    @Override
    public void end(final boolean interrupted) {
        super.end(interrupted);
        RobotContainer.storageSub.cStorage(ControlMode.PercentOutput, 0);
    }
    @Override
    public boolean isFinished() {
        return false;
    }
}