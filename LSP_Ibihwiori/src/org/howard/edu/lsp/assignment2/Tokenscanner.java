package org.howard.edu.lsp.assignment2;

import java.util.*;

public class Tokenscanner {

	public static void main(String args[]) {
		Scanner userinput = new Scanner(System.in);
		userinput.useDelimiter("\r\n"); //separate tokens by whitespace in string
		System.out.print("String?");
		while(userinput.hasNext()==true) { //while the user is still entering numbers
		
		String line[] = userinput.nextLine().split(" "); //each word in the string separated by a space gets input into an array
		
		
		//System.out.println(line[0]);
		//System.out.println(line.length());
		if(line[0].equals("Goodbye")) { //when user types goodbye it terminates the program
			break;
		}
		int sum=0;
		int product=1;
		int arr[];
		arr= new int[line.length]; //array to copy array of strings after each element is converted into integers
		//arr[line.length]=0;
		for(int i = 0; i<line.length; i++) {
			
			
			arr[i]= Integer.valueOf(line[i]);
			
		}
		System.out.println("Tokens: ");
		for (int j=0; j<line.length;j++) {
			System.out.println(arr[j]);
			sum+=arr[j]; //sum all of the tokens
			product*=arr[j]; //product all of the tokens
		}
		System.out.println("Sum: "+sum);
		System.out.println("Product: "+product);
		System.out.println("String?");
	}
		
	}
}
