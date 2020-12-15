package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javax.swing.*;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        primaryStage.setTitle("Black Jack");
        SceneLibrary.setPrimaryStage(primaryStage);
        SceneLibrary.switchGameScene();
        primaryStage.show();
        primaryStage.setResizable(false);
    }

    public static void main(String[] args) {
        JOptionPane.showMessageDialog(null, "You can only bet chips before you receive your cards.\n To place bets, click on your chips.\n If dealer and player ties, dealer wins.");
        launch(args);
    }
}
