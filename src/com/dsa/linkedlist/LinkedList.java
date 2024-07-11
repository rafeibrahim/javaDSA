package com.dsa.linkedlist;

public class LinkedList {
	
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
	
	public void addFirst (int data) {
		
		Node newNode = new Node(data);
		size++;
		if (head == null) {
			head = newNode;
			tail = head;
			return;
		}
		
		newNode.next = head;
		head = newNode;
	}
	
	public void addLast (int data) {
		Node newNode = new Node(data);
		size++;
		if (head == null) {
			head = tail = newNode;
		}
		
		tail.next = newNode;
		tail = newNode;
	}
	
	public void add(int index, int data) {
		if (index == 0) {
			addFirst(data);
			return;
		}
		Node newNode = new Node(data);
		size++;
		Node prevNode = head;
		for (int i=0; i<index-1; i++) {
			prevNode = prevNode.next;
		}
		
		//curr Node is one step behind where new node should be placed
		Node nextNode = prevNode.next;
		prevNode.next = newNode;
		newNode.next = nextNode;
	}

//  this is my code for remove first from LL
//	public int removeFirst () {
//		if (size == 0) {
//			System.out.println("LL is empty");
//			return Integer.MIN_VALUE;
//		}
//		
//		
//		int val = head.data;
//		// in case of 1 element;
//		if (size == 1) {
//			tail = null;
//		}
//		
//		head = head.next;
//		size--;
//		return val;
//	}
	
	public int removeFirst() {
		if(size == 0) {
			System.out.println("LL is empty");
			return Integer.MIN_VALUE;
		}else if (size == 1){
			int val = head.data;
			head = tail = null;
			size = 0;
			return val;
		}
		int val = head.data;
		head = head.next;
		size--;
		return val;
	}
	
	
	// this is my code for removeLast
//	public int removeLast() {
//		//if LL has 0 node
//		if (size == 0) {
//			System.out.println("LL is empty");
//			return Integer.MIN_VALUE;
//		}
//		//if LL has one node
//		if (size == 1) {
//			int val = tail.data;
//			head = tail = null;
//			size--;
//			return val;
//		}
//		
//		int i = 0;
//		Node temp = head;
//		
//		// we need to go until secondLast Node
//		// this loop always points to the next Node.
//		//for index to point at secondLast we should go 
//		// to one index less that second Last.
//		while (i < size-2) {
//			temp = temp.next;
//			i++;
//		}
//		
//		// i -> secondLast-1 node index
//		// temp -> pointing to secondLast Node
//		
//		int val = tail.data;
//		//System.out.println("secondLast node->" + temp.data);
//		temp.next = null;
//		tail = temp;
//		size--;
//		return val;
//	}

	
	//class code for removeLast LL
	public int removeLast() {
		if (size == 0) {
			System.out.println("LL is empty");
			return Integer.MIN_VALUE;
		}else if (size == 1) {
			int val = head.data;
			head = tail = null;
			size = 0;
			return val;
		}
		
		Node prev = head;

		for (int i=0; i<size-2; i++) {
			prev = prev.next;
		}
		
		// prev : i = size-2
		int val = prev.next.data;
		prev.next = null;
		size--;
		return val;
	}
	
	
	public int size() {
		Node currNode = head;
		int size = 0;
		while (currNode != null) {
			currNode = currNode.next;
			size++;
		}
		return size;
	}
	
	public void print () {
		if (head == null) {
			System.out.println("null");
			return;
		}
		
		Node tempNode = head;
		while (tempNode != null)  {
			System.out.print(tempNode.data + "->");
			tempNode = tempNode.next;
		} 
		System.out.println("null");
	}
	
	//my code search iterative in LL
//	public int itrSearch(int key) {
//		Node temp = head;
//		
//		for (int i=0; i<size; i++) {
//			if(temp.data == key) {
//				return i;
//			}
//			temp = temp.next;
//		}
//		
//		return -1;
//	}
	
	public int itrSearch(int key) {
		Node temp = head;
		int i = 0;
		
		while (temp != null) {
			if (temp.data == key) {
				return i;
			}
			temp = temp.next;
			i++;
		}
		return -1;
	}
	
	public int recSearch (int key, Node head, int i) {
		if (head == null) {
			return -1;
		}
		
		if (head.data == key) {
			return i;
		}
		return recSearch(key, head.next, ++i);
	}
	
	
	public static void main (String args[]) {
		LinkedList ll = new LinkedList();
		ll.print();
		ll.addFirst(2);
		ll.addFirst(1);
		ll.addLast(4);
		ll.print();
		ll.addLast(5);
		ll.print();
		//System.out.println(ll.size());
		ll.add(2, 3);
		ll.print();
		//System.out.println(ll.tail.data);
		//System.out.println(ll.size);
//		ll.add(0, 3);
//		ll.print();
		
		//removeFirst test code
		
//		ll.removeFirst();
//		ll.print();
//		ll.removeFirst();ll.removeFirst();ll.removeFirst();
//		ll.print();
//		System.out.println(ll.head + " " +  ll.tail);
//		ll.removeFirst();
//		ll.print();
//		System.out.println(ll.size);
//		System.out.println(ll.head + " " +  ll.tail);
//		ll.removeFirst();
		
//		System.out.println(ll.removeLast());
//		ll.print();
//		ll.removeLast(); ll.removeLast(); ll.removeLast();
//		ll.print();
//		ll.removeLast();
//		ll.print();
//		ll.removeLast();
//		ll.print();
		
//		int index = ll.itrSearch(5);
//		System.out.println(index);
		
		System.out.println(ll.recSearch(6, head, 0));
	}
}

