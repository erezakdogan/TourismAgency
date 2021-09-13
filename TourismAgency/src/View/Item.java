package View;

import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Item {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label personsLabel;

    @FXML
    private TextField personsName;

    @FXML
    private ComboBox<String> personsNationality;

    @FXML
    private TextField personsId;

    @FXML
    void initialize() {
        assert personsLabel != null : "fx:id=\"personsLabel\" was not injected: check your FXML file 'Item.fxml'.";
        assert personsName != null : "fx:id=\"personsName\" was not injected: check your FXML file 'Item.fxml'.";
        assert personsNationality != null
                : "fx:id=\"personsNationality\" was not injected: check your FXML file 'Item.fxml'.";
        assert personsId != null : "fx:id=\"personsId\" was not injected: check your FXML file 'Item.fxml'.";

        String[] isoCountryCodes = Locale.getISOCountries();
        for (String countryCode : isoCountryCodes) {
            Locale locale = new Locale("", countryCode);
            String countryName = locale.getDisplayCountry();
            personsNationality.getItems().add(countryName);
        }
    }

    public String getName() {
        return personsName.getText();
    }

    public String getNationality() {
        return personsNationality.getSelectionModel().getSelectedItem();
    }

    public String getId() {
        return personsId.getText();
    }

    public void setLabel(int num) {
        personsLabel.setText(num + ". Yetişkin : ");
    }
}
