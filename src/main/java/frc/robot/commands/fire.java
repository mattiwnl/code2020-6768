package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.*;
public class fire extends SequentialCommandGroup {
    public fire() {
        addCommands(
            new SequentialCommandGroup(
                new ParallelCommandGroup(
                new TurretCommand(RobotContainer.turretSub, () -> Robot.steeringAdjust),
                new ShooterCommand()
            ),
            new wait(),
            new StorageCommand())


            
        );
    }
}