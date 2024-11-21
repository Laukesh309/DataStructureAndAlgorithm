package recursion;

public class wordSearch1 {

    public static boolean searchStringFunc(char arr[][], int visitedArray[][], String searchString, String result,
            int currentRow, int currentColumn) {

        if (searchString.equals(result)) {
            return true;
        }
        if (!searchString.contains(result)) {
            return false;
        }
        if (currentRow < 0 || currentColumn < 0 || currentRow > arr.length - 1 || currentColumn > arr[0].length - 1) {
            return false;
        }
        if (visitedArray[currentRow][currentColumn] == 1) {
            return false;
        }

        visitedArray[currentRow][currentColumn] = 1;
        // move top
        String nextResult = result + arr[currentRow][currentColumn];
        boolean topResult = searchStringFunc(arr, visitedArray, searchString, nextResult,
                currentRow - 1,
                currentColumn);
        boolean downResult = topResult || searchStringFunc(arr, visitedArray, searchString, nextResult, currentRow + 1,
                currentColumn);
        boolean leftResult = topResult || downResult
                || searchStringFunc(arr, visitedArray, searchString, nextResult, currentRow,
                        currentColumn - 1);
        boolean rightResult = topResult || downResult || leftResult
                || searchStringFunc(arr, visitedArray, searchString, nextResult, currentRow,
                        currentColumn + 1);
        visitedArray[currentRow][currentColumn] = 0;
        return rightResult;
    }

    public static boolean findResult(char arr[][], String searchString, int visitedArray[][]) {
        for (int row = 0; row < arr.length; row++) {
            for (int column = 0; column < arr[0].length; column++) {
                if (searchString.charAt(0) == arr[row][column]) {
                    if (searchStringFunc(arr, visitedArray, searchString, "", row, column)) {
                        return true;
                    }
                    ;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        char arr[][] = {
                { 'A', 'B', 'C', 'E' },
                { 'S', 'F', 'C', 'S' },
                { 'A', 'D', 'E', 'E' }
        };
        int visitedArray[][] = new int[arr.length][arr[0].length];
        String searchString = "SEE";
        System.out.println(findResult(arr, searchString, visitedArray));

    }

}
