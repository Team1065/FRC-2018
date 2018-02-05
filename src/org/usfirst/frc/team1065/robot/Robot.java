/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team1065.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;

import org.usfirst.frc.team1065.robot.commands.autonomous.AutoTest1;
import org.usfirst.frc.team1065.robot.commands.autonomous.AutoTest2;
import org.usfirst.frc.team1065.robot.commands.autonomous.AutoTest3;
import org.usfirst.frc.team1065.robot.commands.autonomous.AutoTest4;
import org.usfirst.frc.team1065.robot.subsystems.Arm;
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

	Command m_autonomousCommand;

	@Override
	public void robotInit() {
		m_oi = new OI();
		m_driveTrain = new DriveTrain();
		m_intake = new Intake();
		m_arm = new Arm();
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
    	
    	Command[] CommandsArray = {
			new AutoTest1(),
			new AutoTest2(),
			new AutoTest3(),
			new AutoTest4(),
		};
    	
    	/*Selector 
    	 * 0 == Auto1
    	 * 1 == Auto2
    	 * 2 == Auto3
    	 * 3 == Auto4
    	*/
    	int autoSelector = m_oi.getAutoKnobPosition();
    	
    	m_autonomousCommand = CommandsArray[autoSelector];
		
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
