// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class ShooterSubsystem extends SubsystemBase {
  /** Creates a new Shooter Subsystem. */

  public WPI_TalonSRX beltMotor = new WPI_TalonSRX(Constants.beltMotor);
  public WPI_TalonSRX shooterMotor = new WPI_TalonSRX(Constants.shooterMotor);
  public WPI_TalonSRX intakeMotor = new WPI_TalonSRX(Constants.intakeMotor);

  public ShooterSubsystem() {
  }

  public void BeltAndIntake(double speed) {
    beltMotor.set(Math.signum(speed) * -0.5);
    intakeMotor.set(Math.signum(speed) * -0.5);
  }

  public void BeltAndShooter(double speed) {
    beltMotor.set(Math.signum(speed) * -0.5);
    shooterMotor.set(speed);
  }

  public void All(double speed) {
    beltMotor.set(Math.signum(speed) * -0.5);
    shooterMotor.set(speed);
    intakeMotor.set(Math.signum(speed) * -0.5);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
