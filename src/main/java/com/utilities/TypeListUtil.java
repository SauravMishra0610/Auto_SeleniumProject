package com.utilities;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class TypeListUtil {
    public static void display(List<?> myList) {
        System.out.println("Values of the List:");
        // The easy way but slow if myList is a LinkedList
        /*
        for (int i=0, size=myList.size(); i<size; i++) {
            System.out.println("value=" + myList.get(i));
        }
        */

        // Iterator way
        /*
        Iterator<?> iterator = myList.iterator();
        while (iterator.hasNext()) {
            System.out.println("value=" + iterator.next());
        }
        */

        // Java 1.8
        myList.stream().forEach(elem -> System.out.println("value=" + elem));
    }

  	/* -----------------------------------------------------
    Convertion
	----------------------------------------------------- */

    public static List<Integer> convert(int[] myArray) {
        List<Integer> result = new LinkedList<>();
        for (int i=0, size=myArray.length; i<size; i++) {
            result.add(myArray[i]);
        }
        return result;
    }
    public static List<Integer> convert(Integer[] numbers)
    {
        return Arrays.asList(numbers);
    }
    public static List<String> convert(String[] numbers)
    {
        return Arrays.asList(numbers);
    }

  	/* -----------------------------------------------------
    For testing purpose
	----------------------------------------------------- */

    public static void main(String[] args) {
        // Testing displaying any primitive list
        List<Integer> myList = new ArrayList<>();
        myList.add(2);
        myList.add(0);
        myList.add(-5);
        display(myList);

        List<String> myList2 = new ArrayList<>();
        myList2.add("a");
        myList2.add("b");
        myList2.add("c");
        display(myList2);

        // Testing conversion methods:
        int[] nb = {2, 0, -5};
        List<Integer> list_nb = convert(nb);
        display(list_nb);

        Integer[] number = new Integer[3];
        number[0] = 2;
        number[1] = 0;
        number[2] = -5;
        List<Integer> list_number = convert(number);
        display(list_number);
    }
}
