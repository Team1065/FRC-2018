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
    	if(Robot.m_oi.getIntakeInSwitch() && !Robot.m_intake.isCubeDetected()){
    		Robot.m_intake.setIntakeIn(.8);
    	}
    	else if(Robot.m_oi.getIntakeOutSwitch()){
    		
    		Robot.m_intake.setIntakeOut(Robot.m_oi.getShootingFast() ? 0.8 : 0.4);
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
