package QueueTopic;

public class CircularArrayQueue {

    static class CirQueue {
        static int arr[];
        static int front;
        static int rear;
        static int size;

        CirQueue(int totalSize) {
            arr = new int[totalSize];
            front = -1;
            rear = -1;
            size = totalSize;
        }

        public static boolean isEmpty() {
            return rear == -1 && front == -1;
        }

        public static boolean isFull() {
            return (rear + 1) % size == front;
        }

        public static void add(int data) {
            if (isFull()) {
                System.out.println("Queue is Full");
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
                System.out.println("Queue is Empty");
                return -1;
            }
            return arr[front];

        }

        public static int remove() {
            if (isEmpty()) {
                System.out.println("Queue is Empty");
                return -1;
            }
            int result = arr[front];
            if (front == rear) {
                rear = front = -1;
            } else {
                front = (front + 1) % size;
            }
            return result;

        }
    }

    public static void main(String[] args) {
        CirQueue queue = new CirQueue(4);
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.add(5);
        while (!queue.isEmpty()) {
            System.out.println(queue.remove());
        }
    }

}
