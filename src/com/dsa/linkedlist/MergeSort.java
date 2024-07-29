package com.dsa.linkedlist;


public class MergeSort {
	
	public static class LinkedList {
		
		public static class Node {
			int data;
			Node next;
			
			public Node (int data) {
				this.data = data;
				this.next = null;
			}
		}
		
		public static Node head;
		public static Node tail;
		
		public static void addFirst(int data) {
			
			Node newNode = new Node(data);
			
			if (head == null) {
				head = newNode;
				tail = newNode;
				return;
			}
	
			newNode.next = head;
			head = newNode;
		}
		
		public static void print() {	
			Node temp = head;
			while (temp != null) {
				System.out.print(temp.data + "->");
				temp = temp.next;
				
			}
			System.out.println("null");
		}
		
		public Node getMid(Node head) {
			Node slow = head;
			Node fast = head.next;
			
			while (fast != null && fast.next != null) {
				slow = slow.next;
				fast = fast.next.next;
			}
			
			return slow; //mid node
		}
		
		public Node merge (Node head1, Node head2){
			Node mergedLL = new Node(-1);
			Node temp = mergedLL;
			
			while (head1 != null && head2 != null) {
				if (head1.data <= head2.data) {
					temp.next = head1;
					temp = temp.next;
					head1 = head1.next;
					break;
				} 
				temp.next = head2;
				temp = temp.next;
				head2 = head2.next;
			}
			
			while (head1 != null) {
				temp.next = head1;
				temp = temp.next;
				head1 = head1.next;
			}
			
			while (head2 != null) {
				temp.next = head2;
				temp = temp.next;
				head2 = head2.next;
			}
			
			return mergedLL.next;
			
		}
		
		public Node mergeSort(Node head) {
			//base case
			if (head == null || head.next == null) {
				return head;
			}
			
			//find mid
			Node mid = getMid(head);
			
			//left and right MS
			Node rightHead = mid.next;
			mid.next = null;
			Node newLeft = mergeSort(head);
			Node newRight = mergeSort(rightHead);
			
			//merge
			return merge(newLeft, newRight);
			
			
		}
	}
	
	public static void main(String args[]) {
		LinkedList ll = new LinkedList();

		ll.addFirst(1);
		ll.addFirst(2);
		ll.addFirst(3);
		ll.addFirst(4);
		ll.addFirst(5);
		ll.print();
		
		ll.head = ll.mergeSort(ll.head);
		ll.print();

	}

}
