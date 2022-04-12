package frc.subsystems;

import frc.robot.RobotMap;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.Solenoid;

public class Shooter {
    Solenoid[] solenoids;

    public Shooter() {
        solenoids = new Solenoid[4];
        solenoids[0] = new Solenoid(PneumaticsModuleType.CTREPCM, RobotMap.FIRE_SOLENOID_1);
        solenoids[1] = new Solenoid(PneumaticsModuleType.CTREPCM, RobotMap.FIRE_SOLENOID_2);
        solenoids[2] = new Solenoid(PneumaticsModuleType.CTREPCM, RobotMap.FIRE_SOLENOID_3);
        solenoids[3] = new Solenoid(PneumaticsModuleType.CTREPCM, RobotMap.FIRE_SOLENOID_4);
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
    
    public void close(int shooter) {
        solenoids[shooter].set(false);
    }
    
}
