package org.usfirst.frc.team1065.robot.commands.autonomous;

import org.usfirst.frc.team1065.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveToDistance extends Command {
	double targetSpeed, targetDistance;
	int atDestinationCounter;
	//set speed negative to go backwards
    public DriveToDistance(double speed, double distance, double time) {
    	requires(Robot.m_driveTrain);
    	targetSpeed = speed;
        targetDistance = Math.abs(distance);
        this.setTimeout(time);
    }

    
    protected void initialize() {
    	Robot.m_driveTrain.resetEncoder();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	double motorSpeed = targetSpeed;
    	//Slow  down near the target
    	if(Math.abs(Robot.m_driveTrain.getEncoderDistance()) > targetDistance-5){ //slow down in last 5 inches
    		motorSpeed = motorSpeed * 0.25;
    	}
    	else if(Math.abs(Robot.m_driveTrain.getEncoderDistance()) > targetDistance-10){ //slow down in last 10 inches
    		motorSpeed = motorSpeed * 0.4;
    	}
    	else if(Math.abs(Robot.m_driveTrain.getEncoderDistance()) > targetDistance-20){ //slow down in last 20 inches
    		motorSpeed = motorSpeed * 0.5;
    	}
    	
    	//minimum speed
    	if(Math.abs(motorSpeed) < .21){
    		
    		motorSpeed = motorSpeed>0? .21 : -.21;
    	}
    	
    	if(Math.abs(Robot.m_driveTrain.getEncoderDistance()) >= targetDistance+1.25){
    		motorSpeed *= -1;
    		atDestinationCounter = 0;
    	}
    	else if(Math.abs(Robot.m_driveTrain.getEncoderDistance()) <= targetDistance-1.25){
    		atDestinationCounter = 0;
    	}
    	else{
    		motorSpeed = 0;
    		atDestinationCounter++;
    	}
    	
    	Robot.m_driveTrain.straightDrive(motorSpeed);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return atDestinationCounter > 10 || this.isTimedOut();
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.m_driveTrain.tankDrive(0, 0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
