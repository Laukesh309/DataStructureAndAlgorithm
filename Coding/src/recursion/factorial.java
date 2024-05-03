package recursion;

public class factorial {
	
	public static int getFactorial(int number) {
		if(number==0 || number==1) {
			return 1;
		}
		return number*getFactorial(--number);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       int number =6;
       int value = getFactorial(number);
       System.out.println(value);
       
	}

}
