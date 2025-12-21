public class MatrixTransposeManipulation{
    // creates random matrix
    public static int[][] getRandomMatrix(int row, int col){
        int[][] result = new int[row][col];
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                result[i][j] = 1 + (int)(Math.random()*9);
			}
		}
        return result;
    }

    // transpose of matrix
    public static int[][] transpose(int[][] matrix){
		int n = matrix.length;
		int m = matrix[0].length;
        int[][] result = new int[m][n];
		
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                result[j][i] = matrix[i][j];
			}
		}
        return result;
    }

    // returns determinant of a 2x2 matrix
    public static int det2(int[][] matrix){
        return matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0];
    }

    // returns determinant of a 3x3 matrix
    public static int det3(int[][] m){
        return m[0][0] * (m[1][1] * m[2][2] - m[1][2] * m[2][1])
             - m[0][1] * (m[1][0] * m[2][2] - m[1][2] * m[2][0])
             + m[0][2] * (m[1][0] * m[2][1] - m[1][1] * m[2][0]);
    }

    // return inverse of 2x2 matrix
    public static int[][] inverse2(int[][] m){
        int det = det2(m);
        int[][] result = new int[2][2];
        result[0][0] = m[1][1] / det;
        result[0][1] = -m[0][1] / det;
        result[1][0] = -m[1][0] / det;
        result[1][1] = m[0][0] / det;
        return result;
    }

    // print matrix
    public static void print(int[][] m){
        for(int[] row : m){
            for(int x : row){
                System.out.print(x+" ");
			}
			System.out.println();
        }
    }

    public static void main(String[] args){
        int[][] matrix1 = getRandomMatrix(2, 2);
        System.out.println("Matrix of 2x2");
        print(matrix1);
        System.out.println("Determinant = "+det2(matrix1));
        System.out.println("Inverse");
        print(inverse2(matrix1));

        int[][] matrix2 = getRandomMatrix(3,3);
        System.out.println("Matrix of 3x3");
        print(matrix2);
        System.out.println("Determinant = "+det3(matrix2));
        System.out.println("Transpose");
        print(transpose(matrix2));
    }
}