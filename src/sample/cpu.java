package sample;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class cpu
{
    private int count;
    private int max=6,min=1;
    private int range=(max - min) + 1;
    private int gamesPlayed = 1;
    int userWins = 0, cpuWins = 0, ties = 0;

    public cpu()
    {
        int CPU = (int) (Math.random() * range) + min;

        switch (CPU)
        {
        case 1 -> {
            ///ties += 1;
            gamesPlayed += 1;
            System.out.println("CPU OUTPUT IS ROCK\n");
                  }

        case 2 -> {
            ///ties += 1;
            gamesPlayed += 1;
            System.out.println("CPU OUTPUT IS PAPER\n");
                  }

        case 3 -> {
            ///ties += 1;
            gamesPlayed += 1;
            System.out.println("CPU OUTPUT IS SCISSORS\n");
                  }
        }
    }


}
