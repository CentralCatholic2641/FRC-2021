// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;

public class ShooterCommand extends CommandBase {
  /** Creates a new ShooterCommand. */
  //This command takes in an integer value which will shoot motor 1 or motor 2
  int motorNumber;


  public ShooterCommand(int whichShooterMotor) {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(Robot.shooterSubsystem);
    motorNumber = whichShooterMotor;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if (motorNumber == 1){
      Robot.shooterSubsystem.DriveShooterMotor1(-0.5);
    } else if (motorNumber == 2) {
      Robot.shooterSubsystem.DriveShooterMotor2(1);
    } else {
      Robot.shooterSubsystem.DriveShooterMotor3(-1);

    }
    
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    Robot.shooterSubsystem.DriveShooterMotor1(0);
    Robot.shooterSubsystem.DriveShooterMotor2(0);
    Robot.shooterSubsystem.DriveShooterMotor3(0);

  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
