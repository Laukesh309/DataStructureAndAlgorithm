package QueueTopic;

import java.util.LinkedList;
import java.util.Queue;

public class StringReccurence {

    public static void printNonRepeatingChar(int arr[], String str) {
        int initialPointer = 0;
        Queue<Character> queue = new LinkedList<>();
        while (initialPointer < str.length()) {
            char ch = str.charAt(initialPointer);
            arr[ch - 'a'] = arr[ch - 'a'] + 1;
            if (arr[ch - 'a'] == 1) {
                queue.add(ch);
            }
            while (!queue.isEmpty() && arr[queue.peek() - 'a'] != 1) {
                queue.remove();
            }
            if (queue.isEmpty()) {
                System.out.print("-1 ");
            } else {
                System.out.print(queue.peek() + " ");
            }

            initialPointer++;
        }

    }

    public static void main(String[] args) {
        int alphabet[] = new int[26];
        String str = "aabccxb";
        printNonRepeatingChar(alphabet, str);

    }

}
