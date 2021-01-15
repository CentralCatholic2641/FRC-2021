package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.button.POVButton;

public class RobotContainer {
  public Joystick gamepad1 = new Joystick(Constants.gamepad1Port);
  public Joystick gamepad2 = new Joystick(Constants.gamepad2Port);
  public POVButton POVpad = new POVButton(gamepad2, 45);

  public RobotContainer() {
    configureButtonBindings();
  }

  private void configureButtonBindings() {

  }
}