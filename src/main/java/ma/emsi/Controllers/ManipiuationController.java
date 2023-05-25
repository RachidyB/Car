package ma.emsi.Controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import ma.emsi.JDBC.service.VoitureService;
import ma.emsi.classe.Voiture;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import static java.lang.Double.parseDouble;

public class ManipiuationController{

    @FXML
    private TableView<Voiture> carTableView;

    @FXML
    private TableColumn<Voiture, String> matriculeC;

    @FXML
    private TableColumn<Voiture, String> marqueC;

    @FXML
    private TableColumn<Voiture, String> couleurC;
    @FXML
    private TableColumn<Voiture, Double> prixC;
    @FXML
    private TableColumn<Voiture, Double> kilometrageC;
    @FXML
    private TableColumn<Voiture, Double> vitesseC;

    @FXML
    private TextField matricule;
    @FXML
    private TextField marque;
    @FXML
    private TextField couleur;
    @FXML
    private TextField prix;
    @FXML
    private TextField kilometrage;
    @FXML
    private TextField vitesse;
    private Button myButton;
    VoitureService v = new VoitureService();

    @FXML
    protected void onAddButtonClick() {
        String matricule = this.matricule.getText();
        String marque = this.marque.getText();
        String couleur = this.couleur.getText();
        String prix = this.prix.getText();
        String kilometrage = this.kilometrage.getText();
        String vitesse = this.vitesse.getText();
        if (matricule.isEmpty() || marque.isEmpty() || couleur.isEmpty() || prix.isEmpty() || kilometrage.isEmpty() || vitesse.isEmpty()) {
            // TextField is empty, display an error message
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Validation Error");
            alert.setContentText("The TextField is required.");
            alert.showAndWait();
        }
        else {
            try {
                Voiture voiture = new Voiture(matricule, marque, couleur , parseDouble(prix),  parseDouble(kilometrage), parseDouble(vitesse));
                v.save(voiture);
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

    }
    @FXML
    protected void onUpdateButtonClick() {
        String matricule = this.matricule.getText();
        String marque = this.marque.getText();
        String couleur = this.couleur.getText();
        String prix = this.prix.getText();
        String kilometrage = this.kilometrage.getText();
        String vitesse = this.vitesse.getText();
        if (matricule.isEmpty() || marque.isEmpty() || couleur.isEmpty() || prix.isEmpty() || kilometrage.isEmpty() || vitesse.isEmpty()) {
            // TextField is empty, display an error message
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Validation Error");
            alert.setContentText("The TextField is required.");
            alert.showAndWait();
        }
        else {
            try {
                Voiture voiture = new Voiture(matricule, marque, couleur , parseDouble(prix),  parseDouble(kilometrage), parseDouble(vitesse));
                v.update(voiture);
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

    }

    @FXML
    protected void onDeleteButtonClick() {
        String matricule = this.matricule.getText();
        if (matricule.isEmpty()) {
            // TextField is empty, display an error message
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Validation Error");
            alert.setContentText("The TextField is required.");
            alert.showAndWait();
        }
        else {
            try {
                v.remove(matricule);
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

    }

}