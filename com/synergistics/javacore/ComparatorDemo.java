package com.synergistics.javacore;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Person{
    String name;
    int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

class PersonFilterName implements Comparator<Person>{

    @Override
    public int compare(Person o1, Person o2) {
        return o1.getName().compareTo(o2.getName());
    }
}

class PersonFilterAge implements Comparator<Person>{

    @Override
    public int compare(Person o1, Person o2) {
        return Integer.compare(o1.getAge(),o2.getAge());
    }
}


public class ComparatorDemo {

    public static void main(String[] args) {
        List<Person> personList = new ArrayList<>();
        personList.add(new Person("Isaac", 10));
        personList.add(new Person("Nala", 6));
        personList.add(new Person("Anaiya", 8));
        personList.add(new Person("Rowan", 5));

        //displaying unordered list
        System.out.println("Unsorted list");
        System.out.println(personList);

        System.out.println("Sorted List by Name");
        Collections.sort(personList,new PersonFilterName());
        System.out.println(personList);

        System.out.println("Sorted List by Age");
        Collections.sort(personList,new PersonFilterAge());
        System.out.println(personList);
    }

}
