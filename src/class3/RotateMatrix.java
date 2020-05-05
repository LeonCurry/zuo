package class3;

public class RotateMatrix {
	public static void rotate(int[][] matrix) {
		int tR=0;
		int tC=0;
		int dR=matrix.length-1;
		int dC=matrix[0].length-1;
		while(tR<dR) {
			rotateEdge(matrix, tR++, tC++, dR--, dC--);
		}
	}
	
	public static void rotateEdge(int[][] m, int tR, int tC, int dR, int dC) {
		int time = dC-tC;
		int temp=0;
		for(int i=0; i<time; i++) {
			temp=m[tR][tC+i];
			m[tR][tC+i]=m[dR-i][dC];
			m[dR-i][dC]=m[dR][dC-i];
			m[dR][dC-i]=m[tR+i][dC];
			m[tR+i][dC]=temp;
		}
	}
}
