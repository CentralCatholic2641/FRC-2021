// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;
import frc.robot.Constants;

public class AutoCommand extends CommandBase {

  double lOutput;
  double rOutput;
  double lErrorI = 0;
  double rErrorI = 0;
  double lDistanceTravelled;
  double rDistanceTravelled;
  double lError;
  double rError;
  double lErrorPrevious = 0;
  double rErrorPrevious = 0;
  double lD;
  double rD;
  double setpoint;

  /** Creates a new AutoCommand. */
  public AutoCommand(double distance) {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(Robot.drivingSubsystem);
    setpoint = distance;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    Robot.drivingSubsystem.leftEncoder.setSelectedSensorPosition(0);
    Robot.drivingSubsystem.rightEncoder.setSelectedSensorPosition(0);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    // LEFT
    lDistanceTravelled = -((Robot.drivingSubsystem.leftEncoder.getSelectedSensorPosition() / Constants.oneRotation)
        * (Math.PI * Constants.wheelDiameter));
    System.out.println("leftEncoder: " + Robot.drivingSubsystem.leftEncoder.getSelectedSensorPosition());
    lError = setpoint - lDistanceTravelled;
    lErrorI += lError;
    lErrorI *= 0.95;
    lD = (lError - lErrorPrevious) / .02;
    lOutput = (Constants.kP * lError) + (Constants.kI * lErrorI) + (Constants.kD * lD);

    // RIGHT
    rDistanceTravelled = ((Robot.drivingSubsystem.rightEncoder.getSelectedSensorPosition() / Constants.oneRotation)
        * (Math.PI * Constants.wheelDiameter));
    System.out.println("rightEncoder: " + Robot.drivingSubsystem.rightEncoder.getSelectedSensorPosition());
    rError = setpoint - rDistanceTravelled;
    rErrorI += rError;
    rErrorI *= 0.95;
    rD = (rError - rErrorPrevious) / .02;
    rOutput = (Constants.kP * rError) + (Constants.kI * rErrorI) + (Constants.kD * rD);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    System.out.println(lOutput);
    if (lOutput > 0.01 || rOutput > 0.01) {
      double newlOutput = lOutput / 10;
      double newrOutput = rOutput / 10;
      System.out.println("Left output: " + lOutput + ", Right output: " + rOutput);
      Robot.drivingSubsystem.tDrive(-(newlOutput), -(newrOutput));
      return false;
    } else {
      Robot.drivingSubsystem.tDrive(0, 0);
      return true;
    }
  }
}
