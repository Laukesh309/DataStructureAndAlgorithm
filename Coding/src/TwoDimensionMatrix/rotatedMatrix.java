package TwoDimensionMatrix;

public class rotatedMatrix {

    public static void printArray(int matrix[][]) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }

    public static void rotateMatrix(int matrix[][], int sourceRow, int sourceColumn, int destinationRow,
            int destinationColumn) {
        int tempValue = matrix[sourceRow][sourceColumn];
        int currentRow = sourceRow;
        int currentColumn = sourceColumn;
        /// source Row Traversal
        while (currentColumn <= destinationColumn) {
            int currentValue = matrix[currentRow][currentColumn];
            matrix[currentRow][currentColumn] = tempValue;
            tempValue = currentValue;
            currentColumn++;
        }
        currentColumn--;
        currentRow++;
        // right traversal to down
        while (currentRow <= destinationRow) {
            int currentValue = matrix[currentRow][currentColumn];
            matrix[currentRow][currentColumn] = tempValue;
            tempValue = currentValue;
            currentRow++;
        }
        currentRow--;
        currentColumn--;
        //// buttom left traversal
        while (currentColumn >= sourceColumn) {
            int currentValue = matrix[currentRow][currentColumn];
            matrix[currentRow][currentColumn] = tempValue;
            tempValue = currentValue;
            currentColumn--;

        }
        currentRow--;
        currentColumn++;
        while (currentRow >= sourceRow) {
            int currentValue = matrix[currentRow][currentColumn];
            matrix[currentRow][currentColumn] = tempValue;
            tempValue = currentValue;
            currentRow--;
        }

    }

    public static void main(String[] args) {
        int matrix[][] = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        int sourceRow = 0;
        int sourceColumn = 0;
        int destinationRow = matrix.length - 1;
        int destinationCol = matrix.length - 1;
        while (sourceRow < destinationRow) {
            int totalStep = destinationRow - sourceRow;
            while (totalStep > 0) {
                totalStep--;
                rotateMatrix(matrix, sourceRow, sourceColumn, destinationRow, destinationCol);
            }
            sourceRow++;
            sourceColumn++;
            destinationRow--;
            destinationCol--;

        }
        printArray(matrix);

    }

}
