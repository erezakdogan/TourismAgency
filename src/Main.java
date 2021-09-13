import app.AgentySystem;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application{
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage arg0) throws Exception {
        AgentySystem agentySystem = new AgentySystem();
        agentySystem.start(arg0);
    }
}

