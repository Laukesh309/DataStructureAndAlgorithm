package array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Set;

public class UniqueNumberOfOccurances {
 
	public static void findValue(int arr[]) {
	   HashMap<Integer,Integer> map = new HashMap();
	   for(int i=0;i<arr.length;i++) {
		   if(map.containsKey(arr[i])) {
			   int getValue = map.get(arr[i]);
			   map.put(arr[i], ++getValue);
		   }else {
			   map.put(arr[i],1);
		   }
	   }
	 System.out.println(map.values());
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stu
		int arr[] = {1,2,2,1,1,3,4};
		findValue(arr);
		
      
	}

}
