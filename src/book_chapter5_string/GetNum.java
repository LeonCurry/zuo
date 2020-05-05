package book_chapter5_string;

import java.util.Scanner;

import org.omg.CORBA.PUBLIC_MEMBER;

public class GetNum {
	/***********时间复杂度为O(2^N)***************/
	public static int getNum1(int n) {
		if(n < 1) {
			return 0;
		}
		return process(1,n);
	}
	public static int process(int i , int n) {
		if(i == n-1) {
			return 2;
		}
		if(i == n) {
			return 1;
		}
		return process(i+1, n) + process(i+2, n);
	}
	//时间复杂度为O（N）
	public static int getNum2(int n) {
		if(n < 1) {
			return 0;
		}
		if(n == 1) {
			return 1;
		}
		int pre =1;
		int cur = 1;
		int temp = 0 ;
		for(int i = 2; i <n+1;i++) {
			temp = cur;
			cur += pre;
			pre = temp;
		}
		return cur;
	}
	//时间复杂度为O（logN）
	public static int getNum3(int n) {
		if(n <1) {
			return 0;
		}
		if(n == 1 || n ==2) {
			return n;
		}
		int[][] base = {{1,1},{1,0}};
		int[][] res = matrixPower(base, n-2);
		return 2 * res[0][0] + res[1][0];
	}
	public static int[][] matrixPower(int[][] m, int p){
		int[][] res = new int[m.length][m[0].length];
		for(int i = 0 ; i < res.length;i++) {
			res[i][i] = 1;
		}
		int[][] temp = m;
		for(; p !=0; p>>=1) {
			if((p &1) != 0) {
				res = muliMatrix(res, temp);
			}
			temp = muliMatrix(temp, temp);
		}
		return res;
	}
	public static int[][] muliMatrix(int[][] m1, int[][] m2){
		int[][] res = new int[m1.length][m2[0].length];
		for(int i = 0 ; i <m1.length;i++) {
			for(int j = 0; j <m2[0].length;j++) {
				for(int k = 0 ; k <m2.length;k++) {
					res[i][j] += m1[i][k] * m2[k][j];
				}
			}
		}
		return res;
	}
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = Integer.valueOf(in.nextLine());
		int res = getNum2(n);
		System.out.println(res);
		
	}
}
