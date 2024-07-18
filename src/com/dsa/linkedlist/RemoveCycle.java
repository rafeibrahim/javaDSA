package com.dsa.linkedlist;

public class RemoveCycle {
	
	public static class LinkedList {
		
		public static class Node {
			int data;
			Node next;
			
			public Node(int data) {
				this.data = data;
				this.next = null;
			}
	}
		public static Node head;
		public static Node tail;
		public static int size;
		
		public static void print() {
			Node temp = head;
			while (temp != null) {
				System.out.print(temp.data + "->");
				temp = temp.next;
			}
			System.out.println("null");
		}
		
		//Floyd's cycle finding algorithm
		public static boolean isCycle() {
			Node slow = head;
			Node fast = head;
			
			while (fast != null && fast.next != null) {
				slow = slow.next;
				fast = fast.next.next;
				if(slow == fast) {
					return true;
				}
			}
			return false;
			
		}
		
		//this function do not work if whole list is a cycle.
		//i.e. tail points to the head.
		
		public static void removeCycle() {
			
			//step:1 detect a cycle
			Node slow = head;
			Node fast = head;
			boolean cycle = false;
			
			while(fast != null && fast.next != null) {
				slow = slow.next;
				fast = fast.next.next;
				if(slow == fast) {
					cycle = true;
					break;
				}
			}
			
			if (cycle == false) {
				return;
			}
			
			//cycle found
			//step:2 find meeting point
			
			slow = head;
			Node prev = null;
			
			while (slow != fast) {
				slow = slow.next;
				prev = fast;
				fast = fast.next;
			}
			
			//step3: remove cycle -> prev.next = null
			
			prev.next = null;
			
			
		}
	}
	
	public static void main(String args[]) {
		LinkedList.head = new LinkedList.Node(1);
		LinkedList.Node temp = new LinkedList.Node(2);
		LinkedList.head.next = temp;
		LinkedList.head.next.next = new LinkedList.Node(3);
		LinkedList.head.next.next.next = temp;
		
		System.out.println(LinkedList.isCycle());
		
		LinkedList.removeCycle();
		
		System.out.println(LinkedList.isCycle());

		LinkedList.print();
	}

}
