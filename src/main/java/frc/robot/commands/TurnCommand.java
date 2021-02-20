// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;

public class TurnCommand extends CommandBase {
  double desiredAngle;
  double current;

  /** Creates a new TurnCommand. */
  public TurnCommand(double angle) {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(Robot.drivingSubsystem);
    desiredAngle = angle;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    Robot.drivingSubsystem.ahrs.zeroYaw();
  }
  
  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    current = Math.round(Robot.drivingSubsystem.ahrs.getAngle());
    System.out.println("angle: " + current);
  }
  
  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    System.out.println("ended");
  }
  
  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    if (current != desiredAngle) {
      Robot.drivingSubsystem.oDrive(0, (int) Math.signum(desiredAngle) * 0.8);
      return false;
    } else {
      Robot.drivingSubsystem.oDrive(0, 0);
      System.out.println("isFinished");
      return true;
    }
  }
}
