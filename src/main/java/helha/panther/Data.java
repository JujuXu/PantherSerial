package helha.panther;

import com.fazecast.jSerialComm.SerialPort;

import java.io.PrintWriter;
import java.util.Scanner;
/**
 * The Data class provides methods for sending and receiving data through a serial port.
 */
public class Data {
    /**
     * Sends the specified string data to the given serial port.
     *
     * @param str The data string to be sent.
     * @param p   The SerialPort to which the data is sent.
     */
    public static void send(String str, SerialPort p) {
        if(p.isOpen()) {
            PrintWriter printWriter = new PrintWriter(p.getOutputStream());

            printWriter.println(str);

            printWriter.flush();
            printWriter.close();

            PantherApp.sendLog("Sent data to "+ Port.getPort());
        } else {
            PantherApp.sendLog("Unable to write data to Serial Port "+Port.getPort());
        }
    }
    /**
     * Reads data from the specified serial port.
     *
     * @param p The SerialPort from which data is read.
     * @return The string read from the serial port.
     */
    public static String read (SerialPort p) {
        Scanner data = new Scanner(p.getInputStream());
        String read = "";

        if(data.hasNextLine()) {
            read = data.nextLine();
        }

        data.close();
        return read;
    }
}
