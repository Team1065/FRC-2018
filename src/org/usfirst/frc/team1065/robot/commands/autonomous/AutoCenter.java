package org.usfirst.frc.team1065.robot.commands.autonomous;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoCenter extends CommandGroup {

    public AutoCenter(boolean switchOnLeft, boolean scaleOnLeft) {
    	addParallel(new SetArmToPosition(50,15.0));
    	addParallel(new IntakeCubeForTime(15.0));
    	addSequential(new DriveToDistance(-0.5, 34, 15.0));
    	if(switchOnLeft){
    		addSequential(new RotateToAngle(.4, 90, 15.0));
        	addSequential(new DriveToDistance(0.5, 70, 90, 15.0));
        	addParallel(new SetArmToPosition(700,15.0));
        	addSequential(new RotateToAngle(.4, 180, 15.0));
    	}
    	else{
    		addSequential(new RotateToAngle(.4, -90, 15.0));
        	addSequential(new DriveToDistance(0.5, 48, -90, 15.0));
        	addParallel(new SetArmToPosition(700,15.0));
        	addSequential(new RotateToAngle(.4, -180, 15.0));
    	}
    	
    	addSequential(new WaitUntilArmInPosition(2.0));
    	addSequential(new DriveToDistance(0.5, 60, 4.0));
    	addSequential(new ShootForTime(1.0));//shoot
    	
    	addSequential(new DriveToDistance(-0.5, 32, 15.0));
    	addParallel(new SetArmToPosition(50,15.0));
    	addParallel(new IntakeCubeForTime(15.0));
    	if(switchOnLeft){
	    	addSequential(new RotateToAngle(.5, 240, 15.0));
	    	addSequential(new WaitUntilArmInPosition(2.0));
	    	addSequential(new DriveToDistance(0.5, 36, 240, 15.0));//pickup
	    	addSequential(new DriveForTime(0, 0, 0.5));
	    	addSequential(new DriveToDistance(-0.5, 36, 240, 15.0));
	    	addParallel(new SetArmToPosition(700,15.0));
	    	addSequential(new RotateToAngle(.5, 180, 15.0));
    	}
    	else{
    		addSequential(new RotateToAngle(.5, -240, 15.0));
    		addSequential(new WaitUntilArmInPosition(2.0));
	    	addSequential(new DriveToDistance(0.5, 36, -240, 15.0));//pickup
	    	addSequential(new DriveForTime(0, 0, 0.5));
	    	addSequential(new DriveToDistance(-0.5, 36, -240, 15.0));
	    	addParallel(new SetArmToPosition(700,15.0));
	    	addSequential(new RotateToAngle(.5, -180, 15.0));
    	}
    	addSequential(new WaitUntilArmInPosition(2.0));
    	addSequential(new DriveToDistance(0.5, 30, 15.0));
    	addSequential(new ShootForTime(1));//shoot
    	addSequential(new DriveToDistance(-0.5, 30, 15.0));
    	addSequential(new SetArmToPosition(50,15.0));
    }
}
