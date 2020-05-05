package class_08;

public class MinPath {
	public static int minPath1(int[][] matrix) {
		return process1(matrix, 0, 0);
	}
	public static int process1(int[][] matrix, int i, int j) {
		
		if(i==matrix.length-1 && j==matrix[0].length-1) {
			return matrix[i][j];
		}
		if(i == matrix.length-1) {
			return matrix[i][j] + process1(matrix, i, j+1);
		}
		if(j == matrix[0].length-1) {
			return matrix[i][j] + process1(matrix, i+1, j);
		}
		return matrix[i][j] + Math.min(process1(matrix, i+1, j), process1(matrix, i, j+1));
	}
	
	public static int process2(int[][] matrix) {
		if(matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
			return 0;
		}
		int row = matrix.length;
		int col = matrix[0].length;
		int[][] bp = new int[row][col];
		bp[0][0] = matrix[0][0];
		for(int i = 1; i < row ; i++) {
			bp[i][0] = matrix[i][0] + bp[i - 1][0];
		}
		for(int j = 1; j<col;j++) {
			bp[0][j] = matrix[0][j] + bp[0][j-1];
		}
		for(int i = 1 ; i <row; i++) {
			for(int j=1;j<col;j++) {
				bp[i][j] = matrix[i][j] + Math.min(bp[i-1][j], bp[i][j-1]);
			}
		}
		return bp[row-1][col-1];
	}
	public static void main(String[] args) {
		int[][] m = { { 1, 3, 5, 9 }, { 8, 1, 3, 4 }, { 5, 0, 6, 1 }, { 8, 8, 4, 0 } };
		System.out.println(minPath1(m));
		System.out.println(process2(m));

		//m = generateRandomMatrix(6, 7);
		//System.out.println(minPath1(m));
		//System.out.println(minPath2(m));
	}
}
