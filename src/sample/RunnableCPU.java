package sample;

import java.util.Random;

/**
 * THIS WILL GENERATE A RANDOM VALUE FOR THE CPU TO COMPARE WITH THE PLAYER
 * IT RANGES 1-6
 * CONDITIONALS ARE ESTABLISHED WHEN PLAYER RELEASES BUTTON
 */
public class RunnableCPU implements Runnable
{
    private Random CPUSelection;
    String name;
    Thread thread2;


    RunnableCPU(String name)
    {
        this.name=name;
        thread2=new Thread(this,name);
        System.out.println("Created a new CPU Thread:" + thread2);
    }

    public void run()
    {
            try
            {
                Thread.sleep(1000);
            }

            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
    }

    public synchronized int getInt()
    {
        int max = 6;
        int min = 1;
        Random CPUselection_RAND= new Random();
        return CPUselection_RAND.nextInt(max - min) + min;
    }





}
