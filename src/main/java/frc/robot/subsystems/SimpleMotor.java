package frc.robot.subsystems;

import static edu.wpi.first.units.Units.Volts;

import com.revrobotics.spark.SparkFlex;
import com.revrobotics.spark.SparkBase.PersistMode;
import com.revrobotics.spark.SparkBase.ResetMode;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.config.SparkFlexConfig;
import com.revrobotics.spark.config.SparkBaseConfig.IdleMode;

import edu.wpi.first.units.measure.Voltage;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class SimpleMotor extends SubsystemBase {
    private SparkFlex motor;
    private Voltage voltageOut;

    public SimpleMotor(int deviceId, Voltage voltageOut) {
        this.motor = new SparkFlex(1, MotorType.kBrushless);
        this.voltageOut = voltageOut;
        SparkFlexConfig config = new SparkFlexConfig();
        config.idleMode(IdleMode.kBrake);
        this.motor.configure(config, ResetMode.kResetSafeParameters, PersistMode.kNoPersistParameters);

        this.setDefaultCommand(this.stop());
    }

    public Command start() {
        return this.run(() -> this.motor.setVoltage(voltageOut));
    }

    public Command stop() {
        return this.run(() -> this.motor.setVoltage(Volts.of(0)));
    }
}
