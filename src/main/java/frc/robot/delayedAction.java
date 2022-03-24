package frc.robot;

public class delayedAction extends Thread {

    public interface action {
        void act();
    }

    // This needs the public modifier. How tf is an object supposed to be initialized if the initialization method isn-
    // Whatever. I'm not mad
    public delayedAction() {}

    public void run(long desired_millis, action Action) {
        try {
            sleep(desired_millis);
        } catch(InterruptedException e) {
            System.out.println("Error: desired_millis was negative");
            interrupt();
        }
        Action.act();

        //interrupt(); (?)
    }
}
