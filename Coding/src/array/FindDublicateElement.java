package array;

public class FindDublicateElement {
	
	public static void findDublicate(int arr1[],int arr2[]) {
		int secondPointer=0;
		for(int i=0;i<arr1.length;i++) {
			for(int j=secondPointer;j<arr2.length;j++) {
				if(arr1[i]==arr2[j]) {
					System.out.println(arr1[i]);
					secondPointer=j+1;
					break;
				}
			}
		}
		
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr1[] = {1,2,3};
		int arr2[] = {4};
		findDublicate(arr1,arr2);

	}

}
