package org.howard.edu.lsp.assignment6;

import java.util.*;



public class IntegerSet {
	// private array list set internally accessible from the class Integer set to be used on any methods defined in the class 
	private ArrayList<Integer> newSet = new ArrayList<Integer>();
	
	//to access newSet
	public ArrayList<Integer> getSet() {
		return newSet;
	}
	
	// Default Constructor
	public IntegerSet() {
		
	}

	// Clears the set's internal representation
	public void clear() {
		newSet.clear();
	};

	//returns length of set
	public int length() {
		int size=0;
		size = newSet.size();
		return size;
		}; 
		
	/*
	              * Returns true if the 2 sets are equal, false otherwise;
	 * Two sets are equal if they contain all of the same values in ANY order.
	*/
		
	public boolean equals(IntegerSet b) {
		boolean a = false;
		
		int nsvalue=0;
		int bvalue=0;
		if (newSet.size() == b.newSet.size()) {
			for(int i = 0; i < newSet.size(); i++) {
				nsvalue = newSet.get(i);
				bvalue = b.newSet.get(i);
				if(newSet.contains(bvalue)) {
					a = true;
				}

			}
			
		}
		return a;
	}
	// Returns true if the set contains the value, otherwise false
	public boolean contains(int value) {
		return newSet.contains(value);};    

	// Returns the largest item in the set; Throws a IntegerSetException if the set is empty 
	public int largest() throws IntegerSetException 
	{
		int maxNum = 0;
		maxNum = Collections.max(newSet);
		return maxNum;
	}; 

	// Returns the smallest item in the set; Throws a IntegerSetException if the set is empty
	public int smallest() throws IntegerSetException{
		int minNum = 0;
		minNum = Collections.min(newSet);
		return minNum;
		
	};


		// Adds an item to the set or does nothing it already there	
	
	 public void add(int item) {
		 if (!newSet.contains(item)){
			 newSet.add(item);
		 }
		 
		 
	 }; 

		// Removes an item from the set or does nothing if not there
	
	public void remove(int item) {
		if(newSet.contains(item)) {
			newSet.remove(item);
		}	
	};
	
	
	// Throws a IntegerSetException of the set is empty
	// Set union
	public void union(IntegerSet intSetb) {
		if(newSet.isEmpty()|| intSetb.getSet().isEmpty()) {
			throw new RuntimeException("Empty set in union");
			
		}
		ArrayList<Integer> intSetbList = intSetb.getSet();
		for (int i=0; i < intSetbList.size(); i++) {
			newSet.add((intSetbList.get(i)));
		}
	};



	// Set intersection
	public void intersect(IntegerSet intSetb) {
		newSet.retainAll(intSetb.getSet());
		
	}; 

	// Set difference, i.e., s1 –s2
	public void diff(IntegerSet intSetb) {
		newSet.removeAll(intSetb.getSet());
	}; // set difference, i.e. s1 - s2

	// Returns true if the set is empty, false otherwise
	boolean isEmpty(){
		return newSet.isEmpty();
	}; 

	// Return String representation of your set
	public String toString() {
		return newSet.toString();
		};	
		
} //end class
