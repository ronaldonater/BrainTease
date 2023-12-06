package com.example.braintease_final;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

/**
 * BrainTeaseTriviaGame class is our main driver. It extends application, and overrides the start() function.
 * When the start function gets called eventually by the launch().
 */
public class BrainTeaseTriviaGame extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Quiz.class.getResource("home.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
        //needed to see the changes made to corners
        stage.initStyle(StageStyle.TRANSPARENT);
        scene.setFill(Color.TRANSPARENT);

        //curtain reveal
        stage.show();
    }

    //launch() is built in function that calls start()
    public static void main(String[] args) {
        launch();
    }

}