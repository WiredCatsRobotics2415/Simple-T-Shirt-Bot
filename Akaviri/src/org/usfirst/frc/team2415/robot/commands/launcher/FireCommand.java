package org.usfirst.frc.team2415.robot.commands.launcher;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team2415.robot.Robot;
import org.usfirst.frc.team2415.robot.subsystems.LauncherSubsystem.Solenoids;

/**
 *
 */
public class FireCommand extends Command {
	
	long startTime;
	boolean isDone = false;
	
    public FireCommand() {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.launcherSubsystem);
        startTime = System.currentTimeMillis();
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	if(Robot.launcherSubsystem.firing) Robot.launcherSubsystem.close();
    	else Robot.launcherSubsystem.fire();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if((System.currentTimeMillis() - startTime) / 1000.0 >= 0.25) isDone = true;
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return isDone;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.launcherSubsystem.close();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	Robot.launcherSubsystem.close();
    }
}
