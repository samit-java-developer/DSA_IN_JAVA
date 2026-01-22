package com.samit.linkedlist;

import java.util.*;
import java.io.*;
import java.lang.*;

class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
}

public class SimpleTraversal {

    public static void main(String args[]) {
        Node head = new Node(10);
        head.next = new Node(20);
        head.next.next = new Node(30);
        head.next.next.next = new Node(40);
        printlist(head);
        System.out.println();
        printViaRecursion(head);
    }

    public static void printlist(Node head) {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
    }

    public static void printViaRecursion(Node head){
        if (head==null){
            return;
        }
        System.out.print(head.data + " ");
        printViaRecursion(head.next);
    }
} 