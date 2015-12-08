package org.usfirst.frc.team2415.robot.commands.launcher;

import org.usfirst.frc.team2415.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class FireBottomRightCannon extends Command {

    public FireBottomRightCannon() {
        requires(Robot.launcherSubsystem);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.launcherSubsystem.fireIndividual(2);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.launcherSubsystem.closeIndividual(2);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	Robot.launcherSubsystem.closeIndividual(2);
    }
}
