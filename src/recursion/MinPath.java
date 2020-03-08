package recursion;

/**
 * @author AndrewElvis
 * @date 2020-03-07-20:12
 */
public class MinPath {

    public static int minPath1(int[][] matrix) {
        return process1(matrix, 0, 0);
    }

    public static int process1(int[][] matrix, int i, int j) {
        if (i == matrix.length - 1 && j == matrix[0].length - 1) {
            return matrix[i][j];
        }
        if (i == matrix.length - 1) {
            return matrix[i][j] + process1(matrix, i, j + 1);
        }
        if (j == matrix[0].length - 1) {
            return matrix[i][j] + process1(matrix, i + 1, j);
        }
        int right = matrix[i][j] + process1(matrix, i, j + 1);
        int down = matrix[i][j] + process1(matrix, i + 1, j);
        return Math.min(right, down);
    }

    public static void main(String[] args) {
        int[][] m = { { 1, 3, 5, 9 }, { 8, 1, 3, 4 }, { 5, 0, 6, 1 }, { 8, 8, 4, 0 } };
        System.out.println(minPath1(m));
//        System.out.println(minPath2(m));

//        m = generateRandomMatrix(6, 7);
//        System.out.println(minPath1(m));
//        System.out.println(minPath2(m));
    }
}
