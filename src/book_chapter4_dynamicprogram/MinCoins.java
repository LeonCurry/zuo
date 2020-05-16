package book_chapter4_dynamicprogram;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.RestoreAction;

import org.omg.CORBA.PUBLIC_MEMBER;

public class MinCoins {
	public static int minCoins(int[] arr, int aim) {
		if(arr == null || arr.length == 0 || aim < 0) {
			return -1;
		}
		return process(arr, 0 , aim);
	}
	public static int process(int[] arr, int i, int rest) {
		if(i == arr.length) {
			return rest == 0 ? 0 : -1;
		}
		int res = -1;
		for(int k = 0 ; rest - k * arr[i] >=0 ; k++) {
			int next = process(arr, i+1, rest - k * arr[i]);
			if(next != -1) {
				rest = res == -1 ? next + k : Math.min(res, next + k);
			}
		}
		return res;
		
		
	}
	//¶¯Ì¬¹æ»®
	public static int minCoins2(int[] arr, int aim) {
		if(arr == null|| arr.length == 0 || aim < 0) {
			return -1;
		}
		int N = arr.length;
		int[][] dp = new int[N+1][aim + 1];
		for(int i = 1; i <=aim ;i++) {
			dp[N][i] = -1;
		}
		for(int i = N-1;i >=0;i--) {
			for(int rest = 0; rest<=aim;rest++) {
				dp[i][rest] = -1;
				if(dp[i+1][rest] != -1) {
					dp[i][rest] =dp[i+1][rest]; 
				}
				if(rest - arr[i] >= 0 && dp[i][rest -arr[i]] != -1) {
					if(dp[i][rest] == -1) {
						dp[i][rest] = dp[i][rest -arr[i]] +1;
					}else {
						dp[i][rest] = Math.min(dp[i][rest-arr[i]] +1, dp[i][rest]);
					}
				}
			}
		}
		return dp[0][aim];
	}
}
