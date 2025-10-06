package com.synergistics.javacore;

import java.util.*;

class ShapeGen<T extends Comparable<T>, U extends Comparable<U>> implements Comparable<ShapeGen<T,U>>{
    T name;
    U area;


    public ShapeGen(T name, U area) {
        this.name = name;
        this.area = area;
    }

    public T getName() {
        return name;
    }

    public void setName(T name) {
        this.name = name;
    }

    public U getArea() {
        return area;
    }

    public void setArea(U area) {
        this.area = area;
    }

    @Override
    public String toString() {
        return "ShapeGen{" +
                "name=" + name +
                ", area=" + area +
                '}';
    }

    @Override
    public int compareTo(ShapeGen<T, U> o) {
        return this.getArea().compareTo(o.getArea());
    }
}

public class ComparableDemo {

    public static void main(String[] args) {
        //Creating the list
        List<ShapeGen<String,Integer>> shapeList = new ArrayList<>();
        //Adding items to list
        shapeList.add(new ShapeGen("Circle",25));
        shapeList.add(new ShapeGen("Triangle",17));
        shapeList.add(new ShapeGen("Rectangle",25));

        System.out.println(shapeList.toString());

        System.out.println("After sorting by Comparable");
        Collections.sort(shapeList);
        System.out.println(shapeList);



    }




}
