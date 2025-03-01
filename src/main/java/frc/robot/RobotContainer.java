// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.subsystems.SwerveSubsystem;
import edu.wpi.first.math.MathUtil;
import edu.wpi.first.wpilibj.Filesystem;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.commands.TeleopDrive;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import java.io.File;

public class RobotContainer {

  // xbox Controller
  XboxController driverController = new XboxController(Constants.ControllerConstants.DRIVER_CONTROLLER_PORT);
  JoystickButton driverLeftBumper = new JoystickButton(driverController, Constants.ControllerConstants.LEFT_BUMPER);
  JoystickButton driverRightBumper = new JoystickButton(driverController, Constants.ControllerConstants.RIGHT_BUMPER);
  
  private final SwerveSubsystem swerveSubsystem;
  
  public RobotContainer() {
    swerveSubsystem = new SwerveSubsystem(
        new File(Filesystem.getDeployDirectory(), Constants.SwerveConstants.SWERVE_DIRECTORY)
    );
    configureBindings();
}

  private void configureBindings() {
    // drive commands
    TeleopDrive teleopDrive = new TeleopDrive(
    swerveSubsystem,
    () -> MathUtil.applyDeadband(driverController.getLeftY(), Constants.OperatorConstants.LEFT_Y_DEADBAND),
    () -> MathUtil.applyDeadband(driverController.getLeftX(), Constants.OperatorConstants.LEFT_X_DEADBAND),
    () -> MathUtil.applyDeadband(-driverController.getRightX(), Constants.OperatorConstants.ROTATION_DEADBAND),
    () -> Constants.DriveConstants.FIELD_RELATIVE_DRIVE_MODE
);

    swerveSubsystem.setDefaultCommand(teleopDrive);
  }

  public Command getAutoCommand() {
    return new InstantCommand();
  }
}
