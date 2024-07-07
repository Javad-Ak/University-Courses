import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MVCExample extends Application {

    @Override
    public void start(Stage primaryStage) {
        AdditionModel model = new AdditionModel();
        AdditionController controller = new AdditionController(model);
        AdditionView view = new AdditionView(controller, model);

        Scene scene = new Scene(view.asParent());
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}