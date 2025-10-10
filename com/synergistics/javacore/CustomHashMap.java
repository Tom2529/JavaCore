package com.synergistics.javacore;

import com.synergistics.dsadynamicdslinkedlist.Node;

public class CustomHashMap {

    //Class fields
    //This field is to set size of the Array
    private final static int MAP_SIZE = 7;
    //The array which
    private Node[] mapEntry;

    //Nested inner class that holds the definition of the Node needed for the implementation
    //This node mimics the Map.Entry object of a real hashmap
    class Node {

        String key;
        int value;
        Node next;

        //Constructor that is used to assign the value
        public Node(String key,int data){
            this.key = key;
            this.value = data;
            //Pointer is automatically set to null
        }
    }

    //Constructor to initialize the Array of the hashmap
    CustomHashMap(){
        mapEntry = new Node[MAP_SIZE];
    }

    //Helper function to create hash and determine index in mapEntry array
    //we add all the ASCII character values and modulo with 7 to
    // find the poistion where the key-value need to be added
    public int getHash(String key){
        int index = 0;
        int sum = 0;
        char[] charArray = key.toCharArray();
        //Loop through and get ASCII value for each alphabet
        for(char ch: charArray){
            sum += ch;
        }
        //This next steps returns a value between 0 and 6 as remainder
        index = sum % 7;
        return index;
    }

    //Method to add key-value pair to map
    public void set(String key, int value){
        //Step 1: Create a new Node that needs to be added
        Node newNode = new Node(key,value);
        //Step 1: find the index on mapEntry where item needs to be put
        int index = getHash(key);
        //Step 3: Determine if the index has any nodes already on it
        //Empty location
        if(mapEntry[index] == null){
            mapEntry[index] = newNode;
        }else{
            //Add new Node to end of the linked list
            Node temp = mapEntry[index];
            //Loop till we get to the 2nd last location
            while(temp.next != null){
                temp = temp.next;
            }
            //Link the new node to be end
            temp.next = newNode;
        }
    }

    //Method to get values from Map
    public String get(String key){
        String response = "Invalid Key";
        //Step 1: find the index on mapEntry where item needs to be put
        int index = getHash(key);
        if(mapEntry[index] == null){
            //Do nothing
        }else{
            //Add new Node to end of the linked list
            Node temp = mapEntry[index];
            //Loop till we get to the 2nd last location
            while(temp != null){
                //Check to see if key value is match
                if(temp.key.equals(key)){
                    response = Integer.toString(temp.value);
                    break;
                }
                temp = temp.next;
            }
        }
        return response;
    }

    public static void main(String[] args) {
        //Instantiating the CustomHashMap
        CustomHashMap customHashMap = new CustomHashMap();

        //Adding 3 entries to Map
        customHashMap.set("Isaac",29);
        customHashMap.set("Nala",19);
        customHashMap.set("Rowan",6);
        customHashMap.set("Anaiya",6);
        customHashMap.set("Parminder",4);
        customHashMap.set("Annamma",3);
        customHashMap.set("Biji",12);
        customHashMap.set("Beena",21);

        //Collision is for Biji and Annamma
        System.out.println(customHashMap.get("Isaac"));
        System.out.println(customHashMap.get("Biji"));

        //Invalid case
        System.out.println(customHashMap.get("Tom"));

    }
}
