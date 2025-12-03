package StringTop50;

public class NonRepetingChar {

    public static void printArray(int temp[]) {
        for (int i : temp) {
            System.out.print(i + " ");
        }
    }

    public static void main(String[] args) {
        String str = "uhgxusrtgqitrtpiuqxmpdmyumdputxumlxnrnfwgeuslwdysxhucykkmzfdourroagoan";
        int temp[] = new int[26];
        for (int i = 0; i < temp.length; i++) {
            temp[i] = -1;
        }
        for (int i = 0; i < str.length(); i++) {
            int currentindex = str.charAt(i) - 'a';
            if (temp[currentindex] == -1) {
                temp[currentindex] = currentindex;
            } else {
                temp[currentindex] = -2;
            }
        }
        int minValue = Integer.MAX_VALUE;
        for (int i = 0; i < temp.length; i++) {
            if (temp[i] != -1 && temp[i] != -2) {
                minValue = Math.min(minValue, temp[i]);

            }
        }
        // printArray(temp);
        if (minValue != Integer.MAX_VALUE) {
            System.out.println(str.charAt(minValue));
        } else {
            System.out.println("$");
        }
    }

}
