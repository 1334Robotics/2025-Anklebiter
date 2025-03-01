// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.math.geometry.Translation3d;
import edu.wpi.first.math.util.Units;
import swervelib.math.Matter;

/** Add your docs here. */
public class Constants {

    // physical properties
    public static final double ROBOT_MASS = (45) * 0.453592; 
    public static final Matter CHASSIS = new Matter(new Translation3d(0, 0, Units.inchesToMeters(8)), ROBOT_MASS);

    public static final double LOOP_TIME = 0.13; 

    public static class OperatorConstants {

        public static final double LEFT_X_DEADBAND = 0.1;
        public static final double LEFT_Y_DEADBAND = 0.1;
        public static final double ROTATION_DEADBAND = 0.3;
    }

    public static class ControllerConstants {
        public static final int DRIVER_CONTROLLER_PORT = 0;
        public static final int LEFT_BUMPER = 5;
        public static final int RIGHT_BUMPER = 6;
    }

    public static class SwerveConstants {
        public static final double LOOP_TIME = 0.13;
        public static final double MAXIMUM_SPEED = Units.feetToMeters(14.5);
        public static final String SWERVE_DIRECTORY = "swerve";
        public static final double CHASSIS_HEIGHT_INCHES = 8.0;
    }
    
    public static class DriveConstants {
        public static final int JOYSTICK_EXPONENT = 3;
        public static final boolean FIELD_RELATIVE_DRIVE_MODE = true;
    }
    
    public static double applyDeadband(double value, double deadband) {
    return MathUtil.applyDeadband(value, deadband);
    }
    
}
