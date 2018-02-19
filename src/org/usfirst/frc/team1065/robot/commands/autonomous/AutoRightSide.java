package org.usfirst.frc.team1065.robot.commands.autonomous;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoRightSide extends CommandGroup {

    public AutoRightSide(boolean switchOnLeft, boolean scaleOnLeft) {
    	//Scale on Right
    	if(!scaleOnLeft){
    		addParallel(new IntakeCubeForTime(15.0));
    		addSequential(new DriveToDistance(-0.8, 150, 15.0));
    		addParallel(new SetArmToPosition(2000,15.0));
    		addSequential(new RotateToAngle(.4, -14, 15.0));
    		addSequential(new DriveToDistance(-0.4, 35, -14, 15.0));
    		addSequential(new WaitUntilArmInPosition(1.0));
    		addSequential(new ShootForTime(1.0));//Shoot Scale
    		addParallel(new SetArmToPosition(100,15.0));
    		addSequential(new RotateToAngle(.4, 10, 15.0));
    		addParallel(new IntakeCubeForTime(15.0));
    		addSequential(new WaitUntilArmInPosition(1.0));
    		addSequential(new DriveToDistance(0.4, 20, 10, 15.0));//pickup
    		
    		//switch on right
    		if(!switchOnLeft){
    			addParallel(new SetArmToPosition(500,15.0));
        		addSequential(new WaitUntilArmInPosition(2.0));
        		addParallel(new DriveForTime(0.3, 0.28, 3.0));
        		addSequential(new ShootForTime(2.0));//Shoot Switch
    		}
    		//switch on left
    		else{
    			addParallel(new SetArmToPosition(2000,15.0));
    			addSequential(new DriveToDistance(-0.4, 20, 10, 15.0));
    			addSequential(new WaitUntilArmInPosition(1.0));
        		addSequential(new ShootForTime(2.0));//Shoot Scale
    		}
    		
    	}
    	//Scale on Left
    	else{
    		addParallel(new IntakeCubeForTime(15.0));
    		addSequential(new DriveToDistance(-0.8, 157, 15.0));
    		addSequential(new RotateToAngle(.4, -90, 15.0));
    		addSequential(new DriveToDistance(-0.8, 125, -90, 15.0));
    		addParallel(new SetArmToPosition(2000,15.0));
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
        		addParallel(new DriveForTime(0.2, 0.2, 3.0));
        		addSequential(new ShootForTime(2.0));//Shoot Switch
    		}
    		//switch on right
    		else{
    			addParallel(new SetArmToPosition(2000,15.0));
    			addSequential(new DriveToDistance(-0.4, 30, -10, 15.0));
    			addSequential(new WaitUntilArmInPosition(1.0));
        		addSequential(new ShootForTime(2.0));//Shoot Scale
    		}
    	}
    }
}
