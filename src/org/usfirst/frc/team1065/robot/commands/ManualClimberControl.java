package org.usfirst.frc.team1065.robot.commands;

import org.usfirst.frc.team1065.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ManualClimberControl extends Command {

    public ManualClimberControl() {
        requires(Robot.m_climber);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if(Robot.m_oi.getClimberUpSwitch()){
    		Robot.m_climber.goUp();
    	}
    	else if(Robot.m_oi.getClimberDownSwitch()){
    		Robot.m_climber.stop();
    	}
    	else{
    		Robot.m_climber.stop();
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
