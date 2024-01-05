module helha.panther {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;
    requires com.fazecast.jSerialComm;


    opens helha.panther to javafx.fxml;
    exports helha.panther;
}