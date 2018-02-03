package org.usfirst.frc.team1065.robot.subsystems;

import org.usfirst.frc.team1065.robot.RobotMap;
import org.usfirst.frc.team1065.robot.commands.ManualArmControl;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class Arm extends Subsystem {
	private TalonSRX m_masterTalon, m_slaveTalon;
	
	public Arm(){
		m_masterTalon = new TalonSRX(RobotMap.MASTER_TALON_PORT);
		m_slaveTalon = new TalonSRX(RobotMap.SLAVE_TALON_PORT);
		
		m_slaveTalon.follow(m_masterTalon);
		m_slaveTalon.setInverted(false);//TODO: Verify
		m_slaveTalon.configNominalOutputForward(0, 0);
		m_slaveTalon.configNominalOutputReverse(0, 0);
		m_slaveTalon.configPeakOutputForward(1, 0);
		m_slaveTalon.configPeakOutputReverse(-.5, 0);
		
		m_masterTalon.configSelectedFeedbackSensor(FeedbackDevice.Analog, 0, 0);
		m_masterTalon.setInverted(false);//TODO:Verify
		m_masterTalon.configNominalOutputForward(0.1, 0);//TODO: Check
		m_masterTalon.configNominalOutputReverse(-0.1, 0);//TODO: Check
		m_masterTalon.configPeakOutputForward(1, 0);
		m_masterTalon.configPeakOutputReverse(-.5, 0);//TODO:Check
		m_masterTalon.configAllowableClosedloopError(0, 0, 0);//TODO Check values
		m_masterTalon.config_kF(0, RobotMap.ARM_F, 0);
		m_masterTalon.config_kP(0, RobotMap.ARM_P, 0);
		m_masterTalon.config_kI(0, RobotMap.ARM_I, 0);
		m_masterTalon.config_kD(0, RobotMap.ARM_D, 0);
	}

    public void initDefaultCommand() {
        setDefaultCommand(new ManualArmControl());
    }
    
    public void setPosition(double position) {
    	m_masterTalon.set(ControlMode.Position,position);
    }

    public void setVoltage(double speed) {
    	m_masterTalon.set(ControlMode.PercentOutput, speed);
    }
    
    public boolean isOnTarget(){
    	return m_masterTalon.getClosedLoopError(0) < 1;//TODO: Check
    }
    
    public void updateStatus(){
    	SmartDashboard.putNumber("Arm Talon Speed", m_masterTalon.getSelectedSensorPosition(0));
    	SmartDashboard.putNumber("Arm Setpoint", m_masterTalon.getClosedLoopTarget(0));
    	SmartDashboard.putNumber("Arm Error", m_masterTalon.getClosedLoopError(0));
    	SmartDashboard.putBoolean("Arm on Target", isOnTarget());
    }
}

