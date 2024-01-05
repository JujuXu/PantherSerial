package helha.panther;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class PantherApp extends Application {
    /**
     * start method is needed to setup the JavaFX interface and display it.
     * @param stage
     * @throws IOException
     */
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(PantherApp.class.getResource("panther.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1280, 720);
        stage.setTitle("PANTHER HUD");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * main method is the first method called when the program is launched. As PantherApp class is an extension of Application class, the start method is called at start.
     * @param args
     */

    public static void main(String[] args) {
        launch();
    }

    public static void sendLog(String str) {
        System.out.print(java.time.LocalTime.now().format(java.time.format.DateTimeFormatter.ofPattern("HH:mm:ss:SSS")) + " > ");
        System.out.println(str);
    }
}