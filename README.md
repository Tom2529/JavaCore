EnumDemo.java -- How to create Singleton pattern using enums. Because ENUMS create public,static,final objects when loaded, there is truly only one instance.

SealedClassDemo -- This class is to show the concepts of sealed interface and how to permit classes to inherit them.
                    Secondly,  the code uses the advanced switch flow for pattern recognition of object passed to it
                    It also shows how default and Static methods can be declared within interface and how to override the default method 

RecordDemoImpl --
This class is to show a couple of things associated with Records
1: How records implement interfaces and if the interface has an abstract method name same as Record,
   you dont have to override
2: Overriding of the canonical non-compact constructor of the Record
3: Record referring to another record

Comparable Vs Comparator
Custom class that shows how to implement the Comparable vs Comparator classes
The advantage with Comparator is that you can do custom implementations such as ordering by Multiple fields
If you need to only do sorting by Natual order, then you can use Comparable

ArrayListWithArrayImpl
This is a custom implementation of an Arraylist using a simple Array
Here we define a couple of constants for the class that sets the initial value of the array. 
Also if the arraySize is exceeded, then we create a new Array using System.arraycopy

CustomHashMap
Implementation of a hashMap. 
The Node has key, value and pointer to next node
A hash function determines the index where the item needs to be added on an array of size 7
if a collision happens, a linked list approach is used to add the new key value pair to end of list
