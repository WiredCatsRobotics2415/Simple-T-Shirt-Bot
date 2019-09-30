/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;

import edu.wpi.first.wpilibj.Talon;

import frc.robot.*;

public class Drivetrain extends Subsystem {
  public static final double DEADBAND = 0.05;

  private Talon leftTalon, rightTalon;

  public Drivetrain() {
    this.leftTalon = new Talon(RobotMap.LEFT_TALON);
    this.rightTalon = new Talon(RobotMap.RIGHT_TALON);
  }

  public void drive(double throttle, double turn) {
    if(Math.abs(throttle) < DEADBAND) {
      throttle = 0;
    }
    if(Math.abs(turn) < DEADBAND) {
      turn = 0;
    }

    this.leftTalon.set(throttle+turn);
    this.rightTalon.set(throttle-turn);
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
