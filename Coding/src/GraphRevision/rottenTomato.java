package GraphRevision;

public class rottenTomato {

    public static void main(String[] args) {
        int arr[][] = { { 2, 1, 0, 2, 1 }, { 1, 0, 1, 2, 1 }, { 1, 0, 0, 2, 1 } };
        int totalTime = 0;
        boolean changes = true;
        while (changes) {
            changes = false;
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr[i].length; j++) {
                    int currentItem = arr[i][j];
                    if (currentItem == 1) {
                        changes = true;
                        // check previous row
                        if (i - 1 >= 0 && arr[i - 1][j] == 2) {
                            changes = true;
                            arr[i][j] = 2;
                        }
                        // next row
                        if (i + 1 < arr.length && arr[i + 1][j] == 2) {
                            changes = true;
                            arr[i][j] = 2;
                        }
                        // prev column
                        if (j - 1 >= 0 && arr[i][j - 1] == 2) {
                            arr[i][j] = 2;
                        }
                        // next column
                        if (j + 1 < arr[i].length && arr[i][j + 1] == 2) {
                            arr[i][j] = 2;
                        }
                    }
                }
            }
            if (changes == true) {
                totalTime++;
            }

        }
        System.out.println(totalTime);

    }

}
