package array;

public class uniqueElement {
     public static int findUniqueElement(int arr[]) {
    	 int uniqueElement=0;
    	 for(int i=0;i<arr.length;i++) {
    		 uniqueElement=arr[i]^uniqueElement;
    	 }
    	 return uniqueElement;
     }
     public static void printValue(int arr[]) {
    	 for(int i=0;i<arr.length;i++) {
    		 System.out.println(arr[i]);
    	 }
     }
	public static void main(String[] args) {
		
     int arr[] = {1,1,2,2,3,3,4,5,5,};
     int uniqueElement = findUniqueElement(arr);
     System.out.println(uniqueElement);
	}

}
