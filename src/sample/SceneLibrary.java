package sample;

import javafx.scene.Scene;
import javafx.stage.Stage;

public abstract class SceneLibrary {
    private static Stage primaryStage;
    private static Scene gameScene = new Scene(new GameScene(), 1600, 1250);

    public static void setPrimaryStage(Stage primaryStage) {
        SceneLibrary.primaryStage = primaryStage;
    }

    public static void switchGameScene() {
        SceneLibrary.primaryStage.setScene(new Scene(new GameScene(), 1600, 1250));
    }



}
