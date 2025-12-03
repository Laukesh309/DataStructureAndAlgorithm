package String;

public class reverseStringWord {

    public static void main(String[] args) {
        String str = " the   sky is blue";
        String result[] = str.split(" ");
        String tempResult = "";
        int inititalPointer = 0;
        int lastPointer = result.length - 1;
        while (inititalPointer < lastPointer) {
            String temp = result[inititalPointer];
            result[inititalPointer++] = result[lastPointer];
            result[lastPointer--] = temp;
        }
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
            if (!result[i].isEmpty()) {
                tempResult = tempResult + " " + result[i];
            }
        }
        System.out.println(tempResult.trim());
    }

}
