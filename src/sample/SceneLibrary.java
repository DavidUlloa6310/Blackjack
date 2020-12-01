package sample;

import javafx.stage.Stage;

public abstract class SceneLibrary {
    private static Stage primaryStage;

    public static void setPrimaryStage(Stage primaryStage) {
        SceneLibrary.primaryStage = primaryStage;
    }



}
