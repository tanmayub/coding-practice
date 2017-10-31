package com.example.tests;

/**
 * Created by TanmayPC on 10/31/2017.
 */
public class PingPongThread extends Thread {
    private static String turn = "";
    private String msg;
    private static int ct = 0;

    PingPongThread(String msg) {
        this.msg = msg;
    }

    @Override
    public void run() {
        while (ct < 10) {
            playTurn();
            try {
                Thread.sleep(1000);
            }
            catch (Exception e) {
                System.out.println("Exception");
            }
            ct++;
        }
    }

    void playTurn() {
        synchronized (turn) {
            if (!msg.equals(turn)) {
                turn = msg;
                System.out.print(turn);
            }
        }
    }
}

    class Ideone {

    public static void main(String[] args) throws java.lang.Exception {
        // your code goes here
        Ideone i = new Ideone();
        i.manageThreads();
    }

    public void manageThreads() {
        PingPongThread t1 = new PingPongThread("Ping");
        PingPongThread t2 = new PingPongThread("Pong");

        t1.start();
        t2.start();
    }
}
