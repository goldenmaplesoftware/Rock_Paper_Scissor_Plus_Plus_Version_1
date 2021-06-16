package sample;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class musicClass {
    public static void playSound(String fileName)
    {
        Media music = new Media("file:///C:\\Users\\Snaker96\\Documents\\College 2020\\Semester 2- Winter 2021\\Rock Paper Scissors Plus Project\\src\\sample\\gameScreen.mp3");
        MediaPlayer player = new MediaPlayer(music);
        player.play();
    }
}
