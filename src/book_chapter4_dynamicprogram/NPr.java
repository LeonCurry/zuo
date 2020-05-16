package book_chapter4_dynamicprogram;

import java.util.Scanner;

public class NPr {
	public static int num1(int n) {
		if(n < 1) {
			return 0;
		}
		int[] record= new int[n];
		return process(0 , record, n);
	}
	public static int process(int i, int[] record, int n) {
		if(i == n) {
			return 1;
		}
		int res = 0 ;
		//放到指定行的任意一列
		for(int j = 0; j < n; j++) {
			if(isValid(record, i , j)) {
				record[i] = j;
				res += process(i+1, record, n);
			}
		}
		return res;
	}
	public static boolean isValid(int[] record, int i , int j) {
		//检验数组中第i行是否存在j列
		for(int k = 0 ; k < i; k++) {
			if(j == record[k] || Math.abs(i - k) == Math.abs(j-record[k])) {
				return false;
			}
		}
		return true;
	}
	
	public static int num2(int n) {
		if(n < 1 || n > 32) {
			return 0;
		}
		int upperLim = n == 32 ? -1 : (1 << n) -1;
		return process1( upperLim, 0, 0, 0);
	}
	public static int process1(int upperLim, int colLim, int leftLim, int rightLim) {
		if(colLim == upperLim) {
			return 1;
		}
		int pos = 0 ;
		int mostRightOne = 0;
		pos = upperLim & (~(colLim | leftLim | rightLim));
		int res = 0;
		while(pos != 0) {
			mostRightOne = pos & (~pos +1);
			pos = pos - mostRightOne;
			res += process1(upperLim, colLim | mostRightOne, (leftLim | mostRightOne) << 1, (rightLim|mostRightOne) >> 1);
		}
		return res;
	}
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = Integer.valueOf(in.nextLine());
		int res = num2(n);
		System.out.println(res);
	}
	
}
