package pokecenter;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class PokecenterApp extends Application {
    public PokeController cont = new PokeController();
    public VBox root = cont.initializeView();

    @Override
    public void start(Stage stage) throws IOException {
        Scene scene = new Scene(root, 820, 900);
        stage.setTitle("Poke Center");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    public static void main(String[] args) {

        launch();
    }
}