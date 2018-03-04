package org.usfirst.frc.team1065.robot.commands.autonomous;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoRightSide extends CommandGroup {

    public AutoRightSide(boolean switchOnLeft, boolean scaleOnLeft) {
    	//Scale on Right
    	if(!scaleOnLeft){
    		//addParallel(new SetArmToPosition(50,15.0));
    		addParallel(new IntakeCubeForTime(15.0));
    		addSequential(new DriveToDistance(-.8, 150, 15.0));
    		addParallel(new SetArmToPosition(2200,15.0));
    		addSequential(new RotateToAngle(.5, -18, 15.0));
    		addSequential(new DriveToDistance(-0.5, 28, -18, 15.0));
    		addSequential(new WaitUntilArmInPosition(2.0));
    		addSequential(new ShootForTime(1.0));//Shoot Scale
    		addParallel(new SetArmToPosition(0,15.0));
    		addSequential(new RotateToAngle(.5, 15, 15.0));
    		addParallel(new IntakeCubeForTime(12.5));
    		addSequential(new WaitUntilArmInPosition(2.0));
    		addSequential(new DriveToDistance(0.5, 25, 12.5, 15.0));//pickup
    		addSequential(new DriveForTime(0, 0, 1.0));
    		//addSequential(new DriveToDistance(-0.5, 10, 12.5, 15.0));//pickup
    		
    		//switch on right
    		if(!switchOnLeft){
    			addParallel(new SetArmToPosition(700,15.0));
    			addSequential(new DriveForTime(0, 0, 0.5));
        		addSequential(new WaitUntilArmInPosition(2.0));
        		addSequential(new DriveToDistance(0.5, 10, 12.5, 15.0));//pickup
        		addSequential(new ShootForTime(2.0));//Shoot Switch
    		}
    		//switch on left
    		else{
    			addParallel(new SetArmToPosition(2200,15.0));
    			addSequential(new DriveToDistance(-0.4, 15, 10, 15.0));
    			addSequential(new WaitUntilArmInPosition(2.0));
        		addSequential(new ShootForTime(2.0));//Shoot Scale
    		}
    		
    	}
    	//Scale on Left
    	else{
    		addParallel(new IntakeCubeForTime(15.0));
    		addSequential(new DriveToDistance(-0.8, 157, 15.0));
    		addSequential(new RotateToAngle(.4, -90, 15.0));
    		addSequential(new DriveToDistance(-0.8, 125, -90, 15.0));
    		addParallel(new SetArmToPosition(1000,15.0));
    		addSequential(new RotateToAngle(.4, 0, 15.0));
    		addSequential(new DriveToDistance(-0.4, 30, 0, 15.0));
    		addSequential(new WaitUntilArmInPosition(1.0));
    		addSequential(new ShootForTime(1.0));//Shoot Scale
    		addParallel(new SetArmToPosition(100,15.0));
    		addSequential(new RotateToAngle(.4, -10, 15.0));
    		addParallel(new IntakeCubeForTime(15.0));
    		addSequential(new WaitUntilArmInPosition(1.0));
    		addSequential(new DriveToDistance(0.4, 30, -10, 15.0));//Pickup
    		//switch on left
    		if(switchOnLeft){
    			addParallel(new SetArmToPosition(500,15.0));
        		addSequential(new WaitUntilArmInPosition(1.0));
        		addParallel(new DriveForTime(0.28, 0.3, 3.0));
        		addSequential(new ShootForTime(2.0));//Shoot Switch
    		}
    		//switch on right
    		else{
    			addParallel(new SetArmToPosition(1000,15.0));
    			addSequential(new DriveToDistance(-0.4, 30, -10, 15.0));
    			addSequential(new WaitUntilArmInPosition(1.0));
        		addSequential(new ShootForTime(2.0));//Shoot Scale
    		}
    	}
    }
}
