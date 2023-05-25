module com.example.pokecenter {
    requires javafx.controls;
    requires javafx.fxml;


    opens pokecenter to javafx.fxml;
    exports pokecenter;
}