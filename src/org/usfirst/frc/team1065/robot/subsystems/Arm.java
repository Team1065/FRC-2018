package org.usfirst.frc.team1065.robot.subsystems;

import org.usfirst.frc.team1065.robot.RobotMap;
import org.usfirst.frc.team1065.robot.commands.ManualArmControl;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class Arm extends Subsystem {
	private TalonSRX m_masterTalon, m_slaveTalon;
	private Solenoid m_solenoid;
	private DigitalInput bottomLimitSwitch, topLimitSwitch;
	
	public Arm(){
		bottomLimitSwitch = new DigitalInput(RobotMap.ARM_BOTTOM_SWITCH_PORT);
		topLimitSwitch = new DigitalInput(RobotMap.ARM_TOP_SWITCH_PORT);
		m_solenoid = new Solenoid(RobotMap.ARM_SOLENOID_PORT);
		
		m_masterTalon = new TalonSRX(RobotMap.MASTER_TALON_PORT);
		m_slaveTalon = new TalonSRX(RobotMap.SLAVE_TALON_PORT);
		
		m_slaveTalon.follow(m_masterTalon);
		m_slaveTalon.setInverted(false);//TODO: Verify
		m_slaveTalon.configNominalOutputForward(0, 0);
		m_slaveTalon.configNominalOutputReverse(0, 0);
		m_slaveTalon.configPeakOutputForward(1, 0);
		m_slaveTalon.configPeakOutputReverse(-.5, 0);
		
		//m_masterTalon.configSelectedFeedbackSensor(FeedbackDevice.Analog, 0, 0);
		m_masterTalon.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, 0);
		m_masterTalon.setSensorPhase(false);
		m_masterTalon.setInverted(false);//TODO:Verify
		m_masterTalon.configNominalOutputForward(0.1, 0);//TODO: Check
		m_masterTalon.configNominalOutputReverse(-0.0, 0);//TODO: Check
		m_masterTalon.configPeakOutputForward(1, 0);
		m_masterTalon.configPeakOutputReverse(-.5, 0);//TODO:Check
		m_masterTalon.configAllowableClosedloopError(0, RobotMap.ARM_ERROR, 0);//TODO Check values (4096 is 1 rotation away)
		m_masterTalon.config_kF(0, RobotMap.ARM_F, 0);
		m_masterTalon.config_kP(0, RobotMap.ARM_P, 0);
		m_masterTalon.config_kI(0, RobotMap.ARM_I, 0);
		m_masterTalon.config_kD(0, RobotMap.ARM_D, 0);
		
		//There is an option to get the absolute value from the CTR sensor but we will just zero it out for now
		m_masterTalon.setSelectedSensorPosition(0, 0, 0);
		
		/*
		int absolutePosition = _talon.getSensorCollection().getPulseWidthPosition();
		
		absolutePosition &= 0xFFF;
		
		if (Constants.kSensorPhase)
			absolutePosition *= -1;
		if (Constants.kMotorInvert)
			absolutePosition *= -1;

		_talon.setSelectedSensorPosition(absolutePosition, Constants.kPIDLoopIdx, Constants.kTimeoutMs);
		*/
	}

    public void initDefaultCommand() {
        setDefaultCommand(new ManualArmControl());
    }
    
    public void setPosition(double position) {
    	if(position > RobotMap.ARM_RETRACTED_LOWER_LIMIT && position < RobotMap.ARM_RETRACTED_HIGHER_LIMIT){
    		retractSolenoid(true);
    	}
    	else{
    		retractSolenoid(false);
    	}
    	//assume normally open switches
    	if((position < m_masterTalon.getSelectedSensorPosition(0) && !bottomLimitSwitch.get()) || 
    			(position > m_masterTalon.getSelectedSensorPosition(0) && !topLimitSwitch.get())){
    		m_masterTalon.set(ControlMode.PercentOutput, 0);
    	}
    	else{
    		m_masterTalon.set(ControlMode.Position,position);
    	}
    	
    }

    public void setVoltage(double speed) {
    	//assume normally open switches
    	if((speed < 0 && !bottomLimitSwitch.get()) || (speed > 0 && !topLimitSwitch.get())){
    		m_masterTalon.set(ControlMode.PercentOutput, 0);
    	}
    	else{
    		m_masterTalon.set(ControlMode.PercentOutput, speed);
    	}
    }
    
    public boolean isOnTarget(){
    	return m_masterTalon.getClosedLoopError(0) < RobotMap.ARM_ERROR;
    }
    
    public void retractSolenoid(boolean retract){
    	m_solenoid.set(retract);
    }
    
    public boolean isSolenoidRetracted(){
    	return m_solenoid.get();
    }
    
    public void updateStatus(){
    	SmartDashboard.putNumber("Arm Talon Speed", m_masterTalon.getSelectedSensorPosition(0));
    	SmartDashboard.putNumber("Arm Setpoint", m_masterTalon.getClosedLoopTarget(0));
    	SmartDashboard.putNumber("Arm Error", m_masterTalon.getClosedLoopError(0));
    	SmartDashboard.putBoolean("Arm on Target", isOnTarget());
    	SmartDashboard.putBoolean("Arm Solenoid Retracted", isSolenoidRetracted());
    }
}

