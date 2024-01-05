package helha.panther;

import com.fazecast.jSerialComm.SerialPort;

/**
 * This class provides methods for interacting with a serial port.
 */
public class Port {

    private static final String p = "COM3";
    private static final int baudRate = 115200;

    static SerialPort port = SerialPort.getCommPort(p);

    /**
     * Sets up the serial port by opening it, configuring it, and checking if it is open.
     * If the port is not open, an error is logged.
     */
    public static void setup() {
        if(port.openPort()) {
            port.setComPortTimeouts(SerialPort.TIMEOUT_READ_SEMI_BLOCKING,0,0);
            port.setComPortParameters(baudRate, Byte.SIZE, SerialPort.ONE_STOP_BIT,SerialPort.NO_PARITY);

            PantherApp.sendLog("Connected to Serial Port "+p);
        } else {
            PantherApp.sendLog("Unable to open Serial Port "+p);
        }
    }

    /**
     * Returns the serial port.
     */
    public static SerialPort getPort() {
        return port;
    }

    /**
     * Closes the serial port if it is open. If the port is not open, an error is logged.
     */
    public static void closePort() {
        if(port.isOpen()) {
            port.closePort();
            PantherApp.sendLog("Closed Serial Port "+p);
        }
    }
}
