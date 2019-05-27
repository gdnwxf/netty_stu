package com.hzins.thrift.demo;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

public class ContinueEx {

    public static void main(String[] args) throws InterruptedException {


        Thread thread = new Thread(  new Runnable() {
            @Override
            public void run() {
                while(true) {

                    System.out.println("dsadsa");

                    try {
                        TimeUnit.SECONDS.sleep(3);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }

        });


       thread.start();

       TimeUnit.SECONDS.sleep(10);


        System.out.println("第三季度解散");

        thread.interrupt();

        TimeUnit.SECONDS.sleep(10);

        System.out.println("jvoer");

    }
}
