package frc.robot.commands;

import com.ctre.phoenix.motorcontrol.ControlMode;

// import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.*;
import frc.robot.subsystems.ElevatorSubsystem;
public class ElevatorCommandUp extends CommandBase {
    // DigitalInput limit = new DigitalInput(Constants.upLimit);
    public ElevatorCommandUp(final ElevatorSubsystem ElevatorSub) {
    }
    @Override
    public void initialize() {
        RobotContainer.elevatorSub.cElevator(ControlMode.PercentOutput, Constants.elevatorPowUp);
    }
    @Override
    public void execute() {
        // if(limit.get() == true){
        //     RobotContainer.elevatorSub.cElevator(ControlMode.PercentOutput, 0);
        // }
    }
    @Override
    public void end(final boolean interrupted) {
        super.end(interrupted);
        RobotContainer.elevatorSub.cElevator(ControlMode.PercentOutput, 0);
    }
    @Override
    public boolean isFinished() {
        return false;
    }
}