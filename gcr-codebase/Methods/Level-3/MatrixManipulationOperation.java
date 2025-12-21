public class MatrixManipulationOperation{
    // return matrix
    public static int[][] getRandom(int row, int col){
        int[][] matrix = new int[row][col];
		
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                matrix[i][j] = 1 + (int)(Math.random()*9);
			}
		}
        return matrix;
    }

    // method to perform addition of two matrix
    public static int[][] addMatrix(int[][] m1,int[][] m2){
		int n = m1.length;
		int m = m1[0].length;
        int[][] result = new int[n][m];
		
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                result[i][j] = m1[i][j] + m2[i][j];
			}
		}
        return result;
    }

    // method to perform substraction of two matrix
    public static int[][] subtractMatrix(int[][] m1,int[][] m2){
        int n = m1.length;
		int m = m1[0].length;
        int[][] result = new int[n][m];
		
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                result[i][j] = m1[i][j] - m2[i][j];
			}
		}
        return result;
    }

    // method to perform multiplication of two matrix
    public static int[][] multiplyMatrix(int[][] m1, int[][] m2){
        int n = m1.length;
		int m = m1[0].length;
        int[][] result = new int[n][m];
		
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                for(int k = 0; k < m; k++){
                    result[i][j] += m1[i][k] * m2[k][j];
				}
			}
		}
        return result;
    }

    // print the matrix
    public static void print(int[][] matrix){
        for(int[] row : matrix){
            for(int val : row){
                System.out.print(val + " ");
			}
            System.out.println();
        }
    }

    public static void main(String[] args){
        int[][] m1 = getRandom(2,2);
        int[][] m2 = getRandom(2,2);

		// calling methods and printing results
        print(addMatrix(m1, m2));
        print(subtractMatrix(m1, m2));
        print(multiplyMatrix(m1, m2));
    }
}