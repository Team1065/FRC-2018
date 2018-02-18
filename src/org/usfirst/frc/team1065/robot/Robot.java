/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team1065.robot;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;

import org.usfirst.frc.team1065.robot.commands.autonomous.AutoCenter;
import org.usfirst.frc.team1065.robot.commands.autonomous.AutoLeftSide;
import org.usfirst.frc.team1065.robot.commands.autonomous.AutoRightSide;
import org.usfirst.frc.team1065.robot.commands.autonomous.AutoTest1;
import org.usfirst.frc.team1065.robot.commands.autonomous.AutoTest2;
import org.usfirst.frc.team1065.robot.commands.autonomous.AutoTest3;
import org.usfirst.frc.team1065.robot.commands.autonomous.AutoTest4;
import org.usfirst.frc.team1065.robot.commands.autonomous.CrossLine;
import org.usfirst.frc.team1065.robot.subsystems.Arm;
import org.usfirst.frc.team1065.robot.subsystems.Climber;
import org.usfirst.frc.team1065.robot.subsystems.DriveTrain;
import org.usfirst.frc.team1065.robot.subsystems.Intake;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.properties file in the
 * project.
 */
public class Robot extends TimedRobot {

	public static OI m_oi;
	public static DriveTrain m_driveTrain;
	public static Intake m_intake;
	public static Arm m_arm;
	public static Climber m_climber;
	public static Compressor m_compressor;

	Command m_autonomousCommand;

	@Override
	public void robotInit() {
		m_oi = new OI();
		m_driveTrain = new DriveTrain();
		m_intake = new Intake();
		m_arm = new Arm();
		m_climber = new Climber();
		m_compressor = new Compressor();
	}

	/**
	 * This function is called once each time the robot enters Disabled mode.
	 * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
	 */
	@Override
	public void disabledInit() {

	}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void autonomousInit() {
		m_driveTrain.resetAngle();
    	m_driveTrain.resetEncoder();
    	
    	/*Position Selector 
    	 * 0 == Left Start Position
    	 * 1 == Center Start Position
    	 * 2 == Right Start Position
    	 * 3 == Right Start Position (Copy for redundancy
    	*/
    	int autoPositionSelector = m_oi.getAutoKnobPosition();
    	
    	//Getting data from FMS on switch and scale position
    	String gameData;
		gameData = DriverStation.getInstance().getGameSpecificMessage();
        if(gameData.length() > 1){
        	boolean switchOnLeft = gameData.charAt(0) == 'L' ? true:false;
        	boolean scaleOnLeft = gameData.charAt(1) == 'L' ? true:false;
        	
        	Command[] CommandsArray = {
        			//maybe add priority (switch, scale)
        			new AutoLeftSide(switchOnLeft,scaleOnLeft),
        			new AutoCenter(switchOnLeft,scaleOnLeft),
        			new AutoRightSide(switchOnLeft,scaleOnLeft),
        			new AutoRightSide(switchOnLeft,scaleOnLeft),
    		};
        	m_autonomousCommand = CommandsArray[autoPositionSelector];
        }
        else{
        	Command[] CommandsArray = {
        			//maybe add priority (switch, scale)
        			new CrossLine(),
        			new CrossLine(),
        			new CrossLine(),
        			new CrossLine(),
    		};
        	m_autonomousCommand = CommandsArray[autoPositionSelector];
        }
    	/*
    	Command[] CommandsArray = {
			new AutoTest1(),
			new AutoTest2(),
			new AutoTest3(),
			new AutoTest4(),
		};
		m_autonomousCommand = CommandsArray[autoPositionSelector];
		*/

		// schedule the autonomous command (example)
		if (m_autonomousCommand != null) {
			m_autonomousCommand.start();
		}
	}

	/**
	 * This function is called periodically during autonomous.
	 */
	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
		m_driveTrain.updateStatus();
		m_intake.updateStatus();
		m_arm.updateStatus();
	}

	@Override
	public void teleopInit() {
		m_driveTrain.resetEncoder();
		if (m_autonomousCommand != null) {
			m_autonomousCommand.cancel();
		}
	}

	/**
	 * This function is called periodically during operator control.
	 */
	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
		m_driveTrain.updateStatus();
		m_intake.updateStatus();
		m_arm.updateStatus();
		
		if(m_oi.getCompressorOverride()){
			m_compressor.setClosedLoopControl(false);
        }
        else{
        	m_compressor.setClosedLoopControl(true);
        }
	}

	/**
	 * This function is called periodically during test mode.
	 */
	@Override
	public void testPeriodic() {
		m_driveTrain.updateStatus();
		m_intake.updateStatus();
		m_arm.updateStatus();
	}
}
