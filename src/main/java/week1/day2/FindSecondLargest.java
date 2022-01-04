package week1.day2;

import java.util.Arrays;

public class FindSecondLargest {

	public static void main(String[] args) {
		int[] num = {3,8,9,0,5,7,4};
		
		Arrays.sort(num);
		
		for(int i=0;i<num.length; i++) {
			System.out.print(num[i]+" ");
		}
		System.out.println();
		System.out.println("Second largest number in the array is:");
		System.out.println(num[num.length-2]);

	}

}
