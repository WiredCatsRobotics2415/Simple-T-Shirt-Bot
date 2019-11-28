/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;

public class ShirtCannon extends Subsystem {
  public final static long shotDelay = 500;
  public final static long shotDuration = 200; 

  private DoubleSolenoid rightShooters, leftShooters;
  private long rightLastFireTime, leftLastFireTime;
  private boolean rightTopQueue, rightBottomQueue, leftTopQueue, leftBottomQueue;

  public ShirtCannon() {
    this.rightShooters = new DoubleSolenoid(RobotMap.RIGHT_SOLENOID_TOP, RobotMap.RIGHT_SOLENOID_BOTTOM);
    this.leftShooters = new DoubleSolenoid(RobotMap.LEFT_SOLENOID_TOP, RobotMap.LEFT_SOLENOID_BOTTOM);
    this.rightShooters.set(DoubleSolenoid.Value.kOff);
    this.leftShooters.set(DoubleSolenoid.Value.kOff);

    this.rightLastFireTime = System.currentTimeMillis();
    this.leftLastFireTime = System.currentTimeMillis();

    this.rightTopQueue = false;
    this.rightBottomQueue = false;
    this.leftTopQueue = false;
    this.leftBottomQueue = false;
  }

  public void update() {
    if(rightShooters.get() != DoubleSolenoid.Value.kOff) {
      if(System.currentTimeMillis() - shotDuration > rightLastFireTime) {
        if(rightTopQueue) {
          rightShooters.set(DoubleSolenoid.Value.kForward);
          rightTopQueue = false;
          rightLastFireTime = System.currentTimeMillis();
        } else if(rightBottomQueue) {
          rightShooters.set(DoubleSolenoid.Value.kReverse);
          rightBottomQueue = false;
          rightLastFireTime = System.currentTimeMillis();
        } else {
          rightShooters.set(DoubleSolenoid.Value.kOff);
        }
      }
    }
    if(leftShooters.get() != DoubleSolenoid.Value.kOff) {
      if(System.currentTimeMillis() - shotDuration > leftLastFireTime) {
        if(leftTopQueue) {
          leftShooters.set(DoubleSolenoid.Value.kForward);
          leftTopQueue = false;
          leftLastFireTime = System.currentTimeMillis();
        } else if(leftBottomQueue) {
          leftShooters.set(DoubleSolenoid.Value.kReverse);
          leftBottomQueue = false;
          leftLastFireTime = System.currentTimeMillis();
        } else {
          leftShooters.set(DoubleSolenoid.Value.kOff);
        }
      }
    }
  }

  public void shootRightTop() {
    if(rightShooters.get() == DoubleSolenoid.Value.kReverse) {
      rightTopQueue = true;
    } else if(System.currentTimeMillis() - shotDelay > rightLastFireTime) {
      rightShooters.set(DoubleSolenoid.Value.kForward);
      rightLastFireTime = System.currentTimeMillis();
    }
  }

  public void shootRightBottom() {
    if(rightShooters.get() == DoubleSolenoid.Value.kForward) {
      rightBottomQueue = true;
    } else if(System.currentTimeMillis() - shotDelay > rightLastFireTime) {
      rightShooters.set(DoubleSolenoid.Value.kReverse);
      rightLastFireTime = System.currentTimeMillis();
    }
  }

  public void shootLeftTop() {
    if(leftShooters.get() == DoubleSolenoid.Value.kReverse) {
      leftTopQueue = true;
    } else if(System.currentTimeMillis() - shotDelay > leftLastFireTime) {
      leftShooters.set(DoubleSolenoid.Value.kForward);
      leftLastFireTime = System.currentTimeMillis();
    }
  }

  public void shootLeftBottom() {
    if(leftShooters.get() == DoubleSolenoid.Value.kForward) {
      leftBottomQueue = true;
    } else if(System.currentTimeMillis() - shotDelay > leftLastFireTime) {
      leftShooters.set(DoubleSolenoid.Value.kReverse);
      leftLastFireTime = System.currentTimeMillis();
    }
  }

  public void shootAll() {
    shootRightTop();
    shootRightBottom();
    shootLeftTop();
    shootLeftBottom();
  }

  public void printAll() {
    System.out.println(""+rightShooters.get()+leftShooters.get());
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
