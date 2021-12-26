package assignments.week1.day2;

public class PalindromeCheck {
	
	public int reverse(int n) {
		int rev = 0;
		while(n!=0) {
			int n1 = n%10;
			rev = rev*10 + n1;
			n = n/10;
		}
		return rev;
	}

	public static void main(String[] args) {
		int num = 12321;
		
		PalindromeCheck pal = new PalindromeCheck();
		int reverse = pal.reverse(num);
		
		if(num==reverse) {
			System.out.println(num+" is a Palindrome number");
		}else {
			System.out.println(num+" is not a Palindrome number");
		}

	}

}
