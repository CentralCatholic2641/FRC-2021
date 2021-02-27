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

	// A button
	public static final int aButton = 1;

	// B button
	public static final int bButton = 2;

	// X button
	public static final int xButton = 3;

	// Y button
	public static final int yButton = 4;

	// Joysticks
	public static final int joystick1 = 1;
	public static final int joystick2 = 4;

	// Controllers
	public static final int gamepad1 = 0;
	public static final int gamepad2 = 1;

	// Drivetrain motors
	public static final int leftmotor1 = 1;
	public static final int leftmotor2 = 2;
	public static final int leftmotor3 = 3;
	public static final int rightmotor1 = 4;
	public static final int rightmotor2 = 5;
	public static final int rightmotor3 = 6;

	// Miscellaneous motors
	public static final int intakeMotor = 10;

	// Encoders
	public static final int leftEncoder = 2;
	public static final int rightEncoder = 5;

	// PID-related
	public static final double kP = 0.8;
	public static final double kI = 0;
	public static final double kD = 0;
	public static final double wheelDiameter = 0.5;
	public static final double driftCompensation = 0.1;
	public static final int oneRotation = 4096;
}
