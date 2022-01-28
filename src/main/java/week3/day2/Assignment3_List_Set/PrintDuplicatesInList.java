package week3.day2.Assignment3_List_Set;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class PrintDuplicatesInList {

	public static void main(String[] args) {
		
		      ArrayList<Integer> arr = new ArrayList<Integer>(Arrays.asList(1,2,3,4,45,55,3,32,22,22,55,1));
		      HashSet<Integer> hCheckSet = new HashSet<Integer>();
		      HashSet<Integer> hTargetSet = new HashSet<Integer>();
		      for (Integer integer : arr) {
		         if(!hCheckSet.add(integer)) {
		            hTargetSet.add(integer);
		         }
		      }
		      System.out.println("Duplicate integers in given list is/are " + hTargetSet);
		   }

	}


