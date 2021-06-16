package sample;

import javafx.application.Application;
import javafx.stage.Stage;

import java.util.Scanner;

public class gameLogic extends Application
{

    @Override
    public void start(Stage stage) throws Exception
    {
        System.out.println("***ROCK PAPER SCISSORS ADVANCED***\n" + " ENTER: (0)-SCISSORS\n ENTER (1)-ROCK\n ENTER (2)-PAPER\n");
        int max = 3;
        int min = 1;
        int range = (max - min) + 1; ///LIMITS THE POSSIBLE OUTCOMES
        int count; ///FOR LOOP COUNTER
        int userWins = 0, cpuWins = 0, ties = 0;
        int gamesPlayed = 1;
        boolean gameEndingWinnings = true; ///This will keep game looping until limit is reached
        Scanner userInput = new Scanner(System.in);

        while (gameEndingWinnings) {
            if (userWins == 2 || cpuWins == 2) ///THIS CONDITION ENDS THE GAME ONCE EITHER THE PLAYER OR CPU ACHIEVES 2 WINS
            {
                gameEndingWinnings = false; ///Ends Loop
                userInput.close();
                System.out.println("\n************\n"+"GAME STATISTICS"+"\n************\n" + "Total Games Played:" + gamesPlayed + "\nCPU Won:" + cpuWins + "\nPlayer Won:" + userWins + "\nTies:" + ties );
                if(userWins<cpuWins){
                    System.out.println("\nSorry you lost tournament!!!");
                }
                else{
                    System.out.println("\nCongrats you won the tournament!!!");
                }
            }

            else {    ///This is the condition that the actual game is played with in

                System.out.println("GAME NUMBER["+gamesPlayed+"]\nINPUT FIELD:");
                int gameSelection = userInput.nextInt();

                if (gameSelection == 0) { /// USER INPUT SCISSOR
                    System.out.println("YOUR INPUT IS SCISSOR");
                    for (count = 1; count < 3; count++) {  /// Itterates the range lower bound ==1 upperbound==3
                        int CPU = (int) (Math.random() * range) + min;
                        if (CPU == 1) {
                            ties += 1;
                            gamesPlayed += 1;
                            System.out.println("CPU OUTPUT IS SCISSOR" + "\nYOU TIE!\n");
                            break;
                        } else if (CPU == 2) {
                            cpuWins += 1;
                            System.out.println("CPU OUTPUT IS ROCK" + "\nYOU LOSE!\n");
                            break;
                        } else if (CPU == 3) {
                            userWins += 1;
                            gamesPlayed += 1;
                            System.out.println("CPU OUTPUT IS PAPER" + "\nYOU WIN!\n");
                            break;
                        }
                        break;
                    }
                } else if (gameSelection == 1)  ///USER INPUT ROCK
                {
                    System.out.println("YOUR INPUT IS ROCK");
                    for (count = 1; count < 3; count++) {
                        int CPU = (int) (Math.random() * range) + min;
                        if (CPU == 1) {
                            userWins += 1;
                            gamesPlayed += 1;
                            System.out.println("CPU OUTPUT IS SCISSOR" + "\nYOU WIN!\n");
                            break;
                        } else if (CPU == 2) {
                            ties += 1;
                            gamesPlayed += 1;
                            System.out.println("CPU OUTPUT IS ROCK" + "\nYOU TIE!\n");
                            break;
                        } else if (CPU == 3) {
                            cpuWins += 1;
                            gamesPlayed += 1;
                            System.out.println("CPU OUTPUT IS PAPER" + "\nYOU LOSE!\n");
                            break;
                        }
                        break;
                    }
                } else if (gameSelection == 2) {  /// USER INPUT PAPER
                    System.out.println("YOUR INPUT IS PAPER");
                    for (count = 1; count < 3; count++) {
                        int CPU = (int) (Math.random() * range) + min;
                        if (CPU == 1) {
                            cpuWins += 1;
                            gamesPlayed += 1;
                            System.out.println("CPU OUTPUT IS SCISSOR" + "\nYOU LOSE!\n");
                            break;
                        } else if (CPU == 2) {
                            userWins += 1;
                            gamesPlayed += 1;
                            System.out.println("CPU OUTPUT IS ROCK" + "\nYOU WIN!\n");
                            break;
                        } else if (CPU == 3) {
                            ties += 1;
                            gamesPlayed += 1;
                            System.out.println("CPU OUTPUT IS PAPER" + "\nYOU TIE!\n");
                            break;
                        }

                    }
                } else {
                    System.out.println("INVALID INPUT!");
                }



            }
        }
    }


    }

