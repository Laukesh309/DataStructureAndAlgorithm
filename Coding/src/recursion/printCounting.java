package recursion;

public class printCounting {
	public static void counting(int number) {
		
		if(number==0) {
			return;
		}
		counting(number-1);
		System.out.println(number);
		return ;
		
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int number =5;
		counting(number);
		

	}

}
