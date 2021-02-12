// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;
import frc.robot.Constants;

public class AutoCommand extends CommandBase {

  double lOutput = 0;
  double rOutput = 0;
  double lI = 0;
  double rI = 0;
  double lDistanceTravelled = 0;
  double rDistanceTravelled = 0;
  double lError = 0;
  double rError = 0;
  double lErrorPrevious = 0;
  double rErrorPrevious = 0;
  double lD = 0;
  double rD = 0;
  double setpoint = 0;

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
    lError = setpoint - lDistanceTravelled;
    System.out.println("lError: " + lError);
    lI += (lError * 0.95);
    lD = (lError - lErrorPrevious) / .02;
    lOutput = (Constants.kP * lError) + (Constants.kI * lI) + (Constants.kD * lD);
    // lOutput = (Constants.kP * lError) + (Constants.kI * lI);
    lErrorPrevious = lError;

    // RIGHT
    // rDistanceTravelled = ((Robot.drivingSubsystem.rightEncoder.getSelectedSensorPosition() / Constants.oneRotation)
    //     * (Math.PI * Constants.wheelDiameter));
    // System.out.println("rightEncoder: " + Robot.drivingSubsystem.rightEncoder.getSelectedSensorPosition());
    // rError = setpoint - rDistanceTravelled;
    // rErrorI += rError;
    // rErrorI *= 0.95;
    // rD = (rError - rErrorPrevious) / .02;
    // rOutput = (Constants.kP * rError) + (Constants.kI * rErrorI) + (Constants.kD * rD);
    // rErrorPrevious = rError;
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    System.out.println("Left output: " + lOutput / 1.15);
    if (Math.abs(lError) > 0.1) {
      // double newlOutput = lOutput / 10;
      // double newrOutput = rOutput / 10;
      // Robot.drivingSubsystem.tDrive(-(newlOutput), -(newrOutput));
      Robot.drivingSubsystem.oDrive(-lOutput / 1.15, 0);
      return false;
    } else {
      Robot.drivingSubsystem.tDrive(0, 0);
      return true;
    }
  }
}
