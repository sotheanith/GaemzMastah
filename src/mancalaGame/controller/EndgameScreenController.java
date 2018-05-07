package mancalaGame.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class EndgameScreenController implements Initializable {

    @FXML
    private Label resultText;
    @FXML
    private Button playAgain, exit;
    private MainViewController mainViewController;
    private MediaPlayer mediaPlayer;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        playAgain.setOnMouseClicked(e -> {
            mainViewController.rePlay();
            mediaPlayer.stop();
            Stage stage = (Stage) playAgain.getScene().getWindow();
            stage.close();
        });
        exit.setOnMouseClicked(e -> {
            mediaPlayer.stop();
            mainViewController.close();
            Stage stage = (Stage) playAgain.getScene().getWindow();
            stage.close();

        });

    }

    public void setMainViewController(MainViewController mainViewController) {
        this.mainViewController = mainViewController;
    }

    public void result(String result) {
        Media sound = null;
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        try {
            if (result.compareTo("Won") == 0) {
                resultText.setText("Victory");
                sound = new Media(classLoader.getResource("mazeGame/resources/winning.mp3").toURI().toString());
            } else {
                resultText.setText("Defeat");
                sound = new Media(classLoader.getResource("mazeGame/resources/losing.mp3").toURI().toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        mediaPlayer = new MediaPlayer(sound);
        mediaPlayer.play();
    }
}
