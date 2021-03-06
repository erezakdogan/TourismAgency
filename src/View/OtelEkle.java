package View;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javax.swing.JOptionPane;
import app.AgentySystem;
import javafx.scene.control.DatePicker;

import Model.Hotel;
import Model.Pansiyon;
import Model.Room;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.control.ComboBox;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Button;

public class OtelEkle {

    @FXML
    private Button exitButton;

    @FXML
    private TextField roomBed;

    @FXML
    private TextField RoomMeter;

    @FXML
    private CheckBox roomConsole;

    @FXML
    private CheckBox roomSafe;

    @FXML
    private CheckBox roomProjection;

    @FXML
    private CheckBox roomTelevision;

    @FXML
    private CheckBox roomBar;

    @FXML
    private ComboBox<String> comboPansiyon;

    @FXML
    private Button roomAdd;

    @FXML
    private TextField RoomCount;

    @FXML
    private TextField oName;

    @FXML
    private TextField oPhone;

    @FXML
    private TextField oEmail;

    @FXML
    private TextField oAdress;

    @FXML
    private ComboBox<Integer> comboStar;

    @FXML
    private CheckBox hasOto;

    @FXML
    private CheckBox hasSpa;

    @FXML
    private CheckBox hasGym;

    @FXML
    private CheckBox hasWifi;

    @FXML
    private CheckBox hasMermaid;

    @FXML
    private CheckBox hasPool;

    @FXML
    private CheckBox hasRoomService;

    @FXML
    private Button hotelAdd;

    @FXML
    private DatePicker perStart;

    @FXML
    private DatePicker perEnd;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;
    ArrayList<Room> rArrayList;
    Hotel hotel;
    Room room;

    @FXML
    void initialize() {
        exitButton.setOnAction(arg0 -> {
            Stage stage = (Stage) exitButton.getScene().getWindow();
            stage.close();
            AgentySystem agentySystem = new AgentySystem();
            agentySystem.start(new Stage());
        });
        addHotel();
        comboPansiyon.getItems().addAll("ULTRA", "EVERYTHING", "BREAKFAST", "FULL", "HALF", "BED", "NO_ALCOHOL");
        comboStar.getItems().addAll(1, 2, 3, 4, 5);

    }

    private void addHotel() {
        getRooms();
        hotelAdd.setOnAction(arg0 -> {
            hotel = new Hotel();
            if (oName.getText().length() == 0 || oAdress.getText().length() == 0 || oEmail.getText().length() == 0
                    || comboStar.getSelectionModel().getSelectedItem() == null) {
                JOptionPane.showMessageDialog(null, "Bo??luklar?? doldurunuz", "Eksik Bilgi", JOptionPane.ERROR_MESSAGE);
            } else {
                hotel.addHotel(oName.getText(), oAdress.getText(), oEmail.getText(), oPhone.getText(),
                        comboStar.getSelectionModel().getSelectedItem(), perStart.getValue(), perEnd.getValue(),
                        hasOto.isSelected(), hasWifi.isSelected(), hasPool.isSelected(), hasGym.isSelected(),
                        hasMermaid.isSelected(), hasSpa.isSelected(), hasRoomService.isSelected());
                JOptionPane.showMessageDialog(null, "????lem Ba??ar??l??", "Otel Ekle", JOptionPane.INFORMATION_MESSAGE);

            }
            Room.addRooms(oName.getText(), rArrayList);
            clearHotelIO();
        });
    }

    private void getRooms() {
        rArrayList = new ArrayList<>();
        roomAdd.setOnAction(arg0 -> {
            if (roomBed.getText().length() == 0 || RoomCount.getText().length() == 0
                    || RoomMeter.getText().length() == 0
                    || comboPansiyon.getSelectionModel().getSelectedItem() == null) {
                JOptionPane.showMessageDialog(null, "Bo??luklar?? doldurunuz", "Eksik Bilgi", JOptionPane.ERROR_MESSAGE);
            } else {
                room = new Room(0, Integer.parseInt(roomBed.getText()), Integer.parseInt(RoomMeter.getText()),
                        roomSafe.isSelected(), roomProjection.isSelected(), roomTelevision.isSelected(),
                        roomBar.isSelected(), roomConsole.isSelected(),
                        Pansiyon.valueOf(comboPansiyon.getSelectionModel().getSelectedItem()),
                        Integer.parseInt(RoomCount.getText()));
                JOptionPane.showMessageDialog(null, "????lem Ba??ar??l??", "Oda Ekle", JOptionPane.INFORMATION_MESSAGE);
                rArrayList.add(room);
            }
            clearRoomIO();
        });

    }

    private void clearHotelIO() {
        oName.clear();
        oAdress.clear();
        oEmail.clear();
        oPhone.clear();
        comboStar.getSelectionModel().clearSelection();
        perStart.setValue(null);
        perEnd.setValue(null);
        hasOto.setSelected(false);
        hasGym.setSelected(false);
        hasWifi.setSelected(false);
        hasPool.setSelected(false);
        hasMermaid.setSelected(false);
        hasSpa.setSelected(false);
        hasRoomService.setSelected(false);
    }

    private void clearRoomIO() {
        roomBed.clear();
        RoomMeter.clear();
        RoomCount.clear();
        roomSafe.setSelected(false);
        roomProjection.setSelected(false);
        roomTelevision.setSelected(false);
        roomBar.setSelected(false);
        roomConsole.setSelected(false);
        comboPansiyon.getSelectionModel().clearSelection();

    }

}
