package com.samit.linkedlist;

public class SinglyLinkedList {

    private ListNode head;

    private static class ListNode {
        private int data;
        private ListNode next;
        public ListNode(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private void insertAtBegining(int data){
        ListNode node=new ListNode(data);
        if (head==null){
            head=node;
        }else{
            node.next=head;
            head=node;
        }
    }

    private void insertAtEnd(int data){
        ListNode node=new ListNode(data);
        if (head==null){
            head=node;
            return;
        }else{
           ListNode current=head;
           while(current.next!=null){
              current=current.next;
           }
           current.next=node;
        }
    }
    private void insertAtMid(int pos,int data){
        ListNode node=new ListNode(data);
        if (head==null){
            head=node;
            return;
        }else{
            int count=1;
            ListNode firstNode=head;
            while(count!=pos-1){
                firstNode=firstNode.next;
                count++;
            } 
            ListNode secondNode= firstNode.next;
            firstNode.next=node;
            node.next=secondNode;  
        }
    }

    private void display() {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.println("null");
    }
    
    private void deleteLast() {
    	ListNode temp = head;
    	while (temp.next.next!=null) {
    		temp=temp.next;
    	}
    	temp.next=null;
    }

    private void deleteFirst(){
    	if (head==null) {
    		return;
    	}else {
    		ListNode temp=head;
    		head=head.next;
    		temp.next=null;
    	}
    }
    
    private void deleteAtMid(int pos){
        if (head==null){
            return;
        }else{
            int count=1;
            ListNode firstNode=head;
            while(count!=pos-1){
                firstNode=firstNode.next;
                count++;
            } 
            ListNode secondNode= firstNode.next.next;
            firstNode.next=secondNode;
        }
    }

    public static void main(String[] args) {
        SinglyLinkedList sll = new SinglyLinkedList();
        sll.head = new ListNode(10);
        System.out.println("Before insert at begining....");
        sll.display();
        sll.insertAtBegining(8);
        System.out.println("After insert at Begining....");
        sll.display();

        System.out.println("Before insert at End....");
        sll.display();
        sll.insertAtEnd(12);
        System.out.println("After insert at End....");
        sll.display();

        System.out.println("Before insert at Middle....");
        sll.display();
        sll.insertAtMid(2, 11);
        System.out.println("After insert at Middle....");
        sll.display();
        
//        System.out.println("Delete the node from the Beginning");
//        sll.deleteFirst();
//        sll.display();
//        
//        System.out.println("Delete the node from the Last");
//        sll.deleteLast();
//        sll.display();
        
        int data=2;
        System.out.println("Delete the node from the given position at "+data);
        sll.deleteAtMid(data);
        sll.display();
    }
}
