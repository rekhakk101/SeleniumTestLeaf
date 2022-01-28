package week3.day2.Assignment3_List_Set;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FindSecondLargest {

	public static void main(String[] args) {

		int[] data = { 3, 2, 11, 4, 6, 7 };

//		 1) Arrange the array in ascending order
		List<Integer> list = new ArrayList<Integer>();
		Collections.addAll(list, 3, 2, 11, 4, 6, 7);
		System.out.println("Input array:");
		System.out.println(list);
		Collections.sort(list);
		System.out.println("Sorted list:");
		System.out.println(list);

//	 	2) Pick the 2nd element from the last and print it
		Integer secondLargest = list.get(list.size() - 2);
		System.out.println("Second largest number is : " + secondLargest);

	}

}
