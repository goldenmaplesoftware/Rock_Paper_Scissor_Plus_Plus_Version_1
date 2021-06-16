package sample.gameLogicBank.CPUDifficulity;

import sample.selections.*;
import sample.selections.CPUSelect.*;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

/**
 * THIS IS THE FIRST ROUND CPU,  THE OUTCOME IS ALWAYS ROCK,  IT CYCLES 10 SECONDS
 *  (POSSIBLE) ONCE PLAYER MAKES SELECTION, THE CPU WILL AUTOMATICALLY MAKE IT'S SELECTION
 */
public class cpu_var_1
{
    private int count;
    private int max = 6, min = 1;
    private int range = (max - min) + 1;
    private int gamesPlayed = 1;
    int userWins = 0, cpuWins = 0, ties = 0;


    public cpu_var_1(int i)
    {
        CPUVAR1Timer cpuTime = new CPUVAR1Timer(); ///THIS STARTS THE GLOBAL TIMER
        cpuTime.runTimer(); ///GLOBAL TIMER BEGINS NOW!

    }

    public cpu_var_1() {

    }

    public static class CPUVAR1Timer
    {
        Timer timer = new Timer();
        int i = 30;  ///TIME IT TAKES TO MAKE DECISION
        TimerTask task = new TimerTask()
        {

            private Object rock;

            public void run()
            {
                String time = getTime(i);
                System.out.println(time);
                i--;
/**
 * ONCE THE CPU CLOCK HITS ZERO,  IT WILL SELECT ONE OF THE SIX POSSIBLE OPTIONS
 */
                if(i==0)
                {
                    timer.cancel();
                    int max = 6;
                    int min = 1;
                    int range = (max - min) + 1; ///LIMITS THE POSSIBLE OUTCOMES
                    Random CPUSelect=new Random();
                    int CPUselection = CPUSelect.nextInt(max - min + 1) + min;

                    if(CPUselection==1)
                    {
                        new cpu_rock("CPU Selected Rock",1);
                    }

                    else if(CPUselection==2)
                    {
                        new cpu_paper("CPU Selected Paper", 2);
                    }

                    else if(CPUselection==3)
                    {
                        new cpu_scissors("CPU Selected Scissors", 3);
                    }

                    else if(CPUselection==4)
                    {
                        new cpu_water("CPU Selected Water", 4);
                    }

                    else if(CPUselection==5)
                    {
                        new cpu_fire("CPU Selected Fire", 5);
                    }

                    else if(CPUselection==6)
                    {
                        new cpu_wind("CPU Selected Wind", 6);

                    }

                    System.out.println("CPU EXECUTED SELECTION");

                }

            }

            private void rock()
            {

            }


        };

        public void runTimer()
        {

            int CLK = (int) (Math.random() * 1000) + 850; ///CLK CYCLE TAKES TO MAKE DECISION
            timer.schedule(task, 0, CLK); ///FASTER OR SLOWER DEPENDING
        }


        static String getTime(int sec)
        {

            int seconds = 0;

            if (sec < 60)
            {
                seconds = sec;
            }
            String strSecs;

            if (seconds%2==0)
            {
                System.out.println("CPU COUNT"); ///TO BE DISPLAYED ON GUI
                ///SOUND COUNTER
            }
            else if(seconds%2==1)
            {
                System.out.println(" CPU COUNT"); ///TO BE DISPLAYED ON GUI
                ///SOUND COUNTER
            }


            if (seconds < 10)
                strSecs = "0" + Integer.toString(seconds);
            else
                strSecs = Integer.toString(seconds);

            return strSecs;
        }


    }
}

