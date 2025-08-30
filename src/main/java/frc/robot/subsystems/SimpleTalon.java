package frc.robot.subsystems;

import static edu.wpi.first.units.Units.Volts;

import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.controls.VoltageOut;
import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.NeutralModeValue;

import edu.wpi.first.units.measure.Voltage;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class SimpleTalon extends SubsystemBase implements SimpleMotor {
    private TalonFX motor;
    private Voltage voltage;
    private VoltageOut voltageOut;

    public SimpleTalon(int deviceId, String canbus, Voltage voltage) {
        this.motor = new TalonFX(deviceId, canbus);
        this.voltage = voltage;
        this.voltageOut = new VoltageOut(this.voltage);

        TalonFXConfiguration configs = new TalonFXConfiguration();
        this.motor.setNeutralMode(NeutralModeValue.Brake);
        this.motor.getConfigurator().apply(configs);

        this.setDefaultCommand(this.stop());
    }

    public Command start() {
        return this.run(() -> this.motor.setControl(this.voltageOut.withOutput(this.voltage)));
    }

    public Command stop() {
        return this.run(() -> this.motor.setControl(this.voltageOut.withOutput(Volts.of(0))));
    }
}
