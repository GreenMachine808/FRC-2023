// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import static frc.robot.Constants.PneumaticsConstants.*;
import static frc.robot.Constants.*;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

public class HangSubsystem extends SubsystemBase {

  // Create variables specific to the subsystem, as well as the devices (new Motor m_motor)
  public DoubleSolenoid elevator;
  public CANSparkMax climb_l;
  public CANSparkMax climb_r;

  /** Creates a new ExampleSubsystem. */
  public HangSubsystem() {
    
    elevator = new DoubleSolenoid(
      PNEUMATICSTYPE,
      ELEVATORFORWARDCHANNEL,
      ELEVATORREVERSECHANNEL);

    climb_l = new CANSparkMax(LEFT_CLIMB_MOTOR, MotorType.kBrushless);
    climb_r = new CANSparkMax(RIGHT_CLIMB_MOTOR, MotorType.kBrushless);
    
  }

  public void elevatorState(Value state) { elevator.set(state); }

  public void moveElevator(double movement) {
    // Limit Switches?
    
    climb_l.set(movement);
    climb_r.set(movement);
  }

  /*@Override
  public void periodic() {
    // This method will be called once per scheduler run
  }*/
}
