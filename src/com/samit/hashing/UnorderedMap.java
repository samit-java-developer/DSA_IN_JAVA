package com.samit.hashing;

import java.util.*;

// Node class for linked list implementation
class Node<T> {
    String key;
    T value;
    Node<T> next;

    // Constructor
    public Node(String key, T value) {
        this.key = key;
        this.value = value;
        this.next = null;
    }

    // Copy constructor
    public Node(Node<T> obj) {
        this.key = obj.key;
        this.value = obj.value;
        this.next = null;
    }
}

// HashMap class (unordered_map equivalent)
public class UnorderedMap<T> {
    private int numOfElements, capacity;
    private Node<T>[] arr;

    // Constructor
    public UnorderedMap() {
        this.capacity = 32;
        this.numOfElements = 0;
        this.arr = new Node[this.capacity];
        Arrays.fill(this.arr, null);
    }

    // Hash function to map string key to an index
    private int hashFunction(String key) {
        int bucketIndex;
        long sum = 0, factor = 31;
        for (int i = 0; i < key.length(); i++) {
            sum = ((sum % this.capacity) + ((int) key.charAt(i) * factor) % this.capacity) % this.capacity;
            factor = (factor * 31) % Integer.MAX_VALUE;
        }
        bucketIndex = (int) sum;
        return bucketIndex;
    }

    // Get the load factor of the map
    private float getLoadFactor() {
        return (float) (this.numOfElements + 1) / (float) this.capacity;
    }

    // Rehashing function to resize and rehash the data when load factor exceeds 0.5
    private void rehashing() {
        this.numOfElements=0;
        int oldCapacity = this.capacity;
        Node<T>[] temp = this.arr; // temp holds the old array

        this.capacity = oldCapacity * 2; // Double the capacity
        this.arr = new Node[this.capacity]; // New array of doubled capacity

        Arrays.fill(this.arr, null);

        // Rehash all elements into the new array
        for (int i = 0; i < oldCapacity; i++) {
            Node<T> currBucketHead = temp[i];
            while (currBucketHead != null) {
                this.insert(currBucketHead.key, currBucketHead.value); // Reinsert using the new hash function
                currBucketHead = currBucketHead.next;
            }
        }
    }

    // Insert a key-value pair into the hash map
    public void insert(String key, T value) {
        while (this.getLoadFactor() > 0.5f) { // If load factor exceeds 0.5, rehash
            this.rehashing();
        }

        int bucketIndex = this.hashFunction(key);

        if (this.arr[bucketIndex] == null) { // No linked list at the bucket
            Node<T> newNode = new Node<>(key, value);
            this.arr[bucketIndex] = newNode;
        } else { // Add to the head of the existing linked list
            Node<T> newNode = new Node<>(key, value);
            newNode.next = this.arr[bucketIndex];
            this.arr[bucketIndex] = newNode;
        }

        this.numOfElements++; // Increase the count of elements
    }

    // Search for a value by key
    public T search(String key) {
        int bucketIndex = this.hashFunction(key);
        Node<T> bucketHead = this.arr[bucketIndex];

        while (bucketHead != null) {
            if (bucketHead.key.equals(key)) {
                return bucketHead.value;
            }
            bucketHead = bucketHead.next;
        }

        System.out.println("Oops!! Data not found.");
        return null; // Return null if not found
    }

    public static void main(String[] args) {
        UnorderedMap<Integer> mp = new UnorderedMap<>(); // Integer values, String keys
        mp.insert("Manish", 16);
        mp.insert("Vartika", 14);
        mp.insert("ITT", 5);
        mp.insert("elite_Programmer", 4);
        mp.insert("pluto14", 14);
        mp.insert("GeeksForGeeks", 11);

        // Display search results
        System.out.println("Value of GeeksForGeeks: " + mp.search("GeeksForGeeks"));
        System.out.println("Value of ITT: " + mp.search("ITT"));
        System.out.println("Value of Manish: " + mp.search("Manish"));
        System.out.println("Value of Vartika: " + mp.search("Vartika"));
        System.out.println("Value of elite_Programmer: " + mp.search("elite_Programmer"));
        System.out.println("Value of pluto14: " + mp.search("pluto14"));

        // Case when key is not present in Hash Map
        mp.search("GFG"); // Prints "Oops!! Data not found."

        System.out.println();
    }
}