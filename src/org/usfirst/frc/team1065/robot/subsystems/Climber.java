package org.usfirst.frc.team1065.robot.subsystems;

import org.usfirst.frc.team1065.robot.RobotMap;
import org.usfirst.frc.team1065.robot.commands.ManualClimberControl;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Climber extends Subsystem {

    private Talon climberMotor;
    
    public Climber(){
    	climberMotor = new Talon(RobotMap.CLIMBER_MOTOR_PORT);
    }

    public void initDefaultCommand() {
        setDefaultCommand(new ManualClimberControl());
    }
    
    public void goUp(){
    	climberMotor.set(1);
    }
    
    public void goUpSlow(){
    	climberMotor.set(1);
    }
    
    public void goDown(){
    	//climberMotor.set(-1);
    }
    
    public void stop(){
    	climberMotor.set(0);
    }
}

