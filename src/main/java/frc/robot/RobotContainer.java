// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import static edu.wpi.first.units.Units.Volts;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.subsystems.SimpleSpark;
import frc.robot.subsystems.SimpleTalon;

public class RobotContainer {
  private CommandXboxController joystick = new CommandXboxController(0);
  private SimpleSpark spark = new SimpleSpark(1, Volts.of(5));
  private SimpleTalon talon = new SimpleTalon(2, "rio", Volts.of(5));

  public RobotContainer() {
    configureBindings();
  }

  private void configureBindings() {
    joystick.a().onTrue(Commands.parallel(spark.start(), talon.start()));
    joystick.a().onFalse(Commands.parallel(spark.stop(), talon.stop()));
  }

  public Command getAutonomousCommand() {
    return Commands.print("No autonomous command configured");
  }
}
