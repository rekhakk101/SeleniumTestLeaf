package week3.day2.Assignment2_Strings;

import java.util.Arrays;

public class Anagram {

	public static void main(String[] args) {

//	*Declare a String 
		String text1 = "stops";

//	 *Declare another String
		String text2 = "potss";

//	 * a) Check length of the strings are same then (Use A Condition)
//	* b) Convert both Strings in to characters
//	* c) Sort Both the arrays
//	* d) Check both the arrays has same value
		if (text1.length() == text2.length()) {
			char[] charArray1 = text1.toCharArray();
			char[] charArray2 = text2.toCharArray();
			Arrays.sort(charArray1);
			Arrays.sort(charArray2);
			boolean equals = Arrays.equals(charArray1, charArray2);
			if (equals) {
				System.out.println("Strings are Anagram");
			}
		} else {
			System.out.println("Strings are not Anagram");
		}

	}

}
