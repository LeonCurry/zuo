package class3;

public class ZigZagPrintMatrix {
	public static void printMatrixZigZag(int[][] matrix) {
		int tR=0;
		int tC=0;
		int dR=0;
		int dC=0;
		int endR=matrix.length-1;
		int endC=matrix[0].length-1;
		boolean fromUp = false;
		while(tR!=endR+1) {
			print(matrix, tR, tC, dR, dC, fromUp);
			tR=tC==endC?tR++:tR;
			tC=tC==endC?tC:tC++;
			dR=dR==endR?dR:dR++;
			dC=dR==endR?dC++:dC;
			fromUp=!fromUp;
		}
		System.out.println();
	}
	public static void print(int[][] m, int tR, int tC, int dR, int dC, boolean f) {
		if(f) {
			while(tR!=dR+1) {
				System.out.print(m[tR++][tC--] + " ");
			}
		}else {
			while(dC!=tC+1) {
				System.out.println(m[dR--][tC++]);
			}
		}
	}
}
