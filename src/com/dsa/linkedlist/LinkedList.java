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
	
	public static void print () {
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
	
	// my code for recSearch with index i
//	public int recSearch (int key, Node head, int i) {
//		if (head == null) {
//			return -1;
//		}
//		
//		if (head.data == key) {
//			return i;
//		}
//		return recSearch(key, head.next, ++i);
//	}
	
	//my implementation for class logic
	
//	public int recSearch (int key, Node head) {
//		if (head == null) {
//			return -1;
//		}
//		
//		if (head.data == key) {
//			return 0;
//		}
//		
//		int index = recSearch(key, head.next);
//		if (index != -1) {
//			return ++index;
//		}
//		return index;
//	}
	
	// if we want to pass only key to function for recursive 
	// search we will need a helper function which will then 
	// itself recursively to find the index for given key
	
	public static int helper(Node head, int key) {
		//base case
		if (head == null) {
			return -1;
		}
		
		if (head.data == key) {
			return 0;
		}
		
		int idx = helper(head.next, key);
		
		if (idx == -1) {
			return -1;
		}
		return ++idx;
	}
	
	public int recSearch (int key) {
		return helper(head, key);
	}


// my version of reversing LL with creating new Node everytime
//	public void reverse() {
//		Node tempNode = null;
//		Node currNode = head;
//		Node startNode= null;
//		
//		tail = head;
//		for (int i=0; i<size; i++) {
//			System.out.print(currNode.data + " ");
//			//access to the current node
//			tempNode = new Node(currNode.data);
//			tempNode.next = startNode;
//			startNode = tempNode;
//			currNode = currNode.next;
//		}
//		head = startNode;
//		System.out.println();
//	}
	
	public void reverse() {//O(n)
		Node prev = null;
		Node curr = tail = head;
		Node next;
		
		while(curr != null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		
		head = prev;
	}
	
	//my code for removing nth element from Last
//	public void deleteNthFromEnd (int n) {
//		if (n == size) {
//			removeFirst();
//			return;
//		}
//		if (n == 1) {
//			removeLast();
//			return;
//		}
//		
//		
//		//assuming n is 1 based
//		int idx = size - n + 1;
//		System.out.println(idx);
//		Node temp = head;
//		
//		
//		for (int i=2; i<idx; i++) {
//			
//			temp = temp.next;
//			System.out.println("i -> " + i + " node -> " + temp.data);
//		}
//		
//		System.out.println(temp.data);
//		// temp --> one node before node to be removed
//		
//		Node nextNode = temp.next;
//		nextNode = nextNode.next;
//		
//		temp.next = nextNode;
//	}
	
	public void deleteNthFromEnd(int n) {
		//we have size available here as a property of LL
		// but in a coding contest we have to calculate size ourself
		
		int sz = 0;
		Node temp = head;
		while (temp != null) {
			sz++;
			temp = temp.next;
		}
		
		if (n == sz) {
			head = head.next; //remove First operation
			return;
		}
		
		//sz-n
		int i = 1;
		int iToFind = sz-n;
		Node prev = head;
		while (i < iToFind) {
			prev = prev.next;
			i++;
		}
		
		prev.next = prev.next.next;
		return;
	}
	
// not analysed yet whether it will handle empty ll or one node ll
//	public boolean isPalindrome() {
//		// finding size
//		Node temp = head;
//		int sz = 0;
//		
//		while (temp != null) {
//			temp = temp.next;
//			sz++;
//		}
//		
//		//finding midIndex of LL
//		int midIndex = 1 + (size - 1)/2;
//		
//		//reverse LL from midIndex+1 to size
//		// finding node on midIndex
//		
//		Node midNode = head;
//		for (int i=1; i<midIndex; i++) {
//			midNode = midNode.next;
//		}
//		
//		//Reversing LL after midNode;
//		Node curr = midNode.next;
//		Node prev = null;
//		Node next = null;
//		tail = curr;
//		while (curr != null) {
//			next = curr.next;
//			curr.next = prev;
//			prev = curr;
//			curr = next;
//		}
//		
//		//Joining midNode to the first node of reversed LL
//		
//		midNode.next = prev;
//		
//		// we do not need to check whether LL has even or odd nodes 
//		// bcs in both cases we will start our second pointer from 
//		// node (mid+1) until it becomes null;
//		Node i = head;
//		Node j = midNode.next;
//		
//			//if LL is even. 
//			// traverse LL from si to mid and mid+1 to ei 
//			System.out.println("LL is even");
//			while (j != null) {
//				if (i.data != j.data) {
//					return false;
//				}
//				j = j.next;
//				i = i.next;
//			}
//			
//			return true;
//	}
	
	
	// class code for finding mid of a LL
	// used slow fast approach to find mid
	public Node findMid(Node head) {
		Node slow = head; 
		Node fast = head;
		
		while (fast != null && fast.next != null) {
			slow = slow.next; //+1
			fast = fast.next.next; //+2
		}
		
		return  slow; //slow is my midNode
	}
	
	public boolean checkPalindrome () {
		
		if (head == null || head.next == null) {
			return true;
		}
		//step1 - find mid
		Node midNode = findMid(head);
		
		
		//step2 - reverse 2nd half
		Node prev = null;
		Node curr = midNode;
		Node next;
		while (curr != null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
			
		}
		
		Node right = prev; //right half head
		Node left = head; //left half head
		
		//step3 - check left and right half for palindrome
		
		while (right != null) {
			if(right.data != left.data) {
				return false;
			}
			right = right.next;
			left = left.next;
		}
		return true;
	}
	
	public static boolean isCycle() {
		Node slow = head;
		Node fast = head;
		
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow.data == fast.data) {
				return true;
			}
		}
		
		return false;
	}
	
	
	public static void main (String args[]) {
//		LinkedList ll = new LinkedList();
//		ll.print();
//		ll.addFirst(2);
//		ll.addFirst(1);
//		ll.addLast(4);
//		ll.print();
//		ll.addLast(5);
//		ll.print();
		//System.out.println(ll.size());
//		ll.add(2, 3);
//		ll.print();
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
		
//		int index = ll.itrSearch
//		System.out.println(index);
		
//		System.out.println(ll.recSearch(10));
		//ll.reverse();
//		ll.print();
		
//		ll.deleteNthFromEnd(3);
//		ll.print();
//		ll.addLast(5);
//		ll.addLast(4);
//		ll.addLast(3);
//		ll.addLast(2);
		//ll.addLast(9);
//		ll.addLast(1);
//		ll.addLast(2);
//		ll.addLast(1);
//		//ll.addLast(1);
//		ll.print();
//		System.out.println(ll.checkPalindrome());
//		ll.print();
		
		//Creating test ll with a cycle 
		head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		head.next.next.next = head;
		// 1->2->3->1
		System.out.println(isCycle());
		print();
	}
}

