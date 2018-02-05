package org.usfirst.frc.team1065.robot.commands.autonomous;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoTest1 extends CommandGroup {

    public AutoTest1() {
    	//TEST OF CENTER S+S (R,R)
    	addSequential(new DriveToDistance(-0.8, 15, 15.0));
    	//addSequential(new DriveForTime(0,0,0.5));
    	
    	addSequential(new RotateToAngle(.4, 47, 15.0));
    	//addSequential(new DriveForTime(0,0,0.5));
    	
    	addSequential(new DriveToDistance(-0.8, 110, 15.0));
    	//addSequential(new DriveForTime(0,0,0.5));
    	
    	addSequential(new RotateToAngle(.4, 0, 15.0));
    	//addSequential(new DriveForTime(0,0,0.5));
    	
    	addSequential(new DriveToDistance(-0.8, 50, 15.0));
    	//addSequential(new DriveForTime(0,0,0.5));
    	
    	addSequential(new RotateToAngle(.4, 40, 15.0));
    	//addSequential(new DriveForTime(0,0,0.5));
    	
    	addSequential(new DriveToDistance(0.8, 7, 15.0));
    	//addSequential(new DriveForTime(0,0,2.0));
    	//DUMP
    	addSequential(new DriveToDistance(-0.8, 20, 15.0));
    	//addSequential(new DriveForTime(0,0,0.5));
    	
    	addSequential(new RotateToAngle(.4, 73, 15.0));
    	//addSequential(new DriveForTime(0,0,0.5));
    	
    	addSequential(new DriveToDistance(0.8, 10, 15.0));
    	//addSequential(new DriveForTime(0,0,2.0));
    	//PICKUP
    	addSequential(new RotateToAngle(.4, -10, 15.0));
    	//addSequential(new DriveForTime(0,0,0.5));
    	
    	addSequential(new DriveToDistance(-0.8, 57, 15.0));
    	//addSequential(new DriveForTime(0,0,2.0));
    	//DUMP
    }
}
