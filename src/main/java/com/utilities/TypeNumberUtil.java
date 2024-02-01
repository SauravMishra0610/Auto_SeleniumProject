package com.utilities;

import java.util.ArrayList;
import java.util.List;

public class TypeNumberUtil {
    public static void display(int[] number) {
        System.out.println("Values of the List:");
        for (int i=0, size=number.length; i<size; i++) {
            System.out.println("index="+ i +", value="+ number[i]);
        }
    }

  	/* -----------------------------------------------------
    Convertion
	----------------------------------------------------- */

    public static int[] convert(List<Integer> myList) {
        if (myList == null) {
            int[] myArray = {};
            return myArray;
        }
        return myList.stream().mapToInt(i->i).toArray();
    }

  	/* -----------------------------------------------------
    For testing purpose
	----------------------------------------------------- */

    public static void main(String[] args) {
        List<Integer> myList = new ArrayList<>();
        myList.add(2);
        myList.add(0);
        myList.add(-5);
        int[] nb = convert(myList);
        display(nb);
    }
}
