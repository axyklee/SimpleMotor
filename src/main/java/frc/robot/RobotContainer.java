// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import static edu.wpi.first.units.Units.Volts;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.subsystems.SimpleMotor;

public class RobotContainer {
  private CommandXboxController joystick = new CommandXboxController(0);
  private SimpleMotor motor = new SimpleMotor(1, Volts.of(5));

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
