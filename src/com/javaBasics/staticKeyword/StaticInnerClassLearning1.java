package com.javaBasics.staticKeyword;

public class StaticInnerClassLearning1 {
	
	
	private static class LinkedList {
		
		public static class Node {
			int data;
			Node next;
			
			public Node(int data) {
				this.data = data;
				this.next = null;
			}
		}
		
		private static Node head;
		private static Node tail;
		
		
		public static void addFirst(int data) {
			//First we need to create node to be added
			
			//LinkedList.Node newNode = new LinkedList.Node(data);
			
			Node newNode = new Node(data);
			
			if (head == null) {
				head = tail = newNode;
				return;
			}
			
			newNode.next = head;
			head = newNode;
		}
		
		public static void print() {
			Node temp = head;
			
			while(temp != null) {
				System.out.print(temp.data + "->");
				temp = temp.next;
			}
			
			System.out.println("null");
		}
	}
	
	private class Car{
		String name;
		int age;
		
		public void print() {
			System.out.println("Car printed");
		}
	}
	
	
	
	
	
	public static void main(String args[]) {
		
		//not allowing to create new Car(inner non-static class) without 
		//instantiating outerclass.
		StaticInnerClassLearning1 scl = new StaticInnerClassLearning1();
		StaticInnerClassLearning1.Car myCar = scl.new Car();
		myCar.print();
		
		
		
		//Ideal reference to inner static class
		StaticInnerClassLearning1.LinkedList.print();
		
		
		//Inner static class can be referenced inside outerclass
		//just by its name.
		LinkedList.addFirst(1);
		LinkedList.addFirst(2);
		LinkedList.addFirst(3);
		LinkedList.addFirst(4);
		LinkedList.addFirst(5);
		LinkedList.print();
		
	}

}
