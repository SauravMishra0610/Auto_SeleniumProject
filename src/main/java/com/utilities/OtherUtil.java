package com.utilities;

public class OtherUtil {
    public static void wait(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        }catch(Exception e) {
            // ignore
        }
    }

    public static void main(String[] args) {
        System.out.println("BEGIN");
        wait(2000);
        System.out.println("END");
    }
}
