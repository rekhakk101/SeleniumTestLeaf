package week3.day2.Assignment2_Strings;

public class ReverseEvenWords {

	public static void main(String[] args) {

//		* Declare the input as Follow
		String test = "I am a software tester";
		System.out.println(test);

//a) split the words and have it in an array
		String[] splitWords = test.split(" ");
		int length = splitWords.length;
		String result = "";

//b) Traverse through each word (using loop)
//c) find the odd index within the loop (use mod operator)
//
//d)split the words and have it in an array
//
//e)print the even position words in reverse order using another loop (nested loop)
//f) Convert words to character array if the position is even else print the word as it is(concatenate space at the end).
		for (int i = 0; i <= length - 1; i++) {
			if (i % 2 == 0) {
				result = result + splitWords[i] + " ";
			} else {
				StringBuilder stringBuilder = new StringBuilder(splitWords[i]);
				result = result + stringBuilder.reverse().toString() + " ";
			}
		}

		System.out.println(result);

	}

}
