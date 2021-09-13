package View;

import java.io.IOException;
import java.lang.annotation.Retention;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import Helper.Calculator;
import Model.Pansiyon;
import Model.Room;
import javafx.beans.binding.BooleanExpression;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.control.Button;
import java.time.LocalDate;

public class Rooms {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label roomDetail;

    @FXML
    private Label roomConsole;

    @FXML
    private Label roomTelevision;

    @FXML
    private Label roomSafe;

    @FXML
    private Label roomProjection;

    @FXML
    private Label roomBar;

    @FXML
    private Label roomCost;

    @FXML
    private Button reservationButton;

    @FXML
    private AnchorPane infoPane;

    @FXML
    void initialize() {
        assert roomDetail != null : "fx:id=\"roomDetail\" was not injected: check your FXML file 'Rooms.fxml'.";
        assert roomConsole != null : "fx:id=\"roomConsole\" was not injected: check your FXML file 'Rooms.fxml'.";
        assert roomTelevision != null : "fx:id=\"roomTelevision\" was not injected: check your FXML file 'Rooms.fxml'.";
        assert roomSafe != null : "fx:id=\"roomSafe\" was not injected: check your FXML file 'Rooms.fxml'.";
        assert roomProjection != null : "fx:id=\"roomProjection\" was not injected: check your FXML file 'Rooms.fxml'.";
        assert roomBar != null : "fx:id=\"roomBar\" was not injected: check your FXML file 'Rooms.fxml'.";
        assert roomCost != null : "fx:id=\"roomCost\" was not injected: check your FXML file 'Rooms.fxml'.";
        assert reservationButton != null : "fx:id=\"roomCost\" was not injected: check your FXML file 'Rooms.fxml'.";

        infoPane.setManaged(false);
    }

    private void loadReservationPane(int countPerson, int id, int price, LocalDate sDate, LocalDate eDate) {
        reservationButton.setOnAction(arg0 -> {
            OtelAra.collapseAll(true);
            reservationButton.setVisible(false);
            infoPane.setVisible(true);
            infoPane.setManaged(true);
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Reservation.fxml"));
                AnchorPane info = fxmlLoader.load();
                Reservation reservation = fxmlLoader.getController();
                reservation.setPersons(countPerson, id, price, sDate, eDate);
                infoPane.getChildren().add(info);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    public void setRoom(Boolean inPeriod, Room room, LocalDate sDate, LocalDate eDate, int countPerson) {
        roomDetail.setText(">>Giriş Tarihi: " + sDate + "\n>>Çıkış Tarihi: " + eDate + "\n>>" + countPerson + " kişi");
        int price = Calculator.calculate(inPeriod, room, sDate, eDate, countPerson);
        roomCost.setText("Fiyat : " + price);
        loadReservationPane(countPerson, room.getId(), price, sDate, eDate);

        if (!room.isGameConsole()) {
            roomConsole.setManaged(false);
            roomConsole.setVisible(false);
        }
        if (!room.isMiniBar()) {
            roomBar.setManaged(false);
            roomBar.setVisible(false);
        }
        if (!room.isProjection()) {
            roomProjection.setManaged(false);
            roomProjection.setVisible(false);
        }
        if (!room.isSafe()) {
            roomSafe.setManaged(false);
            roomSafe.setVisible(false);
        }
        if (!room.isTelevision()) {
            roomTelevision.setManaged(false);
            roomTelevision.setVisible(false);
        }

    }

    public void collapsePane() {
        infoPane.setVisible(false);
        infoPane.setManaged(false);
        reservationButton.setVisible(true);

    }

}
