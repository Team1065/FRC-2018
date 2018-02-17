package org.usfirst.frc.team1065.robot.commands.autonomous;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoLeftSide extends CommandGroup {

    public AutoLeftSide(boolean switchOnLeft, boolean scaleOnLeft) {
    	//Scale on left
    	if(scaleOnLeft){
    		addParallel(new IntakeCubeForTime(15.0));
    		addSequential(new DriveToDistance(-0.8, 150, 15.0, false));
    		addParallel(new SetArmToPosition(2000,15.0));
    		addSequential(new DriveToDistance(-0.8, 40, 20, 15.0));
    		addSequential(new WaitUntilArmInPosition(5.0));
    		addSequential(new ShootForTime(1.0));
    		addParallel(new SetArmToPosition(100,15.0));
    		addSequential(new RotateToAngle(.4, -10, 15.0));
    		addParallel(new IntakeCubeForTime(15.0));
    		addSequential(new DriveToDistance(0.8, 50, -10, 15.0));
    		
    		//switch on left
    		if(switchOnLeft){
    			addParallel(new SetArmToPosition(500,15.0));
        		addSequential(new WaitUntilArmInPosition(5.0));
        		addSequential(new DriveToDistance(0.8, 10, 0, 15.0));
        		addSequential(new ShootForTime(2.0));
    		}
    		//switch on right
    		else{
    			addParallel(new SetArmToPosition(2000,15.0));
    			addSequential(new DriveToDistance(-0.8, 50, -10, 15.0));
    			addSequential(new WaitUntilArmInPosition(5.0));
        		addSequential(new ShootForTime(2.0));
    		}
    		
    	}
    	//Scale on right
    	else{
    		addParallel(new IntakeCubeForTime(15.0));
    		addSequential(new DriveToDistance(-0.8, 150, 15.0));
    		addSequential(new RotateToAngle(.4, 90, 15.0));
    		addSequential(new DriveToDistance(-0.8, 150, 90, 15.0, false));
    		addParallel(new SetArmToPosition(2000,15.0));
    		addSequential(new DriveToDistance(-0.8, 40, 0, 15.0, true));
    		addSequential(new WaitUntilArmInPosition(5.0));
    		addSequential(new ShootForTime(1.0));
    		addParallel(new SetArmToPosition(100,15.0));
    		addSequential(new WaitUntilArmInPosition(5.0));
    		addParallel(new IntakeCubeForTime(15.0));
    		addSequential(new DriveToDistance(0.8, 50, 0, 15.0));
    		//switch on right
    		if(!switchOnLeft){
    			addParallel(new SetArmToPosition(500,15.0));
        		addSequential(new WaitUntilArmInPosition(5.0));
        		addSequential(new DriveToDistance(0.8, 10, 0, 15.0));
        		addSequential(new ShootForTime(2.0));
    		}
    		//switch on left
    		else{
    			addParallel(new SetArmToPosition(2000,15.0));
    			addSequential(new DriveToDistance(-0.8, 50, 0, 15.0));
    			addSequential(new WaitUntilArmInPosition(5.0));
        		addSequential(new ShootForTime(2.0));
    		}
    		
    	}
    }
}
