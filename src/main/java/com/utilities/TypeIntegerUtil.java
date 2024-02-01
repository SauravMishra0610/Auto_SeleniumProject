package com.utilities;

import java.util.*;

public class TypeIntegerUtil {
    public static void display(Integer[] numbers) {
        System.out.println("Values of the List:");
        for (int i=0, size=numbers.length; i<size; i++) {
            System.out.println("index="+ i +", value="+ numbers[i]);
        }
    }

  	/* -----------------------------------------------------
    Convertion
	----------------------------------------------------- */

    public static Integer[] convert(List<Integer> numbers)
    {
        return numbers.toArray( new Integer[numbers.size()] );
    }
    public static Integer[] convert(Set<Integer> numbers)
    {
        return numbers.toArray( new Integer[numbers.size()] );
    }

  	/* -----------------------------------------------------
    Others
	----------------------------------------------------- */

    public static boolean checkDuplicate(Integer[] numbers)
    {
        Set<Integer> mySet = new HashSet<>();
        for (int i=0, size=numbers.length; i<size; i++) {
            mySet.add(numbers[i]);
        }
        return (mySet.size() != numbers.length)? true : false;
    }
    public static Integer[] sort(Integer[] numbers)
    {
        Integer[] sortedNumbers = new Integer[numbers.length];
        System.arraycopy( numbers, 0, sortedNumbers, 0, numbers.length);	//COPY ARRAYLIST

        Arrays.sort(sortedNumbers);
        return sortedNumbers;
    }

  	/* -----------------------------------------------------
    For testing purpose
	----------------------------------------------------- */

    public static void main(String[] args) {
        Integer[] number = new Integer[3];
        number[0] = 2;
        number[1] = 0;
        number[2] = -5;
        number = sort(number);
        display(number);

        List<Integer> myList = new ArrayList<>();
        myList.add(2);
        myList.add(0);
        myList.add(-5);
        Integer[] nb = convert(myList);
        display(nb);
    }
}

