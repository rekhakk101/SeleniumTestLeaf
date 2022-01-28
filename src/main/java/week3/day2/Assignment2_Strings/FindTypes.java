package week3.day2.Assignment2_Strings;

public class FindTypes {

	public static void main(String[] args) {

		String test = "$$ Welcome to 2nd Class of Automation $$ ";
		int letter = 0, space = 0, num = 0, specialChar = 0;
		int length = test.length();

//	a) Convert the String to character array
		char[] charArray = test.toCharArray();

//	b) Traverse through each character (using loop)
//	c) Find if the given character is what type using (if)
//						i)  Character.isLetter
//						ii) Character.isDigit
//						iii)Character.isSpaceChar
//						iv) else -> consider as special character
		for (int i = 0; i <= length - 1; i++) {
			if (Character.isAlphabetic(charArray[i])) {
				letter++;
			} else if (Character.isSpaceChar(charArray[i])) {
				space++;
			} else if (Character.isDigit(charArray[i])) {
				num++;
			} else {
				specialChar++;
			}
		}

//	  Print the count here
		System.out.println("letter: " + letter);
		System.out.println("space: " + space);
		System.out.println("number: " + num);
		System.out.println("specialCharcter: " + specialChar);

	}

}
