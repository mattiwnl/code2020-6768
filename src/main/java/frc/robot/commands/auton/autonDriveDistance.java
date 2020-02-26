package frc.robot.commands.auton;
import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.*;
public class autonDriveDistance extends CommandBase {
    public final double inchToEncoder = 1140;
    public double totalDistance;
    public autonDriveDistance(double ID) {
        totalDistance = ID * inchToEncoder;
    }
    @Override
    public void initialize() {
        RobotContainer.driveSub.tfxLeftMaster.setSelectedSensorPosition(0);
        
    }
    @Override
    public void execute() {
        int selSenPosLeftDrive = RobotContainer.driveSub.tfxLeftMaster.getSelectedSensorPosition(0);
        if(totalDistance > 0 ){ // forwards
            if(selSenPosLeftDrive <= totalDistance){
                RobotContainer.driveSub.driveDirection(ControlMode.PercentOutput, Constants.drivePowAuto);   
            }
        }else if(totalDistance < 0){ // backwards
            if(selSenPosLeftDrive >= totalDistance){
                RobotContainer.driveSub.driveDirection(ControlMode.PercentOutput, Constants.drivePowAuto * -1);
            }
        }
        SmartDashboard.putNumber("driveEncoder", selSenPosLeftDrive);
    }
    @Override
    public void end(final boolean interrupted) {
        super.end(interrupted);
    }
    @Override
    public boolean isFinished() {
        return false;
    }
}