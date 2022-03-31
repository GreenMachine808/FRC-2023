package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandGroupBase;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.ParallelDeadlineGroup;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.HangSubsystem;
import frc.robot.commands.runShooter;
import frc.robot.subsystems.ShooterSubsystem;
import frc.robot.subsystems.SwerveSubsystem;
import edu.wpi.first.wpilibj.Timer;

public class simpleAutonomous extends SequentialCommandGroup{
    private HangSubsystem hang;
    private ShooterSubsystem shooter;
    private SwerveSubsystem drive;
    private Timer timer = new Timer();

    public simpleAutonomous(HangSubsystem hang, ShooterSubsystem shooter, SwerveSubsystem drive){
        this.hang = hang;
        this.shooter = shooter;
        this.drive = drive;
        
        /* addCommands(
            new InstantCommand( () -> hang.popWeightServo (true) )    
        );
        */
    
    }

    @Override
    public void initialize(){
        timer.reset();
        timer.start();
        drive.initDrive();

    }

    @Override
    public void execute(){
        addCommands(new runShooter(shooter));
        timer.advanceIfElapsed(4);
        
    }


    @Override
    public boolean isFinished(){
        return true;
    }

}