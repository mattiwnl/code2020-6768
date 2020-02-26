package frc.robot.commands;
import com.ctre.phoenix.motorcontrol.ControlMode;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.*;
public class StorageCommandDIO extends CommandBase {
    public StorageCommandDIO() {
    }
    @Override
    public void initialize() {
    }
    @Override
    public void execute() {
        if(Robot.breakBeam.get() == false){
            RobotContainer.storageSub.cStorage(ControlMode.PercentOutput, -Constants.storagePow);
        }else if(Robot.breakBeam.get() == true){
            RobotContainer.storageSub.cStorage(ControlMode.PercentOutput, 0);
        }
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