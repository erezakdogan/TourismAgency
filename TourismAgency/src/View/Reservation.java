package View;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import Model.Reservations;
import Model.Room;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import java.time.LocalDate;

public class Reservation {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private VBox vboxPersons;

    @FXML
    private TextField nameReservation;

    @FXML
    private TextField phoneReservation;

    @FXML
    private TextField noteReservation;

    @FXML
    private TextField mailReservation;

    @FXML
    private Button applyButton;
    String s = "";

    @FXML
    void initialize() {
        assert vboxPersons != null : "fx:id=\"vboxPersons\" was not injected: check your FXML file 'Reservation.fxml'.";
        assert nameReservation != null
                : "fx:id=\"nameReservation\" was not injected: check your FXML file 'Reservation.fxml'.";
        assert phoneReservation != null
                : "fx:id=\"phoneReservation\" was not injected: check your FXML file 'Reservation.fxml'.";
        assert noteReservation != null
                : "fx:id=\"noteReservation\" was not injected: check your FXML file 'Reservation.fxml'.";
        assert mailReservation != null
                : "fx:id=\"mailReservation\" was not injected: check your FXML file 'Reservation.fxml'.";
        assert applyButton != null : "fx:id=\"applyButton\" was not injected: check your FXML file 'Reservation.fxml'.";

    }

    public void setPersons(int countPerson, int id, int price, LocalDate sDate, LocalDate eDate) {
        ArrayList<Item> itemList = new ArrayList<>();
        for (int i = 0; i < countPerson; i++) {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Item.fxml"));
                HBox box = fxmlLoader.load();
                Item item = fxmlLoader.getController();
                itemList.add(item);
                itemList.get(i).setLabel(i+1);
                vboxPersons.getChildren().add(box);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        applyButton.setOnAction(e -> {
            String name = "";
            String nationality = "";
            String pasportno = "";
            for (int j = 0; j < itemList.size(); j++) {
                name += itemList.get(j).getName() + ",";
                nationality += itemList.get(j).getNationality() + ",";
                pasportno += itemList.get(j).getId() + ",";
            }
            Reservations.addReservation(id, Room.getHotelId(id), countPerson, price, name, nationality, pasportno,
                    sDate, eDate,nameReservation.getText(), noteReservation.getText(), phoneReservation.getText(),mailReservation.getText());
        });
    }

}
