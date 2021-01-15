package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.kauailabs.navx.frc.AHRS;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.commands.DriveCommand;

public class DrivingSubsystem extends SubsystemBase {
  // Left motors
  public WPI_TalonSRX leftMotor1 = new WPI_TalonSRX(Constants.leftMotor1);
  public WPI_TalonSRX leftMotor2 = new WPI_TalonSRX(Constants.leftMotor2);
  public WPI_TalonSRX leftMotor3 = new WPI_TalonSRX(Constants.leftMotor3);

  // Left Encoder
  public WPI_TalonSRX leftEncoder = new WPI_TalonSRX(Constants.leftEncoder);

  // Left motor group
  public SpeedControllerGroup leftGroup = new SpeedControllerGroup(leftMotor1, leftMotor2, leftMotor3);

  // Right motors
  public WPI_TalonSRX rightMotor1 = new WPI_TalonSRX(Constants.rightMotor1);
  public WPI_TalonSRX rightMotor2 = new WPI_TalonSRX(Constants.rightMotor2);
  public WPI_TalonSRX rightMotor3 = new WPI_TalonSRX(Constants.rightMotor3);

  // Right encoder
  public WPI_TalonSRX rightEncoder = new WPI_TalonSRX(Constants.rightEncoder);

  // Right motor group
  public SpeedControllerGroup rightGroup = new SpeedControllerGroup(rightMotor1, rightMotor2, rightMotor3);

  // Differential Drive
  DifferentialDrive diffDrive = new DifferentialDrive(leftGroup, rightGroup);

  public AHRS ahrs;

  public DrivingSubsystem() {
    ahrs = new AHRS();
  }

  public void teleopDrive(double yMove1, double yMove2) {
    diffDrive.tankDrive(yMove1, yMove2, true);
  }

  @Override
  public void periodic() {
    setDefaultCommand(new DriveCommand());
  }
}
