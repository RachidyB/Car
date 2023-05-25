package ma.emsi;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;

public class VoitureApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        File file = new File("src/main/resources/Pages/login-view.fxml");
        FXMLLoader loader = new FXMLLoader(file.toURI().toURL());
        Scene scene = new Scene(loader.load());
        stage.setTitle("Voitures");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}