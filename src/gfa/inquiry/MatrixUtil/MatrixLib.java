package gfa.inquiry.MatrixUtil;

/**
 * MatrixLib is a Matrix Utility Library.
 *
 * printMatrix() prints out the passed matrix as a visual 2d array.
 * multiply() returns a new matrix that uses the dot products of
 *            passed m1 and m2 matrices as its cells.
 *
 * Version: 1.0.1
 * Author: Joel Strand
 */

public class MatrixLib {

    public static void printMatrix(int[][] matrix) {
        String s = "";
        for (int[] intArr : matrix) {
            for (int indivInt : intArr) {
                s = s + indivInt + ",";
            }
            System.out.println("[" + s.substring(0, s.length() - 1) + "]");
            s = "";
        }
    }

    public static int[][] multiply(int[][] m1, int[][] m2) {
        int[][] res = new int[m1.length][m2[0].length];

        for (int row = 0; row < res.length; row++) {
            for (int col = 0; col < res[row].length; col++) {
                res[row][col] = cell(m1, m2, row, col);
            }
        }

        return res;
    }

    private static int cell(int[][] m1, int[][] m2, int row, int col) {
        int cell = 0;
        for (int i = 0; i < m2.length; i++)
            cell += m1[row][i] * m2[i][col];
        return cell;
    }
}