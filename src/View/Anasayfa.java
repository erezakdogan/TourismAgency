package View;

import java.net.URL;
import java.util.ResourceBundle;
import javax.swing.JOptionPane;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.scene.control.TextField;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ScrollPane;

public class Anasayfa {

    @FXML
    private Button hotelSearchButton;

    @FXML
    private Button hotelAddButton;

    @FXML
    private Button listReservations;

    @FXML
    private TextField cityField;

    @FXML
    private DatePicker dateStart;

    @FXML
    private DatePicker dateEnd;

    @FXML
    private ComboBox<Integer> customerCount;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    void initialize() {
        customerCount.getItems().addAll(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        initButtons();
    }

    private void initButtons() {
        hotelSearchButton.setOnAction(arg0 -> {
            if (cityField.getText().length() == 0 || dateStart.getValue() == null || dateEnd.getValue() == null
                    || customerCount.getSelectionModel().getSelectedItem() == null) {
                JOptionPane.showMessageDialog(null, "Boşlukları Doldurunuz", "Eksik Bilgi", JOptionPane.ERROR_MESSAGE);
            } else {
                Stage stage1 = (Stage) hotelAddButton.getScene().getWindow();
                stage1.close();
                try {
                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/View/SearchMain.fxml"));
                    ScrollPane root = fxmlLoader.load();
                    SearchMain searchMain = (SearchMain) fxmlLoader.getController();
                    searchMain.loadHotels(cityField.getText(), dateStart.getValue(), dateEnd.getValue(),
                            customerCount.getSelectionModel().getSelectedItem());
                    Scene scene = new Scene(root);
                    Stage stage = new Stage();
                    stage.setScene(scene);
                    stage.show();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        });

        listReservations.setOnAction(arg2 -> {
            Stage stage2 = (Stage) listReservations.getScene().getWindow();
            stage2.close();
            try {
                FXMLLoader fxmlLoader2 = new FXMLLoader(getClass().getResource("ResList.fxml"));
                AnchorPane root2 = fxmlLoader2.load();
                Scene scene = new Scene(root2);
                Stage stage = new Stage();
                stage.setScene(scene);
                stage.show();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        hotelAddButton.setOnAction(arg0 -> {
            Stage stage3 = (Stage) hotelAddButton.getScene().getWindow();
            stage3.close();

            try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("OtelEkle.fxml"));
                AnchorPane root = fxmlLoader.load();
                Scene scene = new Scene(root);
                Stage stage = new Stage();
                stage.setScene(scene);
                stage.show();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}
