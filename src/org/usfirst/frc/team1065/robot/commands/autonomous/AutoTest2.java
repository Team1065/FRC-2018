package org.usfirst.frc.team1065.robot.commands.autonomous;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoTest2 extends CommandGroup {

    public AutoTest2() {
    	//TEST OF CENTER S+S (R,L)
    	addSequential(new DriveToDistance(-0.4, 20, 15.0));
    	addSequential(new DriveForTime(0,0,2.0));
    	
    	addSequential(new RotateToAngle(.4, 45, 15.0));
    	addSequential(new DriveForTime(0,0,2.0));
    	
    	addSequential(new DriveToDistance(-0.4, 140, 15.0));
    	addSequential(new DriveForTime(0,0,2.0));
    	
    	addSequential(new RotateToAngle(.4, 0, 15.0));
    	addSequential(new DriveForTime(0,0,2.0));
    	
    	addSequential(new DriveToDistance(-0.4, 70, 15.0));
    	addSequential(new DriveForTime(0,0,2.0));
    	
    	addSequential(new RotateToAngle(.4, 45, 15.0));
    	addSequential(new DriveForTime(0,0,2.0));
    	
    	addSequential(new DriveToDistance(0.4, 20, 15.0));
    	addSequential(new DriveForTime(0,0,2.0));
    	//DUMP
    	addSequential(new DriveToDistance(-0.4, 20, 15.0));
    	addSequential(new DriveForTime(0,0,2.0));
    	
    	addSequential(new RotateToAngle(.4, 60, 15.0));
    	addSequential(new DriveForTime(0,0,2.0));
    	
    	addSequential(new DriveToDistance(0.4, 20, 15.0));
    	addSequential(new DriveForTime(0,0,2.0));
    	//PICKUP
    	addSequential(new RotateToAngle(.4, 100, 15.0));
    	addSequential(new DriveForTime(0,0,2.0));
    	
    	addSequential(new DriveToDistance(0.4, 160, 15.0));
    	addSequential(new DriveForTime(0,0,2.0));
    	
    	addSequential(new RotateToAngle(.4, 0, 15.0));
    	addSequential(new DriveForTime(0,0,2.0));
    	
    	addSequential(new DriveToDistance(-0.4, 40, 15.0));
    	addSequential(new DriveForTime(0,0,2.0));
    	//DUMP
    }
}
