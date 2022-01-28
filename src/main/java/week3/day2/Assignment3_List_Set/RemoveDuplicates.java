package week3.day2.Assignment3_List_Set;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;

public class RemoveDuplicates {

	public static void main(String[] args) {

//		 * a) Use the declared String text as input
		String text = "We learn java basics as part of java sessions in java week1";
		System.out.println(text);
		String result = "";

//		 * b) Initialize an integer variable as count
		int count = 0;

//		 * c) Split the String into array and iterate over it 
		String[] words = text.split(" ");

//		 * d) Initialize another loop to check whether the word is there in the array
//		 * e) if it is available then increase and count by 1. 
//		 * f) if the count > 1 then replace the word as "" 
//		 
//		 * g) Displaying the String without duplicate words	
		List<String> list = Arrays.asList(words);
		LinkedHashSet<String> set = new LinkedHashSet<String>(list);
		System.out.println(set);

		for (String eachword : set) {
			result = result + eachword + " ";
		}

		System.out.println("String after removing duplicates:");
		System.out.println(result);

	}

}
