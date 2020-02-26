package frc.robot.commands;
import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
public class intakeAndStore extends ParallelCommandGroup {
    public intakeAndStore() {
        addCommands(
                new IntakeCommand(),
                new StorageCommandDIO()
        );
    }
}