package QueueTopic;

import java.util.LinkedList;
import java.util.Queue;

public class QueueCollection {
    public static void main(String[] args) {
        Queue<Integer> que = new LinkedList<>();
        que.add(10);
        que.add(20);
        que.add(30);
        System.out.println(que);
        que.remove();
        System.out.println(que);
        que.add(40);
        System.out.println(que);
        System.out.println(que.peek());
        while (!que.isEmpty()) {
            que.remove();
        }
        System.out.println(que.isEmpty());
    }

}
