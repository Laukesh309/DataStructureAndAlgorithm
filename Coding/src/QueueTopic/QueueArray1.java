package QueueTopic;

public class QueueArray1 {

    static class Queue {
        static int size;
        static int arr[];
        static int rear = -1;

        Queue(int data) {
            arr = new int[data];
            size = data;
        }

        public static boolean isEmpty() {
            return rear == -1;
        }

        public static boolean isFull() {
            return rear + 1 == size;
        }

        public static void add(int data) {
            if (isFull()) {
                System.out.println("Queue is Full");
                return;
            }
            rear = rear + 1;
            arr[rear] = data;
            return;
        }

        public static int peek() {
            if (isEmpty()) {
                System.out.println("queue is empty");
                return -1;
            }
            int data = arr[0];
            return data;
        }

        public static int remove() {
            if (isEmpty()) {
                System.out.println("queue is empty");
                return -1;
            }
            int top = arr[0];
            for (int i = 0; i < rear; i++) {
                arr[i] = arr[i + 1];
            }
            rear = rear - 1;
            return top;
        }
    }

    public static void main(String[] args) {

        Queue queue = new Queue(3);
        queue.add(10);
        queue.add(20);
        queue.add(30);
        while (!queue.isEmpty()) {
            System.out.println(queue.remove());
        }

    }

}
