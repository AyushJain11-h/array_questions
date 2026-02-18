import java.util.Arrays;

public class SetMatrixZeroes {
    public static void main(String[] args) {
        int[][] matrix = {
            {1,1,1},
            {1,0,1},
            {1,1,1}
        };
        setZeroes(matrix);
        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
    }

    public static void setZeroes(int[][] matrix) {
        boolean firstRowZero = false;
        boolean firstColZero = false;
        int rows = matrix.length;
        int cols = matrix[0].length;

        // Check first row and first column
        for (int i = 0; i < rows; i++) {
            if (matrix[i][0] == 0) firstColZero = true;
        }
        for (int j = 0; j < cols; j++) {
            if (matrix[0][j] == 0) firstRowZero = true;
        }

        // Use first row and column as markers
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        // Set zeros based on markers
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        // Zero first row and column if needed
        if (firstRowZero) {
            for (int j = 0; j < cols; j++) matrix[0][j] = 0;
        }
        if (firstColZero) {
            for (int i = 0; i < rows; i++) matrix[i][0] = 0;
        }
    }
}
