package assignments.week1.day2;

import java.util.Arrays;

public class SecondSmallest {

	public static void main(String[] args) {
		int[] arr = {23,45,67,32,89,22};
		
		Arrays.sort(arr);
		System.out.println("Sorted array is:");
		for(int i=0; i<arr.length; i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.println('\n'+"Second smallest number is:");
		System.out.println(arr[1]);

	}

}
