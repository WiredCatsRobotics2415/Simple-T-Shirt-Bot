package org.usfirst.frc.team2415.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Solenoid;

import org.usfirst.frc.team2415.robot.RobotMap;
import org.usfirst.frc.team2415.robot.commands.launcher.RestingCommand;

import java.util.HashMap;
/**
 *
 */
public class LauncherSubsystem extends Subsystem {
	
	private Solenoid[][] aSoles, fSoles;
	
	public LauncherSubsystem(){
		aSoles = new Solenoid[4][2];
		fSoles = new Solenoid[4][2];
		
		for(int i=0;i<4;i++){
			for(int j=0;j<2;j++){
				aSoles[i][j] =  new Solenoid(RobotMap.ACCUMULATE_SOLENOIDS[i][j]);
			}
			aSoles[i][0].set(true);
			aSoles[i][1].set(false);
		}
		
		for(int i=0;i<4;i++){
			for(int j=0;j<2;j++){
				fSoles[i][j] =  new Solenoid(RobotMap.FIRE_SOLENOIDS[i][j]);
			}
			fSoles[i][0].set(true);
			fSoles[i][1].set(false);
		}
	}
	
    public void initDefaultCommand() {
    	setDefaultCommand(new RestingCommand());
    }
    
    public void accumulateOnAll(){
    	for(int i=0;i<4;i++){
    		aSoles[i][0].set(true);
    		aSoles[i][1].set(false);
    	}
    }
    
    public void accumulateOffAll(){
    	for(int i=0;i<4;i++){
    		aSoles[i][0].set(false);
    		aSoles[i][1].set(true);
    	}
    } 
    
    public void accumulateOn(int soleNumber){
    	aSoles[soleNumber][0].set(true);
    	aSoles[soleNumber][1].set(false);
    }
    
    public void accumulateOff(int soleNumber){
    	aSoles[soleNumber][0].set(false);
    	aSoles[soleNumber][1].set(true);
    }
    
    public void fireOnAll(){
    	for(int i=0;i<4;i++){
    		fSoles[i][0].set(true);
    		fSoles[i][1].set(false);
    	}
    }
    
    public void fireOffAll(){
    	for(int i=0;i<4;i++){
    		fSoles[i][0].set(false);
    		fSoles[i][1].set(true);
    	}
    } 
    
    public void fireOn(int soleNumber){
    	fSoles[soleNumber][0].set(true);
    	fSoles[soleNumber][1].set(false);
    }
    
    public void fireOff(int soleNumber){
    	fSoles[soleNumber][0].set(false);
    	fSoles[soleNumber][1].set(true);
    }
}

