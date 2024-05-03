package QueueTopic;

public class CircularArrayQueue1 {

    static class Queue {
        static int size;
        static int arr[];
        static int front;
        static int rear;

        Queue(int data) {
            arr = new int[data];
            this.size = data;
            front = -1;
            rear = -1;
        }

        public static boolean isEmpty() {
            return front == -1 && rear == -1;
        }

        public static boolean isFull() {
            return (rear + 1) % size == front;
        }

        public static void add(int data) {
            if (isFull()) {
                System.out.println("queue is full");
                return;
            }
            if (isEmpty()) {
                front = front + 1;
            }
            rear = (rear + 1) % size;
            arr[rear] = data;
            return;
        }

        public static int peek() {
            if (isEmpty()) {
                System.out.println("queue is empty");
                return -1;
            }
            return arr[front];

        }

        public static int remove() {
            if (isEmpty()) {
                System.out.println("queue is empty");
                return -1;
            }
            int top = arr[front];
            if (front == rear) {
                front = -1;
                rear = -1;
            } else {
                front = (front + 1) % size;
            }
            return top;

        }

        public static void printArray() {
            for (int i = 0; i < arr.length; i++) {
                System.out.print(arr[i]);
            }
        }
    }

    public static void main(String[] args) {
        Queue queue = new Queue(3);
        queue.add(10);
        queue.add(20);
        queue.add(30);
        System.out.println(queue.isEmpty());
        System.out.println(queue.peek());
        while (!queue.isEmpty()) {
            System.out.println(queue.remove());

        }
        queue.printArray();
    }

}
