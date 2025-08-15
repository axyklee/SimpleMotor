package frc.robot.subsystems;

import static edu.wpi.first.units.Units.Volts;

import com.ctre.phoenix6.controls.VoltageOut;
import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.NeutralModeValue;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.utils.Constants;

public class SimpleMotor extends SubsystemBase {
    private TalonFX motor = new TalonFX(Constants.motorId, Constants.motorCanBus);
    private VoltageOut voltageOut = new VoltageOut(0);

    public SimpleMotor() {
        motor.setNeutralMode(NeutralModeValue.Brake);
        setDefaultCommand(stop());
    }

    public Command start() {
        return this.run(() -> motor.setControl(voltageOut.withOutput(Constants.motorOutputVoltage)));
    }

    public Command stop() {
        return this.run(() -> motor.setControl(voltageOut.withOutput(Volts.of(0))));
    }
}
