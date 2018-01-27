/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team1065.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	//PID Constants
    public static final double MECANUM_STRAIGHT_DRIVE_P = 0.05,
    		                   SHOOTER_F = 0.066,//1.68 (20 count encoder)
	                		   SHOOTER_P = 0.45,//13 (20 count encoder)
            				   SHOOTER_I = 0.000002,//0.0001 (20 count encoder)
    						   SHOOTER_D = 0;
	//Double Constants
    public static final double JOYSTICK_DEADBAND = 0.05,
			                   DRIVE_STRAIGHT_BAND_PERCENTAGE = 0.25,
	    					   DRIVE_WHEEL_DIAMETER = 6,
							   DRIVE_ENCODERS_COUNTS_PER_REV = 20;
	
	//PWM Ports
    public static final int LEFT_FRONT_DRIVE_MOTOR_PORT = 0,
    				  	    RIGHT_FRONT_DRIVE_MOTOR_PORT = 1,
		  	    			LEFT_BACK_DRIVE_MOTOR_PORT = 2,
    				  	    RIGHT_BACK_DRIVE_MOTOR_PORT = 3,
			  	    		INTAKE_MOTOR_PORT = 4 ;
	//PCM Ports
    public static final int DROPDOWN_SOLENOID_PORT = 1;
    
	//Digital Ports
    public static final int DRIVE_ENCODER_PORT_A = 0,
	    				    DRIVE_ENCODER_PORT_B = 1,
	    				    CUBE_SENSOR_PORT = 2;
    
	//OI
    public static final int LEFT_JOYSTICK_PORT = 0,					//usb
					  		RIGHT_JOYSTICK_PORT = 1,				//usb
				  			ENHANCED_DS_PORT = 2,					//usb
    						INTAKE_IN_PORT = 4,						//Digital
							INTAKE_OUT_PORT = 5;					//Digital
}
