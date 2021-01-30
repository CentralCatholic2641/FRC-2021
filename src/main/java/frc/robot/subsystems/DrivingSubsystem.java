// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

import frc.robot.commands.DrivingCommand;

public class DrivingSubsystem extends SubsystemBase {
  // set up motor

  public WPI_TalonSRX leftmotor1 = new WPI_TalonSRX(Constants.leftmotor1);
  public WPI_TalonSRX leftmotor2 = new WPI_TalonSRX(Constants.leftmotor2);
  public WPI_TalonSRX leftmotor3 = new WPI_TalonSRX(Constants.leftmotor3);

  public SpeedControllerGroup leftgroup = new SpeedControllerGroup(leftmotor1, leftmotor2, leftmotor3);

  public WPI_TalonSRX rightmotor1 = new WPI_TalonSRX(Constants.rightmotor1);
  public WPI_TalonSRX rightmotor2 = new WPI_TalonSRX(Constants.rightmotor2);
  public WPI_TalonSRX rightmotor3 = new WPI_TalonSRX(Constants.rightmotor3);

  public SpeedControllerGroup rightgroup = new SpeedControllerGroup(rightmotor1, rightmotor2, rightmotor3);

  DifferentialDrive differentialDrive = new DifferentialDrive(leftgroup, rightgroup);

  public void oDrive(double y1, double y2) {
    differentialDrive.tankDrive(y1, y2, true);
  }

  /** Creates a new Driving. */
  public DrivingSubsystem() {
  }

  public void periodic() {
    // This method will be called once per scheduler 
    setDefaultCommand(new DrivingCommand());
  }
}