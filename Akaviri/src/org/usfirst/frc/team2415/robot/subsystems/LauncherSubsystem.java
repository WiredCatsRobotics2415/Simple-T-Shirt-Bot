package org.usfirst.frc.team2415.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.Solenoid;

import org.usfirst.frc.team2415.robot.RobotMap;
import org.usfirst.frc.team2415.robot.commands.launcher.RestingCommand;

import java.lang.Enum;

import java.util.Enumeration;
import java.util.Vector;
/**
 *
 */
public class LauncherSubsystem extends Subsystem {
	
	public enum Solenoids {	TOP_LEFT_FIRE, TOP_RIGHT_FIRE, BOT_LEFT_FIRE,
							BOT_RIGHT_FIRE, ALL_FIRE
	}
	
	private int numOfSolenoids = RobotMap.FIRE_SOLENOIDS.length;
	private Solenoid[] solenoids;
	public boolean firing;
	public int[] fireCount = {0,0,0,0};
	
	public LauncherSubsystem(){
		solenoids = new Solenoid[numOfSolenoids];
		
		for(int i=0; i<solenoids.length; i++){
			solenoids[i] = new Solenoid(RobotMap.PCM_ID, RobotMap.FIRE_SOLENOIDS[i]);
		}
		closeAll();
	}
	
    public void initDefaultCommand() {
    	this.setDefaultCommand(new RestingCommand());
    }
    
    public void fireAll(){
    	for(int i=0; i<solenoids.length; i++){
    		solenoids[i].set(true);
    	}
    	firing = true;
    }
    
    public void fire(int barrelID){
    	solenoids[barrelID].set(true);
    	firing = true;
    }
    
    public void closeAll(){
    	for(int i=0; i<solenoids.length; i++){
    		solenoids[i].set(false);
    	}
    	firing = false;
    }
    
    public void close(int barrelID){
    	solenoids[barrelID].set(false);
    	firing = false;
    }
    
    public void updateStatus(){
    	SmartDashboard.putNumber("Barrel 1", fireCount[0]);
    	SmartDashboard.putNumber("Barrel 2", fireCount[1]);
    	SmartDashboard.putNumber("Barrel 3", fireCount[2]);
    	SmartDashboard.putNumber("Barrel 4", fireCount[3]);
    }
    
}

