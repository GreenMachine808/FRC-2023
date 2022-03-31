package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandGroupBase;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.ParallelDeadlineGroup;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.HangSubsystem;
import frc.robot.commands.runShooter;
import frc.robot.subsystems.ShooterSubsystem;
import edu.wpi.first.wpilibj.Timer;

public class simpleAutonomous extends SequentialCommandGroup{
    private HangSubsystem hang;
    private ShooterSubsystem shooter;
    private Timer timer = new Timer();

    public simpleAutonomous(HangSubsystem hang, ShooterSubsystem shooter){
        this.hang = hang;
        this.shooter = shooter;
        
        /* addCommands(
            new InstantCommand( () -> hang.popWeightServo (true) )    
        );
        */
    
    }

    @Override
    public void initialize(){
        timer.reset();
        timer.start();
    }

    @Override
    public void execute(){
        timer.advanceIfElapsed(4);
        new InstantCommand( () -> hang.popWeightServo (true) );
    }





}