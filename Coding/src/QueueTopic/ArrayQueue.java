package QueueTopic;

public class ArrayQueue {
    static class Queue {
        static int arr[];
        static int size;
        static int rear;

        Queue(int n) {
            arr = new int[n];
            size = n;
            rear = -1;
        }

        public static boolean isEmpty() {
            return rear == -1;
        }

        public static void add(int data) {
            if (rear == size - 1) {
                System.out.println("Queue is Full");
                return;
            }
            rear = rear + 1;
            arr[rear] = data;
        }

        public static int peek() {
            if (isEmpty()) {
                System.out.println("Queue is Empty");
                return -1;
            }
            int top = arr[0];
            return top;
        }

        public static int remove() {
            if (isEmpty()) {
                System.out.println("Queue is Empty");
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
        Queue arr = new Queue(4);
        arr.add(1);
        arr.add(2);
        arr.add(3);
        while (!arr.isEmpty()) {
            System.out.println(arr.peek());
            arr.remove();
        }

    }

}
