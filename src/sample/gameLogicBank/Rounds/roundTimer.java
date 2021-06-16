package sample.gameLogicBank.Rounds;

import java.util.Timer;
import java.util.TimerTask;

public class roundTimer
{
    public static class RoundTimer2 ///Standard Round
    {
        Timer timer = new Timer();
        int i = 9;
        TimerTask task = new TimerTask()
        {

            public void run()
            {

                String time = getTime(i);
                System.out.println(time);
                i--;
                if(i==0)
                {
                    timer.cancel();
                    System.out.println("Round complete!");

                }
            }
        };

        public void runTimer(int round)
        {
            timer.schedule(task, 0, 1000);
            if(round == 10)
            {
                timer.schedule(task, 0, 1000);

            }

/*
            else if(round==4)
                {
                    timer.schedule(task, 0, 100);
                }
*/

        }


        static String getTime(int sec)
        {

            int seconds = 0;


            if (sec < 60)
            {

                seconds = sec;
            }

            String strSecs;

            if (seconds < 10)
                strSecs = "0" + Integer.toString(seconds);

            else
                strSecs = Integer.toString(seconds);

            return "ROUND TIMER:"+ "0" + ":" + strSecs;
        }

    }

}
