package TreeStriver;

public class staticTesting {
    static int temp = 0;

    public static void temp(int a, int b) {
        if (a < b) {
            return;
        }
        temp++;

    }

    public static void main(String[] args) {
        temp(10, 20);
        System.out.println(temp);
    }

}
