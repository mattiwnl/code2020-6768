package frc.robot.commands.auton;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.*;
import frc.robot.commands.*;
public class autonFire extends SequentialCommandGroup {
    public autonFire() {
        addCommands(
                parallel(
                    new TurretCommand(RobotContainer.turretSub, () -> Robot.steeringAdjust),
                    new autonShooterCommand()),
                new WaitCommand(1),
                new StorageCommand());
    }
}