/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import edu.wpi.first.wpilibj.Solenoid;

public class ShirtCanon extends Subsystem {
  public final static long shotDelay = 500;
  public final static long shotDuration = 200; 

  Solenoid[] shooters;
  long[] shotTimes;
  boolean[] shooterStatus;

  public ShirtCanon() {
    shooters = new Solenoid[RobotMap.SOLENOID_IDS.length];
    shotTimes = new long[shooters.length];
    shooterStatus = new boolean[shooters.length];
    for(int i = 0; i < shooters.length; i++) {
      shooters[i] = new Solenoid(RobotMap.SOLENOID_IDS[i]);
    }
  }

  public void update() {
    for(int i = 0; i < shooters.length; i++) {
      if(shooterStatus[i] == true) {
        if(System.currentTimeMillis()- shotTimes[i] > shotDuration) {
          shooters[i].set(false);
          shooterStatus[i] = false;
        }
      }
    }
  }

  public void shootIndividual(int index) {
    if(index >= shooters.length) return;
    if(System.currentTimeMillis() - shotDelay < shotTimes[index]) return;
    shooters[index].set(true);
    shotTimes[index] = System.currentTimeMillis();
    shooterStatus[index] = true;
  }

  public void shootAll() {
    for(int i = 0; i < shooters.length; i++) {
      shootIndividual(i);
    }
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
