package com.utilities;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class TypeStringUtil {
  	/* -----------------------------------------------------
    Convertion
	----------------------------------------------------- */

    public static String convert(Integer[] numbers)
    {
        return Arrays.toString(numbers);
    }
    public static String convert(String[] numbers)
    {
        return Arrays.toString(numbers);
    }

    public static String[] convert(List<String> myList)
    {
        String[] result = new String[ myList.size() ];
        return myList.toArray(result);
    }
    public static String[] convert(Set<String> mySet)
    {
        String[] result = new String[ mySet.size() ];
        return mySet.toArray(result);
    }

  	/* -----------------------------------------------------
    For testing purpose
	----------------------------------------------------- */

    public static void main(String[] args) {
        Integer[] number = new Integer[5];
        number[0] = 2;
        number[1] = -5;
        number[2] = 0;
        number[3] = -5;
        number[4] = 0;
        System.out.println( convert(number) );

        String[] text = new String[5];
        text[0] = "text 0";
        text[1] = "text 1";
        text[2] = "text 2";
        text[3] = "text 3";
        text[4] = "text 4";
        System.out.println( convert(text) );
    }
}
