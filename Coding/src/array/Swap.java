package array;

public class Swap {

	public static void swapElement(int arr[]) {
		for(int i=0;i<arr.length;i+=2){
			if(i+1<arr.length) {
			  int temp= arr[i];
			  arr[i]=arr[i+1];
			  arr[i+1]=temp;
			}
		}}
	public static void printElement(int element[]) {
		for (int i=0;i<element.length;i++) {
			System.out.println(element[i]);
		}
	}
	public static void main(String[] args) {
		int element[]= {1,3,2,7,11};
		swapElement(element);
		printElement(element);
	}

}
