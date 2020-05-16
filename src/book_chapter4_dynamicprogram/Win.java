package book_chapter4_dynamicprogram;

import java.util.Scanner;

public class Win {
	public static int win1(int[] arr) {
		if(arr == null|| arr.length == 0) {
			return 0;
		}
		return Math.max(f(arr, 0, arr.length - 1), s(arr, 0 , arr.length - 1));
	}
	public static int f(int[] arr, int i , int j) {
		if( i == j) {
			return arr[i];
		}
		return Math.max(arr[i] + s(arr, i + 1, j), arr[j] + s(arr, i , j-1));
	}
	public static int s(int[] arr, int i, int j) {
		if(i == j) {
			return 0;
		}
		return Math.min(f(arr, i+1, j), f(arr, i, j-1));
	}
	public static int win2(int[] arr) {
		if(arr == null || arr.length == 0) {
			return 0;
		}
		int[][] f = new int[arr.length][arr.length];
		int[][] s = new int[arr.length][arr.length];
		for(int j = 0 ; j < arr.length ;j++) {
			f[j][j] = arr[j];
			for(int i = j - 1; i >= 0 ; i--) {
				f[i][j] = Math.max(arr[i]+ s[i+1][j], arr[j] + s[i][j-1]);
				s[i][j] = Math.min(f[i+1][j], f[i][j-1]);
			}
		}
		return Math.max(f[0][arr.length-1], s[0][arr.length-1]);
	}
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String[] str = in.nextLine().split(" ");
		int[] arr = new int[str.length];
		for(int i = 0 ; i < str.length ; i++) {
			arr[i] = Integer.valueOf(str[i]);
		}
		System.out.println(win2(arr));
	}
}
