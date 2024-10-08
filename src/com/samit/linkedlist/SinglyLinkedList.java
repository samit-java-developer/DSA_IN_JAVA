package com.samit.linkedlist;

public class SinglyLinkedList {
	private ListNode<Integer> head;
	private static class ListNode<T> {
		private T data;
		private ListNode<T> next;

		public ListNode(T data) {
			this.data = data;
			this.next = null;
		}
	}
	private void insertAtBegining(int data) {
		ListNode<Integer> node = new ListNode<Integer>(data);
		if (head == null) {
			head = node;
		} else {
			node.next = head;
			head = node;
		}
	}
	private void insertAtEnd(int data) {
		ListNode<Integer> node = new ListNode<Integer>(data);
		if (head == null) {
			head = node;
			return;
		} else {
			ListNode<Integer> current = head;
			while (current.next != null) {
				current = current.next;
			}
			current.next = node;
		}
	}
	private void insertAtMid(int pos, int data) {
		ListNode<Integer> node = new ListNode<Integer>(data);
		if (head == null) {
			head = node;
			return;
		} else {
			int count = 1;
			ListNode<Integer> firstNode = head;
			while (count != pos - 1) {
				firstNode = firstNode.next;
				count++;
			}
			ListNode<Integer> secondNode = firstNode.next;
			firstNode.next = node;
			node.next = secondNode;
		}
	}
	private void display() {
		ListNode<Integer> temp = head;
		while (temp != null) {
			System.out.print(temp.data + "->");
			temp = temp.next;
		}
		System.out.println("null");
	}
	private void deleteLast() {
		ListNode<Integer> temp = head;
		while (temp.next.next != null) {
			temp = temp.next;
		}
		temp.next = null;
	}
	private void deleteFirst() {
		if (head == null) {
			return;
		} else {
			ListNode<Integer> temp = head;
			head = head.next;
			temp.next = null;
		}
	}
	private void deleteAtMid(int pos) {
		if (head == null) {
			return;
		} else {
			int count = 1;
			ListNode<Integer> firstNode = head;
			while (count != pos - 1) {
				firstNode = firstNode.next;
				count++;
			}
			ListNode<Integer> secondNode = firstNode.next.next;
			firstNode.next = secondNode;
		}
	}
	private ListNode<Integer> getNthNodeFromTheLast(int n) {
		if (head == null) {
			return null;
		}
		if (n <= 0) {
			throw new IllegalArgumentException("Invalid value: n= " + n);
		}
		ListNode<Integer> next = head;
		ListNode<Integer> mainPtr = head;
		while (n != 0) {
			if (next == null) {
				throw new IllegalArgumentException(n + " is greater than the number of nodes in list");
			}
			next = next.next;
			n--;
		}
		while (next != null) {
			next = next.next;
			mainPtr = mainPtr.next;
		}
		return mainPtr;
	}

	private void reverseLinkedList() {
		ListNode<Integer> current = head;
		ListNode<Integer> previous = null;
		ListNode<Integer> next = null;
		while (current != null) {
			next = current.next;
			current.next = previous;
			previous = current;
			current = next;
		}
		head = previous;
	}

	private void removeDuplicateFromTheSortedList() {
		ListNode<Integer> current = head;
		while (current!=null && current.next!=null) {
			if (current.data==current.next.data) {
				current.next=current.next.next;
			}else {
				current=current.next;
			}
		}
	}
	
	public static void main(String[] args) {
		SinglyLinkedList sll = new SinglyLinkedList();
		sll.head = new ListNode<Integer>(10);
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

		/*
		 * System.out.println("Delete the node from the Beginning"); sll.deleteFirst();
		 * sll.display();
		 * 
		 * System.out.println("Delete the node from the Last"); sll.deleteLast();
		 * sll.display();
		 */

		/*
		 * int data = 2;
		 * System.out.println("Delete the node from the given position at " + data);
		 * sll.deleteAtMid(data); sll.display();
		 */

		try {
			System.out.println("Find nth node from the last...");
			ListNode<Integer> temp = sll.getNthNodeFromTheLast(1);
			System.out.println("The value of nth node from the end is "+temp.data);
		} catch (Exception e) {
			System.out.println("\nThe value of n is wrong....\n");
		}
		System.out.println("Reverse the linked list");
		sll.reverseLinkedList();
		sll.display();

	}
}
