package org.howard.edu.lsp.assignment5.implementation;
import java.util.*;

public class IntegerSetException extends Exception {
	
	private static final long serialVersionUID = 1L;

	public IntegerSetException() {
		ArrayList<Integer> someList = new ArrayList<Integer>();
	if(someList.isEmpty())
		throw new RuntimeException();
	}
}
