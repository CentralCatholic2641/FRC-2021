package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.Robot;

public class DriveCommand extends CommandBase {
  public DriveCommand() {
    addRequirements(Robot.drivingSubsystem);
  }

  @Override
  public void initialize() {

  }

  @Override
  public void execute() {
    double joystick1 = Robot.robotContainer.gamepad1.getRawAxis(Constants.joystickPort);
    double joystick2 = Robot.robotContainer.gamepad1.getRawAxis(Constants.joystickPort2);

    double y_stick1 = -.95 * joystick1;
    double y_stick2 = -.92 * joystick2;

    Robot.drivingSubsystem.teleopDrive(y_stick1, y_stick2);

    if (joystick1 >= 1 && joystick2 >= 1) {
      Robot.drivingSubsystem.ahrs.zeroYaw();
    }
  }

  @Override
  public void end(boolean interrupted) {

  }

  @Override
  public boolean isFinished() {
    return false;
  }
}
