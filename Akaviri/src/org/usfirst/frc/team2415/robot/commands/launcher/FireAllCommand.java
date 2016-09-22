package org.usfirst.frc.team2415.robot.commands.launcher;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team2415.robot.Robot;
import org.usfirst.frc.team2415.robot.subsystems.LauncherSubsystem.Solenoids;

/**
 *
 */
public class FireAllCommand extends Command {
	
	long startTime;
	boolean isDone = false;
	
    public FireAllCommand() {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.launcherSubsystem);
        startTime = System.currentTimeMillis();
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	if(Robot.launcherSubsystem.firing) Robot.launcherSubsystem.closeAll();
    	else Robot.launcherSubsystem.fireAll();
    	Robot.launcherSubsystem.fireCount[0]++;
    	Robot.launcherSubsystem.fireCount[1]++;
    	Robot.launcherSubsystem.fireCount[2]++;
    	Robot.launcherSubsystem.fireCount[3]++;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	//if((System.currentTimeMillis() - startTime) / 1000.0 >= 1.5) isDone = true;
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.launcherSubsystem.closeAll();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	Robot.launcherSubsystem.closeAll();
    }
}
