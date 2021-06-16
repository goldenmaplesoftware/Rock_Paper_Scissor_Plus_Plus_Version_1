package sample;

import javafx.application.Application;
import javafx.stage.Stage;

import java.util.Scanner;

public class gameLogicRevised extends Application
{

    @Override
    public void start(Stage stage) throws Exception
    {
        System.out.println("***ROCK PAPER SCISSORS ++ ***\n ENTER: (1)-ROCK\n ENTER (2)-PAPER\n ENTER (3)-SCISSORS\n(4)-WATER\n ENTER (5)-FIRE\n ENTER (6)-WIND\n");
        double bankAccount=30.00;
        Scanner userInput = new Scanner(System.in);
        int gameSelection = userInput.nextInt();

        int max = 6;
        int min = 1;
        int range = (max - min) + 1; ///LIMITS THE POSSIBLE OUTCOMES
        int count; ///FOR LOOP COUNTER


        if (gameSelection == 1)  ///USER INPUT ROCK
        {
            System.out.println("YOUR INPUT IS ROCK");
            for (count = 1; count < 6; count++)
            {
                int CPU = (int) (Math.random() * range) + min;
                if (CPU == 1) {
                    System.out.println("CPU OUTPUT IS SCISSOR" + "\nYOU WIN!\n");
                    break;
                } else if (CPU == 2) {
                    System.out.println("CPU OUTPUT IS ROCK" + "\nYOU TIE!\n");
                    break;
                } else if (CPU == 3) {
                    System.out.println("CPU OUTPUT IS PAPER" + "\nYOU LOSE!\n");
                    break;
                }
                break;
            }
        }

        else if (gameSelection == 2)
        {  /// USER INPUT PAPER
            System.out.println("YOUR INPUT IS PAPER");
            for (count = 1; count < 6; count++)
            {
                int CPU = (int) (Math.random() * range) + min;

                if (CPU == 1)
                {
                    System.out.println("CPU OUTPUT IS SCISSOR" + "\nYOU LOSE!\n");
                    break;
                }

                else if (CPU == 2)
                {
                    System.out.println("CPU OUTPUT IS ROCK" + "\nYOU WIN!\n");
                    break;
                }

                else if (CPU == 3)
                {
                    System.out.println("CPU OUTPUT IS PAPER" + "\nYOU TIE!\n");
                    break;
                }
                break;
            }
        }

        else if (gameSelection == 3)
        { /// USER INPUT SCISSOR
            System.out.println("YOUR INPUT IS SCISSOR");

            for (count = 1; count < 6; count++)
            {  /// Itterates the range lower bound ==1 upperbound==6
                int CPU = (int) (Math.random() * range) + min;
                if (CPU == 1)
                {
                    System.out.println("CPU OUTPUT IS SCISSOR" + "\nYOU TIE!\n");
                    break;
                }

                else if (CPU == 2)
                {
                    System.out.println("CPU OUTPUT IS ROCK" + "\nYOU LOSE!\n");
                    break;
                }

                else if (CPU == 3)
                {
                    System.out.println("CPU OUTPUT IS PAPER" + "\nYOU WIN!\n");
                    break;
                }

                break;
            }
        }



        else {
            System.out.println("INVALID INPUT!");
        }


        userInput.close();
    }
}
