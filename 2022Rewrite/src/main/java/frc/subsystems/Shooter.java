package frc.subsystems;

import frc.robot.RobotMap;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.Solenoid;

public class Shooter {
    Solenoid topLeft, topRight, bottomLeft, bottomRight;
    Solenoid[] solenoids = {topLeft, topRight, bottomLeft, bottomRight};

    public Shooter() {
        topLeft = new Solenoid(PneumaticsModuleType.CTREPCM, RobotMap.FIRE_SOLENOID_1);
        topRight = new Solenoid(PneumaticsModuleType.CTREPCM, RobotMap.FIRE_SOLENOID_2);
        bottomLeft = new Solenoid(PneumaticsModuleType.CTREPCM, RobotMap.FIRE_SOLENOID_3);
        bottomRight = new Solenoid(PneumaticsModuleType.CTREPCM, RobotMap.FIRE_SOLENOID_4);
    }

    public void fireAll() {
        for (Solenoid solenoid : solenoids){
            solenoid.set(true);
        }
    }
    
    public void closeAll() {
        for (Solenoid solenoid : solenoids){
            solenoid.set(false);
        }
    }
    
    public void fire(int shooter) {
        solenoids[shooter].set(true);
    }
    
    p
    
}
