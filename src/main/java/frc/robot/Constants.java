// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide
 * numerical or boolean constants. This class should not be used for any other
 * purpose. All constants should be declared globally (i.e. public static). Do
 * not put anything functional in this class.
 *
 * <p>
 * It is advised to statically import this clas s (or one of its inner classes)
 * wherever the constants are needed, to reduce verbosity.
 */
public final class Constants {

	// A button on joystick 0
	public static final int aButtonJoystick0 = 1;

	// B button on joystick 0
	public static final int bButtonJoystick0 = 2;

	// X button on Joystick 0
	public static final int xButtonJoystick0 = 3;

	// Y button on Joystick 0
	public static final int yButtonJoystic0 = 4;

	public static final int joystickPort1 = 1;
	public static final int joystickPort2 = 4;
	public static final int gamepad1port = 0;
	public static final int gamepad2port = 1;
	public static final int leftmotor1 = 1;
	public static final int leftmotor2 = 2;
	public static final int leftmotor3 = 3;
	public static final int rightmotor1 = 4;
	public static final int rightmotor2 = 5;
	public static final int rightmotor3 = 6;
	public static final int intakeMotor = 10;

	// ENCODERS
	public static final int leftEncoder = 1;
	public static final int rightEncoder = 4;

	// PID
	public static final double kP = 0.1;
	public static final double kI = 0.5;
	public static final double kD = 0;
	public static final double kF = 0;
	public static final double wheelDiameter = 0.5;
	public static final int percentTolerance = 15;
	public static final int oneRotation = 4096;
}
