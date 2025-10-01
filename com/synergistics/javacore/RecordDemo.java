package com.synergistics.javacore;

/*
This class is to show a couple of things associated with Records
1: How records implement interfaces and if the interface has an abstract method name same as Record,
   you dont have to override
2: Overriding of the canonical non-compact constructor of the Record
3: Record referring to another record
 */

interface RecordInterface{
    //This interface has 2 methods
    //1: An abstract method with name that doesnt match the record datafield type
    //2: An abstract method with name that matches the record datafield type
    void customPrint();
    String name();
}

record Address(String city, String state, String country){
    //Using the default methods of this record
    public Address(String city, String state){
        //Demonstrating constructor chaining in records
        this(city,state,"USA");
    }
}

public record RecordDemo(String name, int age,Address address) implements RecordInterface {

    //Overriding the canonical non-compact constructor
    public RecordDemo(String name, int age,Address address){
        this.name = name;
        this.age= age;
        this.address = address;
    }
    //Even though the interface has 2 methods, we only need to
    @Override
    public void customPrint() {
        System.out.println("Details of Person....");
        System.out.println(this.name());
        System.out.println(this.age());
        System.out.println(this.address.city());
        System.out.println(this.address.state());
        System.out.println(this.address.country());
    }
}
