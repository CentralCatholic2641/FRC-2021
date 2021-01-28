package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import frc.robot.subsystems.DrivingSubsystem;
import frc.robot.vision.BallSearch;

public class Robot extends TimedRobot {
  public static RobotContainer robotContainer;
  public static DrivingSubsystem drivingSubsystem = new DrivingSubsystem();
  public static BallSearch ballSearcher = new BallSearch();

  @Override
  public void robotInit() {
    robotContainer = new RobotContainer();
  }
  
  @Override
  public void robotPeriodic() {
    CommandScheduler.getInstance().run();
    System.out.println(ballSearcher.findBlobsOutput().size());
  }

  @Override
  public void disabledInit() {

  }

  @Override
  public void disabledPeriodic() {

  }

  @Override
  public void autonomousInit() {
    CommandScheduler.getInstance().registerSubsystem(drivingSubsystem);
  }

  public void autonomousPeriodic() {
    CommandScheduler.getInstance().run();
  }

  @Override
  public void teleopInit() {

  }

  @Override
  public void teleopPeriodic() {

  }

  @Override
  public void testInit() {

  }

  @Override
  public void testPeriodic() {

  }
}
