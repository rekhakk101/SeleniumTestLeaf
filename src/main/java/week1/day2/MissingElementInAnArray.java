package week1.day2;

public class MissingElementInAnArray {

	public static void main(String[] args) {
		int[] arr = {1,2,3,4,6,7,8};
		
		for(int i=arr[0]; i<arr.length; i++) {
			if(i != arr[i-1]) {
				System.out.println(i);
				break;
			}
				
			
		}

	}

}
