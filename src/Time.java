import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

import static java.util.concurrent.TimeUnit.SECONDS;

public class Time {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.start();
        TimeOut timeOut = new TimeOut();
        timeOut.start();


    }
}

class MyThread extends Thread {
    public void run() {
        final ScheduledExecutorService shceduler = Executors.newScheduledThreadPool(1);
        final Runnable runnable = new Runnable() {


            @Override
            public void run() {
                try {
                    sleep(5000);
                    System.out.println("прошло 5 сукунд");
                } catch (InterruptedException e) {
                    e.printStackTrace();

                }
            }
        };
        shceduler.scheduleAtFixedRate(runnable, 0, 1, SECONDS);
    }
}

class TimeOut extends Thread {
    public void run() {
        final ScheduledExecutorService shceduler = Executors.newScheduledThreadPool(1);
        final Thread myTread = new Thread() {
            int start = 1;

            @Override
            public void run() {
                System.out.println(start);
                start++;


            }


        };
        shceduler.scheduleAtFixedRate(myTread, 0, 1, SECONDS);
        {
        }
    }
}
