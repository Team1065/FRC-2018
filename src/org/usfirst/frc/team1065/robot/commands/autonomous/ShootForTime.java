package org.usfirst.frc.team1065.robot.commands.autonomous;

import org.usfirst.frc.team1065.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ShootForTime extends Command {
	double m_speed;
    public ShootForTime(double timeout) {
        requires(Robot.m_intake);
        this.setTimeout(timeout);
        m_speed = .4;
    }
    
    public ShootForTime(double speed, double timeout) {
        requires(Robot.m_intake);
        this.setTimeout(timeout);
        m_speed = speed;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.m_intake.setIntakeOut(m_speed);
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
