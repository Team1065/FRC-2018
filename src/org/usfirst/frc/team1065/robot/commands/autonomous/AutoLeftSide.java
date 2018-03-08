package org.usfirst.frc.team1065.robot.commands.autonomous;

import org.usfirst.frc.team1065.robot.Robot;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoLeftSide extends CommandGroup {

    public AutoLeftSide(boolean switchOnLeft, boolean scaleOnLeft) {
    	//Scale on Left
    	if(scaleOnLeft){
    		addParallel(new SetArmToPosition(50,15.0));
    		addParallel(new IntakeCubeForTime(15.0));
    		addSequential(new DriveToDistance(-.8, 150, 15.0));
    		addParallel(new SetArmToPosition(2200,15.0));
    		addSequential(new RotateToAngle(.5, 18, 15.0));
    		addSequential(new DriveToDistance(-0.5, 28, 18, 15.0));
    		addSequential(new WaitUntilArmInPosition(2.0));
    		addSequential(new ShootForTime(1.0));//Shoot Scale
    		addParallel(new SetArmToPosition(0,15.0));
    		addSequential(new RotateToAngle(.5, -15, 15.0));
    		addParallel(new IntakeCubeForTime(12.5));
    		addSequential(new WaitUntilArmInPosition(2.0));
    		addSequential(new DriveToDistance(0.5, 25, -12.5, 15.0));//pickup
    		addSequential(new DriveForTime(0, 0, 1.0));
    		//addSequential(new DriveToDistance(-0.5, 10, 12.5, 15.0));//pickup
    		
    		//switch on left and not forcing double scale
    		if(switchOnLeft && !Robot.m_autoScalePrioritySwitch.get()){
    			addParallel(new SetArmToPosition(700,15.0));
    			addSequential(new DriveForTime(0, 0, 0.5));
        		addSequential(new WaitUntilArmInPosition(2.0));
        		addSequential(new DriveToDistance(0.5, 10, -12.5, 15.0));
        		addSequential(new ShootForTime(1.0));//Shoot Switch
        		addSequential(new DriveToDistance(-0.5, 15, -12.5, 15.0));
        		addSequential(new SetArmToPosition(0,15.0));
    		}
    		//switch on right
    		else{
    			addParallel(new SetArmToPosition(2200,15.0));
    			addSequential(new DriveToDistance(-0.4, 15, -12.5, 15.0));
    			addSequential(new WaitUntilArmInPosition(2.0));
        		addSequential(new ShootForTime(1.0));//Shoot Scale
        		addSequential(new SetArmToPosition(0,15.0));
    		}
    	}
    	//Scale on Right and alley runs not disabled
    	else if (!Robot.m_autoDisableAlleySwitch.get()){
    		addParallel(new SetArmToPosition(50,15.0));
    		addParallel(new IntakeCubeForTime(15.0));
    		addSequential(new DriveToDistance(-0.8, 155, 15.0));
    		addSequential(new RotateToAngle(.5, 90, 15.0));
    		addSequential(new DriveToDistance(-0.8, 128, 90, 15.0));
    		addParallel(new SetArmToPosition(2200,15.0));
    		addSequential(new RotateToAngle(.5, 0, 15.0));
    		addSequential(new DriveToDistance(-0.4, 27, 0, 15.0));
    		addSequential(new WaitUntilArmInPosition(2.0));
    		addSequential(new ShootForTime(1.0));//Shoot Scale
    		addParallel(new SetArmToPosition(0,15.0));
    		addSequential(new RotateToAngle(.4, 10, 15.0));
    		addParallel(new IntakeCubeForTime(15.0));
    		addSequential(new WaitUntilArmInPosition(2.0));
    		addSequential(new DriveToDistance(0.4, 25, 10, 15.0));//Pickup
    		//switch on Right and not forcing double scales
    		if(!switchOnLeft && !Robot.m_autoScalePrioritySwitch.get()){
    			addParallel(new SetArmToPosition(700,15.0));
    			addSequential(new DriveForTime(0, 0, 0.5));
        		addSequential(new WaitUntilArmInPosition(2.0));
        		addSequential(new DriveToDistance(0.5, 10, 10, 15.0));
        		addSequential(new ShootForTime(1.0));//Shoot Switch
        		addSequential(new DriveToDistance(-0.5, 15, 10, 15.0));
        		addSequential(new SetArmToPosition(0,15.0));
    		}
    		//switch on Left
    		else{
    			addParallel(new SetArmToPosition(2200,15.0));
    			addSequential(new DriveToDistance(-0.4, 20, 10, 15.0));
    			addSequential(new WaitUntilArmInPosition(2.0));
        		addSequential(new ShootForTime(2.0));//Shoot Scale
        		addSequential(new SetArmToPosition(0,15.0));
    		}
    	}
    	//Scale on right and alley runs disabled
    	else
    	{
    		addParallel(new SetArmToPosition(50,15.0));
    		addParallel(new IntakeCubeForTime(15.0));
    		addSequential(new DriveToDistance(-0.5, 120, 15.0));
    		//get the switch if it is on the left
    		if(switchOnLeft){
        		addParallel(new SetArmToPosition(700,15.0));
        		addSequential(new RotateToAngle(.5, -90, 15.0));
        		addSequential(new WaitUntilArmInPosition(4.0));
        		addSequential(new DriveToDistance(0.5, 30, 3.0));
        		addSequential(new ShootForTime(2.0));//Shoot
        		addSequential(new DriveToDistance(-0.5, 30, 3.0));
        		addSequential(new RotateToAngle(.5, 0, 15.0));
        		addSequential(new SetArmToPosition(0,15.0));
    		}
    	}
    }
}
