package org.usfirst.frc.team1065.robot.commands;

import org.usfirst.frc.team1065.robot.Robot;
import org.usfirst.frc.team1065.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ManualArmControl extends Command {

    public ManualArmControl() {
        requires(Robot.m_arm);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if(Robot.m_oi.getArmOverride()){
    		Robot.m_arm.retractSolenoid(Robot.m_oi.getArmExtendedOverride());
    		
    		double ArmStickY = Robot.m_oi.getArmStickY();
        	
        	if(Math.abs(ArmStickY - RobotMap.ARM_JOYSTICK_MIDDLE) > RobotMap.ARM_JOYSTICK_DEADBAND){
        		Robot.m_arm.setVoltage((ArmStickY - RobotMap.ARM_JOYSTICK_MIDDLE)/RobotMap.ARM_JOYSTICK_MIDDLE);
        	}
        	else {
        		Robot.m_arm.setVoltage(0);
        	}
    	}
    	else{
    		Robot.m_arm.setPosition(Robot.m_oi.getArmDesiredPosition());
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
