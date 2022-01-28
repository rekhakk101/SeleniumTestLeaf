package week3.day2.Assignment2_Strings;

public class Palindrome {

	public static void main(String[] args) {

//	 a) Declare A String value as"madam"
		String s = "madam";
		int length = s.length();

//	 b) Declare another String rev value as ""
		String rev = "";

//	 c) Iterate over the String in reverse order
//		 d) Add the char into rev
		for (int i = length - 1; i >= 0; i--) {
			rev = rev + s.charAt(i);
		}

//	 e) Compare the original String with the reversed String, if it is same then print palinDrome 
		System.out.println("Reverse String is: " + rev);
		if (s.equalsIgnoreCase(rev)) {
			System.out.println(s + " is a Palindrome");
		} else {
			System.out.println(s + " is not a Palindrome");
		}

	}

}
