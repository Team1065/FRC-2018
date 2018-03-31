package org.usfirst.frc.team1065.robot.commands.autonomous;

import org.usfirst.frc.team1065.robot.Robot;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoRightSide extends CommandGroup {

    public AutoRightSide(boolean switchOnLeft, boolean scaleOnLeft) {
    	//Scale on Right
    	if(!scaleOnLeft){
    		addParallel(new SetArmToPosition(600,15.0));
    		addParallel(new IntakeCubeForTime(15.0));
    		addSequential(new DriveToDistance(-.9, 150, 15.0));
    		addParallel(new SetArmToPosition(2150,15.0));
    		addSequential(new RotateToAngle(.5, -18, 15.0));
    		addSequential(new DriveToDistance(-0.5, 40, -18, 15.0));
    		addSequential(new WaitUntilArmInPosition(3));
    		addSequential(new ShootForTime(1.0));//Shoot Scale
    		addParallel(new SetArmToPosition(0,15.0));
    		addSequential(new RotateToAngle(.5, 12.5, 15.0));
    		addParallel(new IntakeCubeForTime(15.0));
    		addSequential(new WaitUntilArmInPosition(2.0));
    		addSequential(new DriveToDistance(0.65, 70, 12.5, 15.0));//pickup
    		addSequential(new DriveForTime(0, 0, .1));
    		
    		//switch on right and not forcing double scale
    		if(!switchOnLeft && Robot.m_autoScalePrioritySwitch.get()){
    			addSequential(new DriveToDistance(-0.65, 12, 12.5, 15.0));
    			addParallel(new SetArmToPosition(700,15.0));
    			addSequential(new DriveForTime(0, 0, 0.1));
        		addSequential(new WaitUntilArmInPosition(2.0));
        		addSequential(new DriveToDistance(0.5, 20, 12.5, 15.0));
        		addSequential(new ShootForTime(1.0));//Shoot Switch
        		addSequential(new DriveToDistance(-0.5, 15, 12.5, 15.0));
        		addSequential(new SetArmToPosition(0,15.0));
    		}
    		//switch on left
    		else{
    			addParallel(new SetArmToPosition(2150,15.0));
    			addSequential(new DriveToDistance(-0.4, 44, 7, 15.0));
    			addSequential(new WaitUntilArmInPosition(3.5));
        		addSequential(new ShootForTime(.25, 1.5));//Shoot Scale
        		addSequential(new SetArmToPosition(0,15.0));
    		}
    		
    	}
    	//Scale on Left and alley runs not disabled
    	else if (Robot.m_autoDisableAlleySwitch.get()){
    		addParallel(new SetArmToPosition(0,15.0));
    		addParallel(new IntakeCubeForTime(15.0));
    		addSequential(new DriveToDistance(-0.9, 160, 15.0));
    		addSequential(new RotateToAngle(.5, -90, 15.0));
    		addSequential(new DriveToDistance(-0.8, 135, -90, 15.0));
    		addParallel(new SetArmToPosition(2150,15.0));
    		addSequential(new RotateToAngle(.5, 0, 15.0));
    		addSequential(new DriveToDistance(-0.4, 27, 0, 15.0));
    		addSequential(new WaitUntilArmInPosition(3));
    		addSequential(new ShootForTime(1.0));//Shoot Scale
    		addParallel(new SetArmToPosition(0,15.0));
    		addSequential(new RotateToAngle(.4, -10, 15.0));
    		addParallel(new IntakeCubeForTime(15.0));
    		addSequential(new WaitUntilArmInPosition(2.0));
    		addSequential(new DriveToDistance(0.65, 50, -10, 15.0));//Pickup
    		addSequential(new DriveForTime(0, 0, .1));
    		//switch on left and not forcing double scale
    		if(switchOnLeft && Robot.m_autoScalePrioritySwitch.get()){
    			addSequential(new DriveToDistance(-0.65, 12, -10, 15.0));
    			addParallel(new SetArmToPosition(700,15.0));
    			addSequential(new DriveForTime(0, 0, 0.1));
        		addSequential(new WaitUntilArmInPosition(2.0));
        		addSequential(new DriveToDistance(0.5, 20, -10, 15.0));
        		addSequential(new ShootForTime(1.0));//Shoot Switch
        		addSequential(new DriveToDistance(0.5, 15, -10, 15.0));
        		addSequential(new SetArmToPosition(0,15.0));
    		}
    		//switch on right
    		else{
    			addParallel(new SetArmToPosition(2150,15.0));
    			addSequential(new DriveToDistance(-0.45, 38, -5, 15.0));
    			addSequential(new WaitUntilArmInPosition(2.0));
        		addSequential(new ShootForTime(.25, 1.0));//Shoot Scale
        		addSequential(new SetArmToPosition(0,15.0));
    		}
    	}
    	//Scale on left and alley runs disabled
    	else
    	{
    		addParallel(new SetArmToPosition(0,15.0));
    		addParallel(new IntakeCubeForTime(15.0));
    		addSequential(new DriveToDistance(-0.5, 105, 15.0));
    		//get the switch if it is on the right
    		if(!switchOnLeft){
        		addParallel(new SetArmToPosition(700,15.0));
        		addSequential(new RotateToAngle(.5, 90, 15.0));
        		addSequential(new WaitUntilArmInPosition(4.0));
        		addSequential(new DriveToDistance(0.5, 30, 90, 3.0));
        		addSequential(new ShootForTime(2.0));//Shoot
        		addSequential(new DriveToDistance(-0.5, 30, 90, 3.0));
        		addSequential(new RotateToAngle(.5, 0, 15.0));
        		addSequential(new SetArmToPosition(0,15.0));
    		}
    	}
    }
}
