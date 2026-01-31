package com.samit.linkedlist;

public class CheckLoopInLinkedList {

	private ListNode<Integer> head;

	private static class ListNode<T> {
		private T data;
		private ListNode<T> next;

		public ListNode(T data) {
			this.data = data;
			this.next = null;
		}
	}

	private boolean isContainLoop() {
		ListNode<Integer> fastPtr = head;
		ListNode<Integer> slowPtr = head;
		while (fastPtr != null && fastPtr.next != null) {
			fastPtr = fastPtr.next.next;
			slowPtr = slowPtr.next;
			if (slowPtr == fastPtr) {
				return true;
			}
		}
		return false;
	}

	private void display() {
		ListNode<Integer> temp = head;
		while (temp != null) {
			System.out.print(temp.data + "->");
			temp = temp.next;
		}
		System.out.println("null");
	}

	public static void main(String[] args) {
		CheckLoopInLinkedList sll = new CheckLoopInLinkedList();
		sll.head = new ListNode<Integer>(10);

		ListNode<Integer> first = new ListNode<Integer>(10);
		ListNode<Integer> second = new ListNode<Integer>(10);
		ListNode<Integer> third = new ListNode<Integer>(11);
		ListNode<Integer> fourth = new ListNode<Integer>(11);
		ListNode<Integer> fifth = new ListNode<Integer>(12);
		ListNode<Integer> sixth = new ListNode<Integer>(13);
		ListNode<Integer> seven = new ListNode<Integer>(13);
		ListNode<Integer> eight = new ListNode<Integer>(14);

		sll.head.next = first;
		first.next = second;
		second.next = third;
		third.next = fourth;
		fourth.next = fifth;
		fifth.next = sixth;
		sixth.next = seven;
		seven.next = eight;
		eight.next=third;
		
		System.out.println("Linkedlist contains Loop or not:- "+sll.isContainLoop());
	}
}
