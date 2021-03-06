
package org.usfirst.frc.team2415.robot;

import org.usfirst.frc.team2415.robot.subsystems.*;
import org.usfirst.frc.team2415.robot.commands.launcher.*;
import org.usfirst.frc.team2415.robot.subsystems.LauncherSubsystem.Solenoids;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.*;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

	public static OI oi;
	
	public static DriveSubsystem driveSubystem;
	public static LauncherSubsystem launcherSubsystem;
	
	public static WiredCatGamepad gamepad;
	
	private Compressor compressor;

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
		oi = new OI();
		
		gamepad = new WiredCatGamepad(0);
		
		compressor = new Compressor(RobotMap.PCM_ID);
		
		driveSubystem = new DriveSubsystem();
		launcherSubsystem = new LauncherSubsystem();
		
		gamepad.leftBumper.whenActive(new FireAllCommand());
		gamepad.x_button.whenActive(new FireBarrel1Command());
		gamepad.b_button.whenActive(new FireBarrel2Command());
		gamepad.a_button.whenActive(new FireBarrel4Command());
		gamepad.y_button.whenActive(new FireBarrel3Command());
		gamepad.back_button.whenActive(new FireBarrels1And2Command());
		gamepad.start_button.whenActive(new FireBarrels3And4Command());
		gamepad.leftBumper.whenInactive(new CancelCommand());
		gamepad.x_button.whenInactive(new CancelCommand());
		gamepad.b_button.whenInactive(new CancelCommand());
		gamepad.a_button.whenInactive(new CancelCommand());
		gamepad.y_button.whenInactive(new CancelCommand());
		gamepad.back_button.whenInactive(new CancelCommand());
		gamepad.start_button.whenInactive(new CancelCommand());
		
		//Displays which commands are being run
		SmartDashboard.putData(Scheduler.getInstance());
		
		//Displays the status of the Subsystems
		SmartDashboard.putData(launcherSubsystem);
		
		//Speed Gauges
		SmartDashboard.putNumber("Left Speed", Robot.driveSubystem.getLeftTal());
		SmartDashboard.putNumber("Right Speed", -Robot.driveSubystem.getLeftTal());
    }
	
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

    public void autonomousInit() {
        // schedule the autonomous command (example)
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }

    public void teleopInit() {
		// This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to 
        // continue until interrupted by another command, remove
        // this line or comment it out.
    }

    /**
     * This function is called when the disabled button is hit.
     * You can use it to reset subsystems before shutting down.
     */
    public void disabledInit(){

    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
        LiveWindow.run();
    }
}
