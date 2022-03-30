package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandGroupBase;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.ParallelDeadlineGroup;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.HangSubsystem;
import frc.robot.commands.runShooter;
import frc.robot.subsystems.ShooterSubsystem;
import edu.wpi.first.wpilibj.Timer;
import frc.robot.subsystems.SwerveSubsystem;
import frc.robot.commands.runIntake;
import frc.robot.commands.runIntakeReverse;
import frc.robot.commands.runShooter;
import frc.robot.delayedAction;
import frc.robot.timedAction;

public class commandBaseAuto extends SequentialCommandGroup{
    private final HangSubsystem hang = new HangSubsystem();
    private final ShooterSubsystem shooter = new ShooterSubsystem();
    private final SwerveSubsystem drive = new SwerveSubsystem();
    private Timer timer = new Timer();
    private timedAction deadline;

    
    public commandBaseAuto(){
     
    }

    @Override
    public void initialize(){
        timer.reset();
        timer.start();
        drive.initDrive();

        deadline = new timedAction(10000, () -> {});

    } 

    

    @Override
    public void execute(){
        new ParallelDeadlineGroup( new InstantCommand( () -> new Thread(deadline).start() ), new runIntake(shooter) );
    }    
}
