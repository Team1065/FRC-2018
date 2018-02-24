package org.usfirst.frc.team1065.robot.subsystems;

import org.usfirst.frc.team1065.robot.RobotMap;
import org.usfirst.frc.team1065.robot.commands.LightControl;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Lights extends Subsystem {
	private Solenoid m_intakeLED;
    public Lights(){
    	m_intakeLED = new Solenoid(RobotMap.INTAKE_LED_SOLENOID_PORT);
    }

    public void initDefaultCommand() {
        setDefaultCommand(new LightControl());
    }
    
    public void setIntakeLED(boolean on){
    	m_intakeLED.set(on);
    }
}

