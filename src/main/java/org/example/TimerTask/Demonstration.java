package org.example.TimerTask;

import lombok.extern.slf4j.Slf4j;

import java.util.Timer;
import java.util.TimerTask;


@Slf4j
class Demonstration {

    public static void main(String args[]) throws Exception {

        Timer timer = new Timer();

        TimerTask badTaskWithOutCatchingException = new TimerTask() {

            @Override
            public void run() {

                throw new RuntimeException("Something Bad Happened");
            }
        };

        TimerTask badTask = new TimerTask() {

            @Override
            public void run() {
                try {
                    throw new RuntimeException("Something Bad Happened");
                } catch (Exception e) {
                    log.error("Exception occurred " + e.getMessage());
                }
            }
        };

        TimerTask goodTask = new TimerTask() {

            @Override
            public void run() {
                System.out.println("Hello I am a well-behaved task");
            }
        };

        // If we dont catch Exception other tasks scheduled will  not execute  fails with Exception
        //Exception in thread "main" java.lang.IllegalStateException: Timer already cancelled.
       // timer.schedule(badTaskWithOutCatchingException, 10); // Uncomment to try out
        timer.schedule(badTask, 10);
        Thread.sleep(5000);
        timer.schedule(goodTask, 10);
    }
}