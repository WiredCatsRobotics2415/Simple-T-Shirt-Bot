/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.ControlMode;

import frc.robot.*;

public class Drivetrain extends Subsystem {
  public static final double DEADBAND = 0.05;

  private WPI_TalonSRX leftTalon, rightTalon;

  public Drivetrain() {
    this.leftTalon = new WPI_TalonSRX(RobotMap.LEFT_TALON);
    this.rightTalon = new WPI_TalonSRX(RobotMap.RIGHT_TALON);
  }

  public void drive(double throttle, double turn) {
    if(Math.abs(throttle) < DEADBAND) {
      throttle = 0;
    }
    if(Math.abs(turn) < DEADBAND) {
      turn = 0;
    }
    this.leftTalon.set(ControlMode.PercentOutput, throttle+turn);
    this.rightTalon.set(ControlMode.PercentOutput, throttle-turn);
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
