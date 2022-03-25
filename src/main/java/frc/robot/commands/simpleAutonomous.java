package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.HangSubsystem;
import frc.robot.commands.runShooter;
import frc.robot.subsystems.ShooterSubsystem;

public class simpleAutonomous extends SequentialCommandGroup{

    public simpleAutonomous(HangSubsystem hang, ShooterSubsystem shooter){
        addCommands(
            new InstantCommand( () -> hang.popWeightServo (true) )

            //new InstantCommand( () -> hang.popWeightServo (false) ) 
            
        );
    }

}