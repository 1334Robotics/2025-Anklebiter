// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.math.geometry.Translation2d;
import frc.robot.Constants;
import frc.robot.subsystems.SwerveSubsystem;
import java.util.function.BooleanSupplier;
import java.util.function.DoubleSupplier;
import swervelib.SwerveController;

public class TeleopDrive extends Command {

  private final SwerveSubsystem swerve;
  private final DoubleSupplier vX;
  private final DoubleSupplier vY;
  private final DoubleSupplier omega;
  private final BooleanSupplier driveMode;
  private final SwerveController controller;

  // new teleopdrive.
  public TeleopDrive(SwerveSubsystem swerve, DoubleSupplier vX, DoubleSupplier vY, DoubleSupplier omega,
                     BooleanSupplier driveMode) {
    this.swerve = swerve;
    this.vX = vX;
    this.vY = vY;
    this.omega = omega;
    this.driveMode = driveMode;
    this.controller = swerve.getSwerveController();
    
    addRequirements(swerve);
  }

  @Override
  public void initialize() {
  }

  @Override
  public void execute() {
    double xVelocity = Math.pow(vX.getAsDouble(), Constants.DriveConstants.JOYSTICK_EXPONENT);
    double yVelocity = Math.pow(vY.getAsDouble(), Constants.DriveConstants.JOYSTICK_EXPONENT);
    double angVelocity = Math.pow(omega.getAsDouble(), Constants.DriveConstants.JOYSTICK_EXPONENT);


    swerve.drive(
        new Translation2d(xVelocity * swerve.maximumSpeed, yVelocity * swerve.maximumSpeed),
        angVelocity * controller.config.maxAngularVelocity,
        driveMode.getAsBoolean() 
    );
  }

  @Override
  public void end(boolean interrupted) {
  }

  @Override
  public boolean isFinished() {
    return false; 
  }
}
