import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TechmanageFX extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(TechmanageFX.class.getResource("org/example/controlador/login-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
            stage.setTitle("Techmanage");
            stage.setScene(scene);
            stage.show();
    }
}
