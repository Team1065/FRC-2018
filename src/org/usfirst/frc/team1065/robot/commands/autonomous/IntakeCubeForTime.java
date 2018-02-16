package org.usfirst.frc.team1065.robot.commands.autonomous;

import org.usfirst.frc.team1065.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *Positive is In
 */
public class IntakeCubeForTime extends Command {
    public IntakeCubeForTime(double timeout) {
        requires(Robot.m_intake);
        this.setTimeout(timeout);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	if(!Robot.m_intake.isCubeDetected()){
    		Robot.m_intake.setIntakeIn(.8);
    	}
    	else
    	{
    		Robot.m_intake.setIntake(0);
    	}
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	return this.isTimedOut() || Robot.m_intake.isCubeDetected();
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.m_intake.setIntake(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
