package array;

public class Sort0and1 {

	 public static void sortElement(int arr[]) {
		 int lastPointer=arr.length-1;
	     int initialPointer=0;
	     while(initialPointer<=lastPointer) {
	    	 while(arr[initialPointer]==0) {
	    		 initialPointer++;
	    	 }
	    	 while(arr[lastPointer]==1) {
	    		 lastPointer--;
	    	 }
	    	 if(initialPointer<lastPointer) {
	    		 int temp=arr[initialPointer];
		    	 arr[initialPointer]=arr[lastPointer];
		    	 arr[lastPointer]=temp;
		    	 initialPointer++;
		    	 lastPointer--; 
	    	 }
	     }
	     printElement(arr);   
		 
	 }
	 public static void printElement(int arr[]) {
		  for(int i=0;i<arr.length;i++) {
			  System.out.println(arr[i]);
		  }
	 }
	public static void main(String[] args) {
		int arr[]= {0,0,1,0,1,0};
		sortElement(arr);
//		printElement(arr);
	}

}
