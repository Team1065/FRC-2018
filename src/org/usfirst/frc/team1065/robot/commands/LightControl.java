package org.usfirst.frc.team1065.robot.commands;

import org.usfirst.frc.team1065.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class LightControl extends Command {

    public LightControl() {
        requires(Robot.m_lights);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.m_lights.setIntakeLED(Robot.m_intake.isCubeDetected());
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
