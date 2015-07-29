package org.usfirst.frc.team2415.robot;
/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    public static final int LEFT_TALONS = 0;
    public static final int RIGHT_TALONS = 9;
    
    public static final int ELEVATION_VICTOR = 1;
    
    public static final int[] ACCUMULATE_SOLENOIDE_1 = {0,0};
    public static final int[] ACCUMULATE_SOLENOIDE_2 = {0,0};
    public static final int[] ACCUMULATE_SOLENOIDE_3 = {0,0};
    public static final int[] ACCUMULATE_SOLENOIDE_4 = {0,0};
    
    public static final int[] FIRE_SOLENOIDE_1 = {0,0};
    public static final int[] FIRE_SOLENOIDE_2 = {0,0};
    public static final int[] FIRE_SOLENOIDE_3 = {0,0};
    public static final int[] FIRE_SOLENOIDE_4 = {0,0};
    
    public static final int[][] ACCUMULATE_SOLENOIDS = {ACCUMULATE_SOLENOIDE_1,
											    		ACCUMULATE_SOLENOIDE_2,
											    		ACCUMULATE_SOLENOIDE_3,
											    		ACCUMULATE_SOLENOIDE_4};
    
    public static final int[][] FIRE_SOLENOIDS = {FIRE_SOLENOIDE_1,
										    	  FIRE_SOLENOIDE_2,
										    	  FIRE_SOLENOIDE_3,
										    	  FIRE_SOLENOIDE_4};
    
    public static final int PCM_ID = 20;
}
