package com.samit.linkedlist;

import java.util.HashMap;
import java.util.Map;

class Clone{
    int data;
    Clone next;
    Clone random;
    public Clone(int data){
        this.data=data;
        this.next=null;
        this.random=null;
    }
}
public class CloneLinkedList {

    public static Clone cloneList(Clone head){
        Map<Clone,Clone> maps=new HashMap<>();
        Clone curr=head;
        while (curr!=null){
            maps.put(curr,new Clone(curr.data));
            curr=curr.next;
        }
        curr=head;
        while (curr!=null){
            Clone clone=maps.get(curr);
            clone.next=maps.get(curr.next);
            clone.random=maps.get(curr.random);
            curr=curr.next;
        }
        return maps.get(head);
    }

    public static void printList(Clone head){
        Clone curr=head;
        while (curr!=null){
            System.out.print(curr.data+" ");
            curr=curr.next;
        }
    }

    public static void main(String[] args) {
        Clone head=new Clone(10);
        Clone second=new Clone(5);
        Clone third=new Clone(20);
        Clone fourth=new Clone(15);
        Clone five=new Clone(20);
        head.next=second;
        second.next=third;
        third.next=fourth;
        fourth.next=five;
        head.random=third;
        second.random=fourth;
        third.random=head;
        fourth.random=third;
        five.random=fourth;
        System.out.println();
        printList(head);
        System.out.println();
        Clone cloned=cloneList(head);
        printList(cloned);
    }
}
