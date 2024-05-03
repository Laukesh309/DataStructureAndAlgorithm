package recursion;

public class poweroftwo {
	
	public static int power(int number) {
		if(number==0) {
			return 1;
		}
		return 2*power(number-1);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 1;
		int number = power(n);
		System.err.println(number);

	}

}
