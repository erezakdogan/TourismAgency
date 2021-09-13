package View;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;

import Model.Hotel;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

public class SearchMain {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private VBox vbox;

    @FXML
    void initialize() {
        assert vbox != null : "fx:id=\"vbox\" was not injected: check your FXML file 'SearchMain.fxml'.";
    }

    public void loadHotels(String cityName,LocalDate startDate, LocalDate endDate,int countPerson) {
        ArrayList<Hotel> hotels = Hotel.getHotels();
        for (int i = 0; i < hotels.size(); i++) {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/View/OtelAra.fxml"));
                AnchorPane anchorPane = fxmlLoader.load();
                OtelAra otelAra = (OtelAra) fxmlLoader.getController();
                otelAra.setHotel(hotels.get(i),startDate,endDate,countPerson);

                vbox.getChildren().add(anchorPane);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
