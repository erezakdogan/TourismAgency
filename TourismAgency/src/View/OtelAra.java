package View;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import Model.Hotel;
import Model.Room;

public class OtelAra {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label cityText;

    @FXML
    private Label regionText;

    @FXML
    private Label addressText;

    @FXML
    private Label phoneText;

    @FXML
    private Label oto;

    @FXML
    private Label wifi;

    @FXML
    private Label pool;

    @FXML
    private Label roomService;

    @FXML
    private Label gym;

    @FXML
    private Label spa;

    @FXML
    private Label mermaid;

    @FXML
    private VBox roomRootBox;

    //
    // @FXML
    // private Label roomDetail;

    // @FXML
    // private ImageView roomConsole;

    // @FXML
    // private ImageView roomProjection;

    // @FXML
    // private ImageView roomTelevision;

    // @FXML
    // private ImageView roomBar;

    // @FXML
    // private ImageView roomSafe;

    // @FXML
    // private Label roomCost;

    // @FXML
    // private Button reservationButton;
    static ArrayList<Rooms> reservationList = new ArrayList<>();
    static ArrayList<Rooms> reservationList2 = new ArrayList<>();
    @FXML
    void initialize() {
        assert cityText != null : "fx:id=\"cityText\" was not injected: check your FXML file 'OtelAra.fxml'.";
        assert regionText != null : "fx:id=\"regionText\" was not injected: check your FXML file 'OtelAra.fxml'.";
        assert addressText != null : "fx:id=\"addressText\" was not injected: check your FXML file 'OtelAra.fxml'.";
        assert phoneText != null : "fx:id=\"phoneText\" was not injected: check your FXML file 'OtelAra.fxml'.";
        assert oto != null : "fx:id=\"oto\" was not injected: check your FXML file 'OtelAra.fxml'.";
        assert wifi != null : "fx:id=\"wifi\" was not injected: check your FXML file 'OtelAra.fxml'.";
        assert pool != null : "fx:id=\"pool\" was not injected: check your FXML file 'OtelAra.fxml'.";
        assert gym != null : "fx:id=\"gym\" was not injected: check your FXML file 'OtelAra.fxml'.";
        assert spa != null : "fx:id=\"spa\" was not injected: check your FXML file 'OtelAra.fxml'.";
        assert mermaid != null : "fx:id=\"mermaid\" was not injected: check your FXML file 'OtelAra.fxml'.";

    }

    public void roomsAdd(Boolean inPeriod, int id,LocalDate sDate,LocalDate eDate, int countPerson) {
        ArrayList<Room> roomArrayList = Room.getRooms(id);
        
              for (int i = 0; i < roomArrayList.size(); i++) {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Rooms.fxml"));
                AnchorPane pane = fxmlLoader.load();
                Rooms rooms = (Rooms) fxmlLoader.getController();
                rooms.setRoom(inPeriod, roomArrayList.get(i), sDate, eDate,countPerson);
                reservationList.add(rooms);
                roomRootBox.getChildren().add(pane);
            } catch (IOException e) {
                e.printStackTrace();
            }
            reservationList2.addAll(reservationList);
        }
        
      
    }

    public void setHotel(Hotel hotel,LocalDate sDate,LocalDate eDate, int countPerson) {
         roomsAdd(true,hotel.getId(), sDate, eDate,countPerson);
        // if(sDate.isBefore(eDate)){
           
        // }else{
        //     roomsAdd(false,hotel.getId(), sDate, eDate,countPerson);
        // }
        
        cityText.setText(hotel.getAdress());
        regionText.setText(hotel.getAdress());
        addressText.setText(hotel.getAdress());
        phoneText.setText(hotel.getPhone());
        if (!hotel.isCarpark()) {
            oto.setManaged(false);
            oto.setVisible(false);
        }
        if (!hotel.isConcierge()) {
            mermaid.setManaged(false);
            mermaid.setVisible(false);
        }
        if (!hotel.isGym()) {
            gym.setManaged(false);
            gym.setVisible(false);
        }
        if (!hotel.isPool()) {
            pool.setManaged(false);
            pool.setVisible(false);
        }
        if (!hotel.isSpa()) {
            spa.setManaged(false);
            spa.setVisible(false);
        }
        if (!hotel.isRoomService()) {
            roomService.setManaged(false);
            roomService.setVisible(false);
        }
        if (!hotel.isWifi()) {
            wifi.setManaged(false);
            wifi.setVisible(false);
        }
    }

    public static void collapseAll(Boolean bool) {
        if(bool==true){
            reservationList.stream().forEach(action->{
                action.collapsePane();
            });
            }
    }
}
