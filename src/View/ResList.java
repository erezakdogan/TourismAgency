package View;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import Model.Reservations;
import app.AgentySystem;
import javafx.scene.control.Button;

public class ResList {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableColumn<Reservations, Integer> colid;

    @FXML
    private TableColumn<Reservations, String> colhotel;

    @FXML
    private TableColumn<Reservations, Integer> colPersonCount;

    @FXML
    private TableColumn<Reservations, String> colPersons;

    @FXML
    private TableColumn<Reservations, String> colNation;

    @FXML
    private TableColumn<Reservations, String> colPasport;

    @FXML
    private TableColumn<Reservations, LocalDate> colEnter;

    @FXML
    private TableColumn<Reservations, LocalDate> colOut;

    @FXML
    private TableColumn<Reservations, String> colName;

    @FXML
    private TableColumn<Reservations, String> colNote;

    @FXML
    private TableColumn<Reservations, String> colPhone;

    @FXML
    private TableColumn<Reservations, String> colMail;

    @FXML
    private TableColumn<Reservations, Integer> colPrice;

    @FXML
    private TableColumn<Reservations, ?> contactParent;

    @FXML
    private Button exitButton;

    @FXML
    private TableView<Reservations> reservationsView;

    @FXML
    void initialize() {
        assert colid != null : "fx:id=\"colid\" was not injected: check your FXML file 'ResList.fxml'.";
        assert colhotel != null : "fx:id=\"colhotel\" was not injected: check your FXML file 'ResList.fxml'.";
        assert colPersonCount != null : "fx:id=\"colPersonCount\" was not injected: check your FXML file 'ResList.fxml'.";
        assert colPersons != null : "fx:id=\"colPersons\" was not injected: check your FXML file 'ResList.fxml'.";
        assert colNation != null : "fx:id=\"colNation\" was not injected: check your FXML file 'ResList.fxml'.";
        assert colPasport != null : "fx:id=\"colPasport\" was not injected: check your FXML file 'ResList.fxml'.";
        assert colEnter != null : "fx:id=\"colEnter\" was not injected: check your FXML file 'ResList.fxml'.";
        assert colOut != null : "fx:id=\"colOut\" was not injected: check your FXML file 'ResList.fxml'.";
        assert colName != null : "fx:id=\"colName\" was not injected: check your FXML file 'ResList.fxml'.";
        assert colNote != null : "fx:id=\"colNote\" was not injected: check your FXML file 'ResList.fxml'.";
        assert colPhone != null : "fx:id=\"colPhone\" was not injected: check your FXML file 'ResList.fxml'.";
        assert colMail != null : "fx:id=\"colMail\" was not injected: check your FXML file 'ResList.fxml'.";
        assert contactParent != null : "fx:id=\"colMail\" was not injected: check your FXML file 'ResList.fxml'.";
        loadList();
        exitButton.setOnAction(arg0->{
            Stage stage = (Stage) exitButton.getScene().getWindow();
            stage.close();
            AgentySystem agentySystem = new AgentySystem();
            agentySystem.start(new Stage());
        });
    }

    public void loadList(){
        reservationsView.getItems().addAll(Reservations.getReservations());
        colid.setCellValueFactory(new PropertyValueFactory<>("id"));
        colhotel.setCellValueFactory(new PropertyValueFactory<>("hotelId"));
        colPersonCount.setCellValueFactory(new PropertyValueFactory<>("personCount"));
        colPrice.setCellValueFactory(new PropertyValueFactory<>("price"));
        colPersons.setCellValueFactory(new PropertyValueFactory<>("names"));
        colNation.setCellValueFactory(new PropertyValueFactory<>("nationality"));
        colPasport.setCellValueFactory(new PropertyValueFactory<>("pasportNo"));
        colEnter.setCellValueFactory(new PropertyValueFactory<>("sDate"));
        colOut.setCellValueFactory(new PropertyValueFactory<>("eDate"));
        colName.setCellValueFactory(new PropertyValueFactory<>("contactName"));
        colNote.setCellValueFactory(new PropertyValueFactory<>("contactNote"));
        colPhone.setCellValueFactory(new PropertyValueFactory<>("contactPhone"));
        colMail.setCellValueFactory(new PropertyValueFactory<>("contactMail"));
        
    }

}
