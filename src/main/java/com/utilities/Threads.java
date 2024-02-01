package com.utilities;

public class Threads {
    public static void main(String args[]) {
        final int NB_THREADS = 5;

        Thread thread1 = new Thread() {
            public void run() {
                for (int i = 0; i < NB_THREADS; i++) {
                    System.out.println(i + " - this is thread1");
                }
            }
        };
        Thread thread2 = new Thread() {
            public void run() {
                for (int i = 0; i < NB_THREADS; i++) {
                    System.out.println(i + " - this is thread2");
                }
            }
        };
        thread1.start();
        thread2.start();
    }
}