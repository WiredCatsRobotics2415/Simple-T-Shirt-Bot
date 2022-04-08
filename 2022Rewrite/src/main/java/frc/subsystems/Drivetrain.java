package frc.subsystems;

import frc.robot.RobotMap;

import edu.wpi.first.wpilibj.motorcontrol.Talon;

public class Drivetrain {
    Talon leftTalon, rightTalon;

    public Drivetrain() {
        leftTalon = new Talon(RobotMap.LEFT_TALONS);
        rightTalon = new Talon(RobotMap.RIGHT_TALONS); 
    }
    
    public void drive(double throttle, double turn) {
        leftTalon.set(throttle-turn);
        rightTalon.set(throttle+turn);
    }

    


    
}
