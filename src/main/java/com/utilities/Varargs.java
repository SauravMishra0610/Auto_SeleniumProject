package com.utilities;

public class Varargs {
    public static void test(String... text) {
        String textToDisplay = (text.length>0)? text[0] : "N/A";
        System.out.println(textToDisplay);
    }

    public static void main(String[] args) {
        test("Hello world");
        test();
    }
}
