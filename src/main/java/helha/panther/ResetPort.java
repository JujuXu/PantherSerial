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

    double time;
    @Override
    public void run() {
        try {
            time = java.time.Instant.now().toEpochMilli();

            Port.closePort();
            Port.setup();

            time = java.time.Instant.now().toEpochMilli() - time;
            PantherApp.sendLog("Reseted connection in "+time+" ms.");
        } catch (Exception e) {
            PantherApp.sendLog("Failed to reset Serial Port " + Port.getPort());
        }

        new Timer().schedule(new ResetPort(), 60 * 1000);
    }
}
