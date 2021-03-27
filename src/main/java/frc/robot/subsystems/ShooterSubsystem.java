// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class ShooterSubsystem extends SubsystemBase {
  /** Creates a new Shooter Subsystem. */

  public WPI_TalonSRX shooterMotor1 = new WPI_TalonSRX(Constants.shooterMotor1);
  public WPI_TalonSRX shooterMotor2 = new WPI_TalonSRX(Constants.shooterMotor2);
  public WPI_TalonSRX shooterMotor3 = new WPI_TalonSRX(Constants.shooterMotor3);


  public ShooterSubsystem() {
  }

  public void DriveShooterMotor1(double speed) {
    shooterMotor1.set(-speed / 1.5);
    shooterMotor2.set(speed);
    shooterMotor3.set(-speed / 1.5);
  }

  public void DriveShooterMotor2(double speed) {
    shooterMotor2.set(speed);
  }

  public void DriveShooterMotor3(double speed) {
    shooterMotor3.set(speed);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
