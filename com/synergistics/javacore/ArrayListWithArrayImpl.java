package com.synergistics.javacore;

import java.util.Arrays;

public class ArrayListWithArrayImpl {

    //Declaring class fields
    //Array that holds the integer
    int[] intArray;
    static final int INITIAL_CAPACITY = 10;
    static final int ENLARGE_CAPACITY = 5;

    //Constructor that will create the initial array
    ArrayListWithArrayImpl(){
        //Creating an initial array of size 10
        this.intArray = new int[INITIAL_CAPACITY];
    }

    //Method to handle the increment of the array incase it hits capacity
    public void put(int value){
        boolean flagInserted = false;
        for (int i = 0; i < intArray.length; i++) {
            if (intArray[i] == 0) {
                intArray[i] = value;
                flagInserted = true;
                break;
            }
        }
        if(flagInserted){
            return;
        }else{
            //We have to resize
            int[] newIntArray = new int[intArray.length+ArrayListWithArrayImpl.ENLARGE_CAPACITY];
            System.arraycopy(intArray,0,newIntArray,0,intArray.length);
            intArray = newIntArray;
            //Now we have to loop and add
            for (int i = 0; i < intArray.length; i++) {
                if (intArray[i] == 0) {
                    intArray[i] = value;
                    break;
                }
            }
        }
    }

    public static void main(String[] args) {
        //Initializing the array and adding elements to it
        ArrayListWithArrayImpl array = new ArrayListWithArrayImpl();
        //Fillling the elements of the array
        for(int i = 0; i <= 5; i++){
            //.intArray[i] = i;
            array.put(i);
        }

        //Putting 2nd set that exceeds limit
        for(int i = 6; i <= 12; i++){
            //.intArray[i] = i;
            array.put(i);
        }

        for(int i = 13; i <= 25; i++){
            //.intArray[i] = i;
            array.put(i);
        }


        for(int i = 0; i < array.intArray.length; i++){
            System.out.print(array.intArray[i] + " , ");
        }
    }
}
