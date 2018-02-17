package org.usfirst.frc.team1065.robot.commands.autonomous;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoCenter extends CommandGroup {

    public AutoCenter(boolean switchOnLeft, boolean scaleOnLeft) {
    	addParallel(new IntakeCubeForTime(15.0));
    	addSequential(new DriveToDistance(0.8, 15, 15.0));
    	if(switchOnLeft){
    		addSequential(new RotateToAngle(.4, -47, 15.0));
        	addSequential(new DriveToDistance(0.8, 65, -47, 15.0));
    	}
    	else{
    		addSequential(new RotateToAngle(.4, 47, 15.0));
        	addSequential(new DriveToDistance(0.8, 60, 47, 15.0));
    	}
    	addParallel(new SetArmToPosition(500,15.0));
    	addSequential(new RotateToAngle(.4, 0, 15.0));
    	addSequential(new DriveToDistance(0.8, 50, 0, 15.0));
    	addSequential(new ShootForTime(1.5));
    	
    	addSequential(new DriveToDistance(-0.8, 15, 0, 15.0));
    	addParallel(new SetArmToPosition(100,15.0));
    	addParallel(new IntakeCubeForTime(15.0));
    	if(switchOnLeft){
	    	addSequential(new RotateToAngle(.4, 90, 15.0));
	    	addSequential(new DriveToDistance(0.8, 50, 90, 15.0));
	    	addSequential(new DriveToDistance(-0.8, 50, 90, 15.0));
    	}
    	else{
    		addSequential(new RotateToAngle(.4, -90, 15.0));
	    	addSequential(new DriveToDistance(0.8, 50, -90, 15.0));
	    	addSequential(new DriveToDistance(-0.8, 50, -90, 15.0));
    	}
    	addParallel(new SetArmToPosition(500,15.0));
    	addSequential(new RotateToAngle(.4, 0, 15.0));
    	addSequential(new DriveToDistance(0.8, 15, 0, 15.0));
    	addSequential(new ShootForTime(1.5));
    }
}
