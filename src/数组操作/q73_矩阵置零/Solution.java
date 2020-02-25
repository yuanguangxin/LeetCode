package 数组操作.q73_矩阵置零;

/**
 * 用每行和每列的第一个元素作为标记，空间复杂度是o(1)，时间复杂度 o(m*n)
 */
public class Solution {

    public void setZeroes(int[][] matrix) {
        //第一行是否需要置零
        boolean row = false;
        //第一列是否需要置零
        boolean column = false;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    if (i == 0) {
                        row = true;
                    }
                    if (j == 0) {
                        column = true;
                    }
                    //第i行第一个元素置零，表示这一行需要全部置零
                    matrix[i][0] = 0;
                    //第j列第一个元素置零，表示这一列需要全部置零
                    matrix[0][j] = 0;
                }
            }
        }
        for (int i = 1; i < matrix.length; i++) {
            if (matrix[i][0] == 0) {
                for (int j = 1; j < matrix[i].length; j++) {
                    matrix[i][j] = 0;
                }
            }
        }
        for (int j = 1; j < matrix[0].length; j++) {
            if (matrix[0][j] == 0) {
                for (int i = 1; i < matrix.length; i++) {
                    matrix[i][j] = 0;
                }
            }
        }
        if (row) {
            for (int j = 1; j < matrix[0].length; j++) {
                matrix[0][j] = 0;
            }
        }
        if (column) {
            for (int i = 1; i < matrix.length; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}
