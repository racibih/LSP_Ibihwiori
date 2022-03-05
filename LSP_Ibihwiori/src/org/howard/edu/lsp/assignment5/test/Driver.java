package org.howard.edu.lsp.assignment5.test;

import java.util.*;

import org.howard.edu.lsp.assignment5.implementation.IntegerSet;
import org.howard.edu.lsp.assignment5.implementation.IntegerSetException;

public class Driver {

	public static void main(String[] args) {
		IntegerSet setA = new IntegerSet();
		IntegerSet setB = new IntegerSet();

		setA.add(3);
		setA.add(6);
		setA.add(7);
		
		setB.add(2);
		setB.add(8);
		setB.add(3);
		setB.add(7);
		
		
		
		setB.intersect(setA);
		setB.toString();
		List<String> newList = new LinkedList<String>();
		newList.add("first string");
		
		setA.clear();
		setA.add(2);
		setA.add(1);
		setA.add(15);
		setB.add(4);
		
		setB.clear();
		setB.add(0);
		setB.add(1);
		setB.add(40);
		setB.add(3);
		setB.diff(setA);
		
		System.out.println("Set B is:" +setB.toString());
		System.out.println("Set A is:" +setA.toString());
		try {
			System.out.println("The smallest value in Set B is:" +setB.smallest());
		} catch (IntegerSetException e) {
			System.out.println("IntegerSetException");
			}


	}
}
