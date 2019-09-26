/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.Compressor;

import frc.subsystems.*;

public class Robot extends TimedRobot {
  private static XboxController gamepad = new XboxController(0);
  private static Compressor compressor = new Compressor(RobotMap.PCM_ID);
  
  public static Drivetrain drivetrain = new Drivetrain();
  public static ShirtCannon cannon = new ShirtCannon();

  @Override
  public void robotInit() {
    System.out.println("test");
    drivetrain.drive(0,0);
    compressor.start();
  }

  @Override
  public void robotPeriodic() {
  }

  @Override
  public void autonomousInit() {
  }

  /**
   * This function is called periodically during autonomous.
   */
  @Override
  public void autonomousPeriodic() {
  }

  /**
   * This function is called periodically during operator control.
   */
  @Override
  public void teleopPeriodic() {
    drivetrain.drive(gamepad.getRawAxis(1), gamepad.getRawAxis(2));
    if(gamepad.getBumper(Hand.kRight)) {
      cannon.shootAll();
    } else if(gamepad.getAButton()) {
      cannon.shootIndividual(0);
    } else if(gamepad.getBButton()) {
      cannon.shootIndividual(1);
    } else if(gamepad.getXButton()) {
      cannon.shootIndividual(2);
    } else if(gamepad.getYButton()) {
      cannon.shootIndividual(3);
    }
    cannon.update();
  }

  /**
   * This function is called periodically during test mode.
   */
  @Override
  public void testPeriodic() {
  }
}
