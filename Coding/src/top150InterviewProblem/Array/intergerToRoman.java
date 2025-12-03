package top150InterviewProblem.Array;

public class intergerToRoman {

    public static void main(String[] args) {
        String romanSymbol[] = { "I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M" };
        int romanValue[] = { 1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000 };
        int num = 1994;
        int currentIndex = romanSymbol.length - 1;
        StringBuilder result = new StringBuilder();
        while (num != 0) {
            if (romanValue[currentIndex] <= num) {
                System.out.println(num);
                int currentQue = num / romanValue[currentIndex];
                num = num % romanValue[currentIndex];
                while (currentQue > 0) {
                    result.append(romanSymbol[currentIndex]);
                    currentQue--;
                }
            }
            currentIndex--;
        }
        System.out.println(result);
    }

}
