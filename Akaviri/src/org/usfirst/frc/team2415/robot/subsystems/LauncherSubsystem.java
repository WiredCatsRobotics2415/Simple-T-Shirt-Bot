package org.usfirst.frc.team2415.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
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
	
	private Solenoid[] fireSolenoids;
	
	public static boolean firing = false;
	
	public LauncherSubsystem(){
		fireSolenoids = new Solenoid[4];
		
		for(int i=0; i<4; i++){
			fireSolenoids[i] = new Solenoid(RobotMap.PCM_ID, RobotMap.FIRE_SOLENOIDS[i]);
		}
	}
	
    public void initDefaultCommand() {
    	this.setDefaultCommand(new RestingCommand());
    }
    
    public void fire(){
    	for(int i=0; i<fireSolenoids.length; i++){
    		fireSolenoids[i].set(true);
    	}
    	firing = true;
    }
    
    public void fireIndividual(int nipples){
    	fireSolenoids[nipples].set(true);
    }
    
    public void close(){
    	for(int i=0; i<fireSolenoids.length; i++){
    		fireSolenoids[i].set(false);
    	}
    	firing = false;
    }
    
    public void closeIndividual(int nipples){
    	fireSolenoids[nipples].set(false);
    }
    
}

