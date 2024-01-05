package helha.panther;

import com.fazecast.jSerialComm.SerialPort;

import java.io.PrintWriter;
import java.util.Scanner;

public class Data {
    /**
     *
     * @param str
     * @param p
     */
    public static void send(String str, SerialPort p) {
        if(p.isOpen()) {
            PrintWriter printWriter = new PrintWriter(p.getOutputStream());

            printWriter.println(str);

            printWriter.flush();
            printWriter.close();

            PantherApp.sendLog(" "+" Sent data to "+ Port.getPort());
        } else {
            PantherApp.sendLog("Unable to write data to Serial Port "+Port.getPort());
        }
    }

    /**
     *
     * @param p
     * @return
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
