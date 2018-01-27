package org.usfirst.frc.team1065.robot.subsystems;

import org.usfirst.frc.team1065.robot.RobotMap;
import org.usfirst.frc.team1065.robot.commands.ManualIntakeControl;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class Intake extends Subsystem {

    private Talon m_intakeMotor;
    private DigitalInput m_cubeSwitch;
    
    public Intake(){
    	m_intakeMotor = new Talon(RobotMap.INTAKE_MOTOR_PORT);
    	m_intakeMotor.setInverted(false);
    	m_cubeSwitch = new DigitalInput(RobotMap.CUBE_SENSOR_PORT);
    }

    public void initDefaultCommand() {
        setDefaultCommand(new ManualIntakeControl());
    }
    
    public void setIntakeIn(double speed){
    	m_intakeMotor.set(Math.abs(speed));
    }
    
    public void setIntakeOut(double speed){
    	m_intakeMotor.set(- Math.abs(speed));
    }
    
    public void setIntake(double speed){
    	m_intakeMotor.set(speed);
    }
    
    public boolean isCubeDetected(){
    	return m_cubeSwitch.get();
    }
    
    public void updateStatus(){
    	SmartDashboard.putBoolean("[Intake] Cube Detected", isCubeDetected());
    }
}

