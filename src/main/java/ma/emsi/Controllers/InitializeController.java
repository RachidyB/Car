package ma.emsi.Controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import ma.emsi.JDBC.service.VoitureService;
import ma.emsi.classe.Voiture;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class InitializeController implements Initializable {

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

    VoitureService v = new VoitureService();

    @FXML
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        List<Voiture> lv = v.findAll();

        matriculeC.setCellValueFactory(new PropertyValueFactory<>("matricule"));
        marqueC.setCellValueFactory(new PropertyValueFactory<>("marque"));
        couleurC.setCellValueFactory(new PropertyValueFactory<>("couleur"));
        prixC.setCellValueFactory(new PropertyValueFactory<>("prix"));
        kilometrageC.setCellValueFactory(new PropertyValueFactory<>("kilometrage"));
        vitesseC.setCellValueFactory(new PropertyValueFactory<>("vitesse"));

        carTableView.getItems().addAll(lv);

    }
    public void handleButtonClick() {
        try {
            // Load the new FXML file
            File file = new File("src/main/resources/Pages/AddCar-view.fxml");
            Parent newSceneRoot = FXMLLoader.load(file.toURI().toURL());
            // Create a new stage
            Stage newStage = new Stage();
            newStage.setTitle("New Scene");

            // Set the scene for the new stage
            Scene newScene = new Scene(newSceneRoot);
            newStage.setScene(newScene);

            // Show the new stage
            newStage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void handleButtonUPClick() {
        try {
            // Load the new FXML file
            File file = new File("src/main/resources/Pages/UpdateCar-view.fxml");
            Parent newSceneRoot = FXMLLoader.load(file.toURI().toURL());
            // Create a new stage
            Stage newStage = new Stage();
            newStage.setTitle("New Scene");

            // Set the scene for the new stage
            Scene newScene = new Scene(newSceneRoot);
            newStage.setScene(newScene);

            // Show the new stage
            newStage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void handleButtonDelClick() {
        try {
            // Load the new FXML file
            File file = new File("src/main/resources/Pages/DeleteCar-view.fxml");
            Parent newSceneRoot = FXMLLoader.load(file.toURI().toURL());
            // Create a new stage
            Stage newStage = new Stage();
            newStage.setTitle("New Scene");

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
    protected void excelToDb() {
        v.importerDepuisExcel("src/main/resources/VoitureEXCEL.xlsx");
    }
    @FXML
    protected void dbToExcel() {

        v.exporterVersExcel("src/main/resources/VoitureData.xlsx");
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
    @FXML
    protected void txtToDb() throws IOException {
        v.importerDepuisTxt("src/main/resources/VoitureInputData.txt");
    }
    @FXML
    protected void dbToTxt() {
        v.exporterVersTxt("src/main/resources/Voiture.xlsx");
    }
}