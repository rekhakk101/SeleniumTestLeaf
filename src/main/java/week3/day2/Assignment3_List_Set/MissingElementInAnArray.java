package week3.day2.Assignment3_List_Set;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MissingElementInAnArray {

	public static void main(String[] args) {
		// Here is the input
		int[] arr = { 1, 2, 3, 4, 6, 7, 8 };

		// Sort the array
		// loop through the array (start i from arr[0] till the length of the array)
		
		// check if the iterator variable is not equal to the array values respectively
		
		// print the number
		
		// once printed break the iteration
		
		List<Integer> list = new ArrayList<Integer>();
		Collections.addAll(list, 1, 2, 3, 4, 6, 7, 8);
		for(int i=1; i<list.size(); i++) {
			if(i!=list.get(i-1)) {
				System.out.println(i);
				break;
			}
		}


	}

}
