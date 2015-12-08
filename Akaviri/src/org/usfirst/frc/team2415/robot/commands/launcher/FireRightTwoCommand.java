package org.usfirst.frc.team2415.robot.commands.launcher;

import org.usfirst.frc.team2415.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class FireRightTwoCommand extends Command {
	
	private long startTime;
	private boolean isDone = false;
	
    public FireRightTwoCommand() {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.launcherSubsystem);
        startTime = System.currentTimeMillis();
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.launcherSubsystem.fire(1);
    	Robot.launcherSubsystem.fire(2);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if((System.currentTimeMillis() - startTime)/1000.0 >= 0.5) isDone = true;
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return isDone;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.launcherSubsystem.close(1);
    	Robot.launcherSubsystem.close(2);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	Robot.launcherSubsystem.close(1);
    	Robot.launcherSubsystem.close(2);
    }
}
