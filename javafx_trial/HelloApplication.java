package javafx_trial;

import javafx.application.Application;
import javafx.stage.Stage;

public class HelloApplication extends Application {
    Stage window;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        window = primaryStage;
        window.setTitle("Mi first stage");
        window.show();
    }
}
