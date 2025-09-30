package com.synergistics.javacore;

sealed interface Shape permits Circle,Rectangle,Square {
    //declaring abstract method for shapes such triange, square, rectangle
    int getArea();
    default int getPerimeter(){
        //This is a default implementation
        //We are simply going to print 0
        return 0;
    }
    //Using the static method simply to print a statement
    static void print(String shapeName, int area, int perimeter){
        System.out.println("Details of the " + shapeName + " ****");
        System.out.println("Area::" + area);
        System.out.println("Perimeter::" + perimeter);
    }
}

final class Circle implements Shape{
    private static float pi = 3.14f;
    int radius;
    String name;
    //Constructor to instantiate class fields
    Circle(int radius,String name){
        this.radius = radius;
        this.name = name;
    }

    @Override
    public int getArea(){
        return (int)(pi*radius*radius);
    }

    //Overriding the default interface method
    @Override
    public int getPerimeter(){
        return (int)(pi*radius);
    }

}

non-sealed class Rectangle implements Shape{
    int length;
    int width;
    String name;

    Rectangle(int length, int width,String name){
        this.length = length;
        this.width = width;
        this.name = name;
    }
    public int getArea(){
        return length * width;
    }
    @Override
    public int getPerimeter(){
        return (int)(this.length + this.width);
    }
}

non-sealed class Square implements Shape{
    int side;
    String name;
    Square(int side,String name){
        this.side = side;
        this.name = name;
    }
    public int getArea(){
        return side * side;
    }
    @Override
    public int getPerimeter(){
        return (int)(this.side + this.side);
    }
}

public class SealedClassDemo {

    public static void main(String[] args) {

        //Create instances of shapes above
        //Circle shape = new Circle(4,"Circle");
        Rectangle shape = new Rectangle(3,4,"Rectangle");
        //Square shape = new Square(4,"Square");

        //Calling static method and passing one of the above cases to determine the area
        int[] result = getShapeDetails(shape);

        //Calling the sealed interface static method to print results
        Shape.print(shape.name, result[0],result[1]);



    }

    //Method that will accept the shape as passed and determine the area and perimeter
    public static int[] getShapeDetails(Shape s){
        //Using enhanced switch function to determine the class in play and get appropriate are
        int area = switch(s){
            case Circle circle -> s.getArea();
            case Rectangle rectange -> s.getArea();
            case Square square -> s.getArea();
        };

        int perimeter = switch(s){
            case Circle circle -> s.getPerimeter();
            case Rectangle rectange -> s.getPerimeter();
            case Square square -> s.getPerimeter();
        };

        int[] results = new int[2];
        results[0] = area;
        results[1] = perimeter;

        return results;

    }
}
