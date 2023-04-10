module com.example.abriendoventanas {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.abriendoventanas to javafx.fxml;
    exports com.example.abriendoventanas;
}