package ma.emsi.Controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import ma.emsi.JDBC.service.UserService;
import ma.emsi.classe.User;
import ma.emsi.classe.Voiture;

import java.io.File;
import java.io.IOException;

import static java.lang.Double.parseDouble;

public class authenticationController {
    @FXML
    private TextField nom;
    @FXML
    private TextField prenom;
    @FXML
    private TextField email;
    @FXML
    private TextField password;
    @FXML
    private TextField Lemail;
    @FXML
    private TextField Lpassword;
    @FXML
    private Label lb;
    UserService u = new UserService();


    @FXML
    protected void redirecttOsignup(){
        try {
            // Load the new FXML file
            File file = new File("src/main/resources/Pages/signup-view.fxml");
            Parent newSceneRoot = FXMLLoader.load(file.toURI().toURL());
            // Create a new stage
            Stage newStage = new Stage();
            newStage.setTitle("Car insert");
            // Set the scene for the new stage
            Scene newScene = new Scene(newSceneRoot);
            newStage.setScene(newScene);
            // Show the new stage
            newStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    protected void onSignupButtonClick() {
        String nom = this.nom.getText();
        String prenom = this.prenom.getText();
        String email = this.email.getText();
        String password = this.password.getText();
        if (nom.isEmpty() || prenom.isEmpty() || email.isEmpty() || password.isEmpty()) {
            // TextField is empty, display an error message
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Validation Error");
            alert.setContentText("The TextField is required.");
            alert.showAndWait();
        }
        else {
            try {
                User user = new User(nom,prenom,email,password);
                u.signup(user);
                // Load the new FXML file
                File file = new File("src/main/resources/Pages/login-view.fxml");
                Parent newSceneRoot = FXMLLoader.load(file.toURI().toURL());
                // Create a new stage
                Stage newStage = new Stage();
                newStage.setTitle("Car insert");
                // Set the scene for the new stage
                Scene newScene = new Scene(newSceneRoot);
                newStage.setScene(newScene);
                // Show the new stage
                newStage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    @FXML
    protected void onLoginButtonClick() {
        String email = this.Lemail.getText();
        String password = this.Lpassword.getText();
        if (email.isEmpty() || password.isEmpty()) {
            // TextField is empty, display an error message
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Validation Error");
            alert.setContentText("The TextField is required.");
            alert.showAndWait();
        }
        else {
            if(u.login(email, password)==1) {
                try {
                    // Load the new FXML file
                    File file = new File("src/main/resources/Pages/carList-view.fxml");
                    Parent newSceneRoot = FXMLLoader.load(file.toURI().toURL());
                    // Create a new stage
                    Stage newStage = new Stage();
                    newStage.setTitle("Car List");
                    // Set the scene for the new stage
                    Scene newScene = new Scene(newSceneRoot);
                    newStage.setScene(newScene);
                    // Show the new stage
                    newStage.show();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            else {
                this.lb.setText("wrong infos");
            }
        }
    }
}
