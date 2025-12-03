package StringTop50;

public class IntegerToRoma {

    public static String findRoman(int input, int number[], String words[]) {
        String result = "";
        for (int i = number.length - 1; i >= 0; i--) {
            int currNumber = number[i];
            if (currNumber <= input) {
                int que = input / currNumber;
                for (int j = 0; j < que; j++) {
                    result = result + words[i];
                }
                input = input % currNumber;
            }
        }
        System.out.println(result);
        return result;
    }

    public static void main(String[] args) {
        int number[] = { 1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000 };
        String words[] = { "I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M" };
        int input = 48;
        System.out.println(findRoman(input, number, words));
    }

}
