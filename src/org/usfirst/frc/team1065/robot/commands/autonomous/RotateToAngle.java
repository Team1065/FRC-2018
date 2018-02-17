package org.usfirst.frc.team1065.robot.commands.autonomous;

import org.usfirst.frc.team1065.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class RotateToAngle extends Command {
	double speed, angle;
	int onAngleCounter;

    public RotateToAngle(double speed, double angle, double time) {
        requires(Robot.m_driveTrain);
        this.speed = Math.abs(speed);//0,1
        this.angle = angle;//-180,180
        this.setTimeout(time);
        onAngleCounter = 0;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	double currentAngle = Robot.m_driveTrain.getAngle();
    	double motorSpeed = speed;
    	//slow down if close to target
    	if(currentAngle > angle-5 && currentAngle < angle+5){
    		motorSpeed = 0.1;
    	}
    	else if(currentAngle > angle-10 && currentAngle < angle+10){
    		motorSpeed = 0.15;
    	}
    	else if(currentAngle > angle-15 && currentAngle < angle+15){
    		motorSpeed = 0.2;
    	}
    	else if(currentAngle > angle-20 && currentAngle < angle+20){
    		motorSpeed = 0.25;
    	}
    	else if(currentAngle > angle-30 && currentAngle < angle+30){
    		motorSpeed = 0.3;
    	}
    	
    	if(motorSpeed < .1){
    		motorSpeed = .1;
    	}
    	
    	//direction of rotation decided based on target angle
    	if(Robot.m_driveTrain.getAngle() > angle){
    		motorSpeed = motorSpeed * -1;
    	}
    	
    	if(Math.abs(Robot.m_driveTrain.getAngle() - angle) < 2.5){
    		motorSpeed = 0;
    		onAngleCounter++;
    	}
    	else{
    		onAngleCounter = 0;
    	}
    	
    	Robot.m_driveTrain.tankDrive(motorSpeed, -motorSpeed);
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	return onAngleCounter > 3  || this.isTimedOut();
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
