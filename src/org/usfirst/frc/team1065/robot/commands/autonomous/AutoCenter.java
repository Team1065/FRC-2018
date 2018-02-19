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
    		addSequential(new RotateToAngle(.4, -47, 15.0));
        	addSequential(new DriveToDistance(0.5, 60, -47, 15.0));
    	}
    	else{
    		addSequential(new RotateToAngle(.4, 47, 15.0));
        	addSequential(new DriveToDistance(0.5, 55, 47, 15.0));
    	}
    	addParallel(new SetArmToPosition(500,15.0));
    	addSequential(new RotateToAngle(.4, 0, 15.0));
    	addParallel(new DriveForTime(0.2, 0.2, 0.5));
    	addSequential(new ShootForTime(1.5));
    	
    	addSequential(new DriveToDistance(-0.5, 15, 0, 15.0));
    	addParallel(new SetArmToPosition(100,15.0));
    	addParallel(new IntakeCubeForTime(15.0));
    	if(switchOnLeft){
	    	addSequential(new RotateToAngle(.4, 90, 15.0));
	    	addSequential(new DriveToDistance(0.4, 30, 90, 15.0));
	    	addSequential(new DriveForTime(0, 0, 0.5));
	    	addSequential(new DriveToDistance(-0.4, 25, 90, 15.0));
    	}
    	else{
    		addSequential(new RotateToAngle(.4, -90, 15.0));
	    	addSequential(new DriveToDistance(0.4, 30, -90, 15.0));
	    	addSequential(new DriveForTime(0, 0, 0.5));
	    	addSequential(new DriveToDistance(-0.4, 25, -90, 15.0));
    	}
    	addParallel(new SetArmToPosition(500,15.0));
    	addSequential(new RotateToAngle(.4, 0, 15.0));
    	addParallel(new DriveForTime(0.2, 0.2, 0.5));
    	addSequential(new ShootForTime(1));
    }
}
