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
	//Shooter RPM values
    public static final double ARM_POS_0 = 0.0,//home?
							   ARM_POS_1 = 0.0,//pickup
    						   ARM_POS_2 = 700.0,//switch
    						   ARM_POS_3 = 1350.0,//low scale
    						   ARM_POS_4 = 2000.0,//medium scale
    						   ARM_POS_5 = 2200.0;//Dunk
	
	//PID Constants
    public static final double MECANUM_STRAIGHT_DRIVE_P = 0.023,
    		                   ARM_F = 0,
	                		   ARM_P = 0.8,
            				   ARM_I = 0.015,
    						   ARM_D = 0;
	//Double Constants
    public static final double JOYSTICK_DEADBAND = 0.05,
			                   DRIVE_STRAIGHT_BAND_PERCENTAGE = 0.25,
	    					   DRIVE_WHEEL_DIAMETER = 6,
							   DRIVE_ENCODERS_COUNTS_PER_REV = 20,
							   ARM_JOYSTICK_MIDDLE = 0.063,
							   ARM_JOYSTICK_DEADBAND = 0.01,
							   ARM_RETRACTED_LOWER_LIMIT = -100,
							   ARM_RETRACTED_HIGHER_LIMIT = 2100;
    
    //Int Constants
    public static final int ARM_ERROR = 20;//4098 is 1 full rotation
	
	//PWM Ports
    public static final int LEFT_FRONT_DRIVE_MOTOR_PORT = 0,
    				  	    RIGHT_FRONT_DRIVE_MOTOR_PORT = 1,
		  	    			LEFT_BACK_DRIVE_MOTOR_PORT = 2,
    				  	    RIGHT_BACK_DRIVE_MOTOR_PORT = 3,
			  	    		INTAKE_MOTOR_PORT = 4,
	  	    				CLIMBER_MOTOR_PORT = 5;
    
    //CANTalon Ports
    public static final int MASTER_TALON_PORT = 1,
    						SLAVE_TALON_PORT = 2;
    
	//PCM Ports
    public static final int DROPDOWN_SOLENOID_PORT = 1,
    						ARM_SOLENOID_PORT = 2,
							INTAKE_LED_SOLENOID_PORT = 3,
							INTAKE_LED2_SOLENOID_PORT = 4;
    
	//Digital Ports
    public static final int DRIVE_ENCODER_PORT_A = 0,
	    				    DRIVE_ENCODER_PORT_B = 1,
	    				    CUBE_SENSOR_PORT = 2,
				    		ARM_BOTTOM_SWITCH_PORT = 3,
				    		ARM_TOP_SWITCH_PORT = 4,
				    		AUTO_DISABLE_ALLEY_SWITCH_PORT = 5,
				    		AUTO_SCALE_PRIORITY_SWITCH_PORT = 6;
    
	//OI
    public static final int LEFT_JOYSTICK_PORT = 0,					//usb
					  		RIGHT_JOYSTICK_PORT = 1,				//usb
				  			ENHANCED_DS_PORT = 2,					//usb
				  			INTAKE_OFF_PORT = 1,	    			//Digital
				  			COMPRESSOR_CONTROL_OVERRIDE = 2,		//Digital
    						SHOOTING_SLOW_PORT = 4,					//Digital
							SHOOTING_FAST_PORT = 5,					//Digital
							CLIMB_UP_PORT = 6,						//Digital
						    CLIMB_DOWN_PORT = 8,					//Digital
							ARM_CONTROL_OVERRIDE = 9,				//Digital
							ARM_SOLENOID_CONTROL_OVERRIDE = 12,		//Digital
							SHOOTER_KNOB_PORT = 0,					//Analog
				    		AUTO_KNOB_PORT = 1,                     //Analog
				    		ARM_JOYSTICK_Y_PORT = 2;			    //Analog;					
    
    public static final double  ARM_KNOB_POS_0 = 0.000,
								ARM_KNOB_POS_1 = 0.024,
								ARM_KNOB_POS_2 = 0.047,
								ARM_KNOB_POS_3 = 0.071,
								ARM_KNOB_POS_4 = 0.094,
								ARM_KNOB_POS_5 = 0.118,
								AUTO_KNOB_POS_0 = 0.000,
								AUTO_KNOB_POS_1 = 0.024,
								AUTO_KNOB_POS_2 = 0.055,
								AUTO_KNOB_POS_3 = 0.087;
}
