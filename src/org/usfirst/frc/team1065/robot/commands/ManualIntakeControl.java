package org.usfirst.frc.team1065.robot.commands;

import org.usfirst.frc.team1065.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ManualIntakeControl extends Command {

    public ManualIntakeControl() {
        requires(Robot.m_intake);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if(Robot.m_oi.getRightJoystickTop() && Robot.m_oi.getRightJoystickTrigger()){
    		double shootingSpeed = 0.6;
    		if(Robot.m_oi.getShootingFast()){
    			shootingSpeed = 0.9;
    		}
    		else if(Robot.m_oi.getShootingSlow()){
    			shootingSpeed = 0.3;
    		}
    		Robot.m_intake.setIntakeOut(shootingSpeed);
    	}
    	else if(Robot.m_oi.getIntakeOffSwitch() && !Robot.m_intake.isCubeDetected()){
    		Robot.m_intake.setIntakeIn(.8);
    	}
    	else{
    		Robot.m_intake.setIntake(0);
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
