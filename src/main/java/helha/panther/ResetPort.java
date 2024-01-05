package helha.panther;

import java.util.Timer;
import java.util.TimerTask;

/**
 * This class is a task that resets the serial port every minute.
 * It is used to keep the port open and avoid issues with communication.
 */
public class ResetPort extends TimerTask {
    /**
     * This method is called automatically by the timer.
     * It resets the serial port and then schedules another task to run in one minute.
     */
    @Override
    public void run() {
        try {
            Port.closePort();
            Port.setup();
        } catch (Exception e) {
            PantherApp.sendLog("Failed to reset Serial Port " + Port.getPort());
        }

        new Timer().schedule(new ResetPort(), 60 * 1000);
    }
}
