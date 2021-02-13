// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class NolanIntakeSubsystem extends SubsystemBase {
  public WPI_TalonSRX intakeMotor = new WPI_TalonSRX(Constants.intakeMotor);
  /** Creates a new NolanIntakeSubsystem. */
  public NolanIntakeSubsystem() {}

  public void DriveIntakeMotor(double speed) {
    intakeMotor.set(speed);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
