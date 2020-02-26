package frc.robot;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.subsystems.*;
import frc.robot.commands.*;
import frc.robot.commands.auton.*;
public class RobotContainer {
// The robot's subsystems and commands are defined here
	public final static XboxController xbox = new XboxController(0);
	public final static DriveSubsystem driveSub = new DriveSubsystem();
	public final static IntakeSubsystem	intakeSub = new IntakeSubsystem();
	public final static StorageSubsystem storageSub = new StorageSubsystem();
	public final static TurretSubsystem turretSub = new TurretSubsystem();
	public final static ShooterSubsystem shootSub = new ShooterSubsystem();
	public final static ElevatorSubsystem elevatorSub = new ElevatorSubsystem();
	private final static Command auto = new Autonomous();
// A chooser for autonomous commands
  	SendableChooser<Command> m_chooser = new SendableChooser<>();
  	public RobotContainer() {
	// Initialize Command Buttons
		configXboxButtonBindings();
	// Initialize Drive Code
		driveSub.setDefaultCommand(new DriveCommand(driveSub, () -> xbox.getY(Hand.kLeft), () -> xbox.getX(Hand.kRight)));
		m_chooser.setDefaultOption("Wall Auto", auto);
    // Put the chooser on the dashboard
		Shuffleboard.getTab("Autonomous").add(m_chooser);
	}
  	private void configXboxButtonBindings() {
		new JoystickButton(xbox, 5).toggleWhenPressed(new intakeAndStore()); // Left Bumper
		new JoystickButton(xbox, 6).toggleWhenPressed(new fire()); // Right Bumper
		new JoystickButton(xbox, 7).whileHeld(new ElevatorCommandUp(elevatorSub)); // Start
		new JoystickButton(xbox, 8).whileHeld(new ElevatorCommandDown(elevatorSub)); // Select
	}
	public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    	return m_chooser.getSelected();
  	}
}
