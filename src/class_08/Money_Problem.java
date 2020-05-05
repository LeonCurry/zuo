package class_08;

import zuo.sort.SmallSum;

public class Money_Problem {
	public static boolean money1(int[] arr, int aim) {
		return process1(arr, 0, 0, aim);
	}
	public static boolean process1(int[] arr, int i, int sum, int aim) {
		if(sum == aim) {
			return true;
		}
		if(i == arr.length) {
			return false;
		}
		return process1(arr, i+1, sum, aim) || process1(arr, i+1, sum+arr[i], aim);
	}
	public static boolean money2(int[] arr, int aim) {
		boolean[][] dp = new boolean[arr.length+1][aim+1];
		dp[arr.length][aim]=true;
		for(int i=0; i<dp.length;i++) {
			dp[i][aim] = true;
		}
		for(int i = arr.length-1;i>=0;i--) {
			for(int j=aim-1;j>=0;j--) {
				//boolean�����Ĭ��ֵΪfalse
				dp[i][j] = dp[i+1][j];
				if(j + arr[i]<=aim) {
					dp[i][j] = dp[i][j] ||dp[i+1][j+arr[i]];
				}
			}
		}
		return dp[0][0];
	}
	public static void main(String[] args) {
		int[] arr = { 1, 4, 8 };
		int aim = 12;
		boolean[][] m = new boolean[2][2];
		System.out.println(m[1][1]);
		System.out.println(money1(arr, aim));
		System.out.println(money2(arr, aim));
	}
	
}
