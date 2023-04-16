module com.example.abriendoventanas {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.Proyecto to javafx.fxml;
    exports com.example.Proyecto;
}