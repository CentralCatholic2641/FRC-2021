// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;
import frc.robot.Constants;

public class AutoDriveCommand extends CommandBase {

  double lOutput = 0;
  double lI = 0;
  double lDistanceTravelled = 0;
  double lError = 0;
  double lErrorPrevious = 0;
  double lD = 0;
  double setpoint = 0;

  /** Creates a new AutoCommand. */
  public AutoDriveCommand(double distance) {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(Robot.drivingSubsystem);
    setpoint = distance;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    Robot.drivingSubsystem.leftEncoder.setSelectedSensorPosition(0);
    Robot.drivingSubsystem.ahrs.zeroYaw();
    SmartDashboard.delete("error");
    SmartDashboard.delete("output");
    SmartDashboard.delete("angle");
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    SmartDashboard.putNumber("axis", Math.abs(Robot.drivingSubsystem.ahrs.getAngle()));
    lDistanceTravelled = ((Robot.drivingSubsystem.leftEncoder.getSelectedSensorPosition() / Constants.oneRotation)
        * (Math.PI * Constants.wheelDiameter));
    lError = setpoint - lDistanceTravelled;
    lI += (lError * 1);
    lD = (lError - lErrorPrevious) / .02;
    lOutput = (Constants.kP * lError) + (Constants.kI * lI) + (Constants.kD * lD);
    lErrorPrevious = lError;
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    SmartDashboard.putNumber("error", lError);
    SmartDashboard.putNumber("output", lOutput / 10);
    SmartDashboard.putNumber("angle", -Robot.drivingSubsystem.ahrs.getAngle() * Constants.driftCompensation);

    System.out.println("Error: " + lError);
    // System.out.println("Output: " + lOutput / 10);
    // System.out.println("Angle: " + -Robot.drivingSubsystem.ahrs.getAngle() * Constants.driftCompensation);
    // if (Math.abs(lError) > 4) {
      Robot.drivingSubsystem.oDrive(-lOutput / 10, -Robot.drivingSubsystem.ahrs.getAngle() * Constants.driftCompensation);
      return false;
    // } else {
    //   Robot.drivingSubsystem.tDrive(0, 0);
    //   return true;
    // }
  }
}
