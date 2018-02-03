package org.usfirst.frc.team1065.robot.commands.autonomous;

import org.usfirst.frc.team1065.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *Positive is In
 */
public class SetIntake extends Command {
    double value;
    public SetIntake(double value, double timeout) {
        requires(Robot.m_intake);
        this.value = value;
        this.setTimeout(timeout);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	if(value > 0 && !Robot.m_intake.isCubeDetected()){
    		Robot.m_intake.setIntakeIn(value);
    	}
    	else if (value < 0){
    		Robot.m_intake.setIntakeOut(value);
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
    	return this.isTimedOut();
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
