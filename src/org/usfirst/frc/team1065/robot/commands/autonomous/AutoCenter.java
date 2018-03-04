package org.usfirst.frc.team1065.robot.commands.autonomous;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoCenter extends CommandGroup {

    public AutoCenter(boolean switchOnLeft, boolean scaleOnLeft) {
    	/*addParallel(new IntakeCubeForTime(15.0));
    	addSequential(new DriveToDistance(-0.5, 15, 15.0));
    	addSequential(new RotateToAngle(.4, 55, 15.0));
    	addSequential(new DriveToDistance(-0.7, 105, 55, 15.0));
    	addSequential(new RotateToAngle(.4, 0, 15.0));*/
    	
    	addParallel(new IntakeCubeForTime(15.0));
    	addSequential(new DriveToDistance(0.5, 15, 15.0));
    	if(switchOnLeft){
    		addSequential(new RotateToAngle(.4, -50, 15.0));
        	addSequential(new DriveToDistance(0.5, 60, -50, 15.0));
    	}
    	else{
    		addSequential(new RotateToAngle(.4, 47, 15.0));
        	addSequential(new DriveToDistance(0.5, 55, 47, 15.0));
    	}
    	addParallel(new SetArmToPosition(700,15.0));
    	addSequential(new RotateToAngle(.5, 0, 15.0));
    	addSequential(new WaitUntilArmInPosition(2.0));
    	addSequential(new DriveToDistance(0.5, 10, 0, 15.0));
    	addSequential(new ShootForTime(1.0));//shoot
    	
    	addSequential(new DriveToDistance(-0.5, 10, 0, 15.0));
    	addParallel(new SetArmToPosition(0,15.0));
    	addParallel(new IntakeCubeForTime(15.0));
    	if(switchOnLeft){
	    	addSequential(new RotateToAngle(.5, 90, 15.0));
	    	addSequential(new WaitUntilArmInPosition(2.0));
	    	addSequential(new DriveToDistance(0.5, 30, 90, 15.0));//pickup
	    	addSequential(new DriveForTime(0, 0, 0.5));
	    	addSequential(new DriveToDistance(-0.5, 30, 90, 15.0));
    	}
    	else{
    		addSequential(new RotateToAngle(.5, -90, 15.0));
    		addSequential(new WaitUntilArmInPosition(2.0));
	    	addSequential(new DriveToDistance(0.5, 30, -90, 15.0));//pickup
	    	addSequential(new DriveForTime(0, 0, 0.5));
	    	addSequential(new DriveToDistance(-0.5, 25, -90, 15.0));
    	}
    	addParallel(new SetArmToPosition(700,15.0));
    	addSequential(new RotateToAngle(.5, 0, 15.0));
    	addSequential(new WaitUntilArmInPosition(2.0));
    	addSequential(new DriveToDistance(0.5, 10, 0, 15.0));
    	addSequential(new ShootForTime(1));//shoot
    	addSequential(new DriveToDistance(-0.5, 20, 0, 15.0));
    	addSequential(new SetArmToPosition(0,15.0));
    }
}
