package helha.panther;

import java.util.Timer;
import java.util.TimerTask;

public class ResetPort extends TimerTask {

    @Override
    public void run() {

        try {
            Port.closePort();
            Port.setup();
        } catch (Exception e) {
            System.out.println("Hey !");
        }

        new Timer().schedule(new ResetPort(),60*1000);
    }
}
