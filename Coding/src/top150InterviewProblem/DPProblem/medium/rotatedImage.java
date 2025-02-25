package top150InterviewProblem.DPProblem.medium;

public class rotatedImage {

    public static void rotatedImage(int matrix[][], int sourceRow, int sourceColumn, int destinationRow,
            int destinationColumn) {
        int tempValue = matrix[sourceRow][sourceColumn];
        // right
        for (int coloumn = sourceColumn + 1; coloumn <= destinationColumn; coloumn++) {
            int temp = matrix[sourceRow][coloumn];
            matrix[sourceRow][coloumn] = tempValue;
            tempValue = temp;
        }
        // down
        for (int row = sourceRow + 1; row <= destinationRow; row++) {
            int temp = matrix[row][destinationColumn];
            matrix[row][destinationColumn] = tempValue;
            tempValue = temp;
        }
        // left
        for (int coloumn = destinationColumn - 1; coloumn >= sourceColumn; coloumn--) {
            int temp = matrix[destinationRow][coloumn];
            matrix[destinationRow][coloumn] = tempValue;
            tempValue = temp;
        }
        // top
        for (int row = destinationRow - 1; row >= sourceRow; row--) {
            int temp = matrix[row][sourceColumn];
            matrix[row][sourceColumn] = tempValue;
            tempValue = temp;
        }
        ;
    }

    public static void printArray(int matrix[][]) {
        for (int row = 0; row < matrix.length; row++) {
            for (int coloumn = 0; coloumn < matrix[0].length; coloumn++) {
                System.out.print(matrix[row][coloumn] + " ");
            }
            System.out.println();

        }
    }

    public static void main(String[] args) {
        int[][] matrix = {
                { 1, 2, 3 },
                { 4, 5, 6 },
                { 7, 8, 9 }
        };
        int sourceRow = 0;
        int sourceColumn = 0;
        int destinationRow = matrix.length - 1;
        int destinationColumn = matrix.length - 1;

        while (sourceRow <= destinationRow || sourceColumn <= destinationColumn) {
            for (int i = 1; i <= destinationRow - sourceRow; i++) {
                rotatedImage(matrix, sourceRow, sourceColumn, destinationRow,
                        destinationColumn);
            }
            sourceRow++;
            sourceColumn++;
            destinationRow--;
            destinationColumn--;

        }
    }

}
