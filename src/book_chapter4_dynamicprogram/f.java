package book_chapter4_dynamicprogram;

import java.util.zip.Inflater;

public class f {
	public static int f1(int n) {
		if(n < 1) {
			return 0;
		}
		if(n == 1 || n ==2) {
			return 1;
		}
		return f1(n -1) + f1(n-2);
	}
	public static int f2(int n) {
		if(n < 1) {
			return 0;
		}
		if(n ==1 || n == 2) {
			return 1;
		}
		int res = 1;
		int pre = 1;
		int temp = 0;
		for(int i = 3; i <= n; i++) {
			temp = res;
			res += pre;
			pre = temp;
		}
		return res;
	}
	//时间复杂度为O(logn）
	public static int[][] matrixPower(int[][] m, int p){
		int[][] res = new int[m.length][m[0].length];
		for(int i = 0 ; i < res.length ; i++) {
			res[i][i] = 1;
		}
		int[][] temp = m;
		for(; p != 0; p >>= 1) {
			if((p & 1) != 0) {
				res = multiMatrix(res, temp);
			}
			temp = multiMatrix(temp, temp);
		}
		return res;
	}
	public static int[][] multiMatrix(int[][] m1, int[][] m2){
		int[][] res = new int[m1.length][m2[0].length];
		for(int i = 0 ; i < m1.length ; i++) {
			for(int j = 0 ; j < m2[0].length;j++) {
				for(int k = 0 ; k < m2.length ; k++) {
					res[i][j] += m1[i][k] * m2[k][j];									
				}
			}
		}
		return res;
	}
	public static int f3(int n) {
		if(n < 1) {
			return 0;
		}
		if(n ==1 || n ==2) {
			return 1;
		}
		int[][] base = { {1,0},{1,1}};
		int[][] res = matrixPower(base, n - 2);
		return res[0][0] + res[1][0];
	}
	/************跳台阶****************/
	public static int s1(int n) {
		if(n <0) {
			return 0;
		}
		if(n == 1 || n == 2) {
			return n;
		}
		int res = 2;
		int pre = 1;
		int temp = 0;
		for(int i = 3; i <= n ; i++) {
			temp = res;
			res = res + pre;
			pre = temp;
		}
		return res;
	}
	public static int s2(int n) {
		if( n < 0) {
			return 0;
		}
		if(n == 1|| n == 2) {
			return n;
		}
		int[][] base = {{1,1},{1,0}};
		int[][] res = matrixPower(base, n - 2);
		return 2 * res[0][0] + res[1][0];
	}
}
