/*
 * LeetCode 73 - Set Matrix Zeroes (Medium)
 * Topic: 2D Arrays, conditional statements
 *
 * Approach (in place, O(1) extra space): Use the first row and first column as markers.
 *  1) Record whether the first row / first column originally contain a zero.
 *  2) For every other cell that is zero, mark its row and column in the first row/column.
 *  3) Zero out cells using those markers.
 *  4) Finally zero the first row / first column if they originally had a zero.
 * Time: O(m * n)   Space: O(1)
 *
 * Note: The file name starts with a digit (as required by the naming convention),
 * so the class cannot be declared public. Run with: java 12_LC073_SetMatrixZeroes_Medium.java
 */
import java.util.Arrays;

class Solution {

    public void setZeroes(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        boolean firstRowZero = false, firstColZero = false;

        for (int j = 0; j < n; j++) {
            if (matrix[0][j] == 0) {
                firstRowZero = true;
                break;
            }
        }
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0) {
                firstColZero = true;
                break;
            }
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        if (firstRowZero) {
            for (int j = 0; j < n; j++) {
                matrix[0][j] = 0;
            }
        }
        if (firstColZero) {
            for (int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        int[][] a = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        s.setZeroes(a);
        System.out.println(Arrays.deepToString(a)); // [[1, 0, 1], [0, 0, 0], [1, 0, 1]]

        int[][] b = {{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}};
        s.setZeroes(b);
        System.out.println(Arrays.deepToString(b)); // [[0, 0, 0, 0], [0, 4, 5, 0], [0, 3, 1, 0]]
    }
}
