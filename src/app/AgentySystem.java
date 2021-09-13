package app;

import java.util.ArrayList;
import java.util.List;
import Model.Hotel;
import Model.Room;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class AgentySystem {

    private String name;
    private ArrayList<Hotel> hotels;
    public AgentySystem(){
        hotels = new ArrayList<Hotel>();
    }
    public void start(Stage stage){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/View/Anasayfa.fxml"));
            AnchorPane root = fxmlLoader.load();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addHotel(Hotel hotel){
        hotels.add(hotel);
    }

    public List<Room> listRoom(){
        return null;
    }

    public void reserveRoom(Room room){
        
    }

    public String toString(){
        return this.name;
    }
}
