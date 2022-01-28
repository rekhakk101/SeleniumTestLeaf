package week3.day2.Assignment2_Strings;

public class CharOccurance {

	public static void main(String[] args) {

		// Check number of occurrences of a char (eg 'e') in a String
		String str = "welcome to chennai";
		char ch = 'e';

		// declare and initialize a variable count to store the number of occurrences
		int count = 0;

		// convert the string into char array
		char[] charArray = str.toCharArray();

		// get the length of the array
		int length = charArray.length;

		// traverse from 0 till the array length
		// Check the char array has the particular char in it
		// if is has increment the count
		for (int i = 0; i <= length - 1; i++) {
			if (charArray[i] == ch) {
				count++;
			}
		}

		// print the count out of the loop
		System.out.println("Occurance of " + ch + " in '" + str + "' is " + count);

	}

}
