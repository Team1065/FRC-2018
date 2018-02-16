package org.usfirst.frc.team1065.robot.commands.autonomous;

import org.usfirst.frc.team1065.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class SetArmToPosition extends Command {
	double m_position;
    public SetArmToPosition(double position, double timeout) {
        requires(Robot.m_arm);
        m_position = position;
        this.setTimeout(timeout);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if(Robot.m_oi.getArmOverride()){
    		Robot.m_arm.retractSolenoid(true);
        	Robot.m_arm.setVoltage(0);
    	}
    	else{
    		Robot.m_arm.setPosition(m_position);
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return this.isTimedOut();
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
