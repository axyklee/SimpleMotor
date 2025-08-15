// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import frc.robot.subsystems.SimpleMotor;
import frc.robot.utils.ExtendedController;

public class RobotContainer {
  private ExtendedController joystick = new ExtendedController(0);
  private SimpleMotor motor = new SimpleMotor();

  public RobotContainer() {
    configureBindings();
  }

  private void configureBindings() {
    joystick.a().onTrue(motor.start());
    joystick.a().onFalse(motor.stop());
  }

  public Command getAutonomousCommand() {
    return Commands.print("No autonomous command configured");
  }
}
