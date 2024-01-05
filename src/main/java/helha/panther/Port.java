package helha.panther;

import com.fazecast.jSerialComm.SerialPort;

import java.time.ZonedDateTime;

public class Port {

    private static final String p = "COM3";

    static SerialPort port = SerialPort.getCommPort(p);

    /**
     * setup method is called to establish a connection between Java and a COM serial port with the Arduino.
     * The method uses eeeeeeeeeee
     * @throws IllegalAccessException
     */

    public static void setup() {
        System.out.print(java.time.LocalTime.now().format(java.time.format.DateTimeFormatter.ofPattern("HH:mm:ss:SSS")) + " > ");

        if(port.openPort()) {
            port.setComPortTimeouts(SerialPort.TIMEOUT_READ_SEMI_BLOCKING,0,0);
            port.setComPortParameters(115200, Byte.SIZE, SerialPort.ONE_STOP_BIT,SerialPort.NO_PARITY);

            System.out.println("Successfully connected to Serial Port "+p);
        } else {
            System.out.println("Unable to open Serial Port "+p);
        }
    }

    /**
     *
     * @return
     */
    public static SerialPort getPort() {
        return port;
    }

    public static void closePort() throws IllegalAccessException {
        port.closePort();
    }
}
