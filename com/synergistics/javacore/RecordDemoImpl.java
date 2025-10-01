package com.synergistics.javacore;

public class RecordDemoImpl {

    public static void main(String[] args) {
        //Creating an instance of the Address record first
        Address address = new Address("Los Angeles", "CA");
        RecordDemo person1 = new RecordDemo("Nala",6,address);

        //Displaying the content of the record that refers to another record as well as
        //implements an interface
        person1.customPrint();
    }
}
