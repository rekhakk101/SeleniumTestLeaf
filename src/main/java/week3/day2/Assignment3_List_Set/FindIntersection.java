package week3.day2.Assignment3_List_Set;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FindIntersection {

	public static void main(String[] args) {

		/*
		 * // * a) Declare An array for {3,2,11,4,6,7}; int[] a1 = {3,2,11,4,6,7};
		 * 
		 * // * b) Declare another array for {1,2,8,4,9,7}; int[] a2 = {1,2,8,4,9,7};
		 * 
		 * // * c) Declare for loop iterator from 0 to array length // * d) Declare a
		 * nested[] for another array from 0 to array length // * e) Compare Both the
		 * arrays using a condition statement List<Integer> list1 = new
		 * ArrayList(Arrays.asList(a1)); List<Integer> list2 = new
		 * ArrayList(Arrays.asList(a2));
		 * 
		 * for(int i=0; i<list1.size(); i++) { for(int j=0; j<list2.size(); j++) {
		 * if(list1.get(i)==list2.get(j)) { List<Integer> result = new ArrayList();
		 * result.add(list1.get(i)); System.out.println(result); } } }
		 * 
		 * 
		 * // * f) Print the first array (should match item in both arrays) //
		 * System.out.println("Common numbers in both arrays are:");
		 * 
		 * 
		 * //
		 */

		List<Integer> list1 = new ArrayList<Integer>();
		List<Integer> list2 = new ArrayList<Integer>();
		Collections.addAll(list1, 3, 2, 11, 4, 6, 7);
		Collections.addAll(list2, 1, 2, 8, 4, 9, 7);
		list2.retainAll(list1);
		System.out.println(list2);
	}

}
