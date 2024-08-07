package com.dsa.linkedlist;
import java.util.LinkedList;

//Java Collection Framework -> optimized
// we get best time complexity functions 


public class Classroom {
	
	public static void main (String args[]) {
		
		//create - objects int, float, boolean -> Integer, Float, Character
		//cannot use primitive data type for creating LinkedList
		
		LinkedList<Integer> ll = new LinkedList<>();
		
		//add
		ll.addLast(1);
		ll.addLast(2);
		ll.addFirst(0);
		
		//0->1->2
		System.out.println(ll);
		
		//remove
		ll.removeLast();
		ll.removeFirst();
		System.out.println(ll);
	}

}
