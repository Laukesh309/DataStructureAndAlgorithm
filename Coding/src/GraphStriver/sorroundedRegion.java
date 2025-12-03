package GraphStriver;

public class sorroundedRegion {

    public static void perFormDFS(char mat[][], char result[][], int row, int col) {
        result[row][col] = 'O';
        int dRow[] = { 0, 0, 1, -1 };
        int dCol[] = { 1, -1, 0, 0 };
        for (int i = 0; i < 4; i++) {
            int cRow = dRow[i] + row;
            int cCol = dCol[i] + col;
            if (cRow >= 0 && cCol >= 0 && cRow < mat.length && cCol < mat[0].length && mat[cRow][cCol] == 'O'
                    && result[cRow][cCol] != 'O') {
                perFormDFS(mat, result, cRow, cCol);
            }
        }

    }

    public static void printArray(char result[][]) {
        for (char[] cs : result) {
            for (char cs2 : cs) {
                System.out.print(cs2 + " ");
            }
            System.out.println();
        }
    }

    public static char[][] convertRegion(char mat[][]) {
        char result[][] = new char[mat.length][mat[0].length];
        for (int row = 0; row < mat.length; row++) {
            for (int col = 0; col < mat[0].length; col++) {
                if ((row == 0 || col == 0 || row == mat.length - 1 || col == mat[0].length - 1) && mat[row][col] == 'O'
                        && result[row][col] != 'O') {
                    perFormDFS(mat, result, row, col);
                }
            }
        }
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                if (result[i][j] != 'O') {
                    result[i][j] = 'X';
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        char mat[][] = { { 'X', 'X', 'X', 'X' }, { 'X', 'O', 'X', 'X' }, { 'X', 'O', 'O', 'X' }, { 'X', 'O', 'X', 'X' },
                { 'X', 'X', 'O', 'O' } };
        convertRegion(mat);
    }

}
