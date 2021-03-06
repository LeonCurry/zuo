package book_chapter4_dynamicprogram;
import java.util.Scanner;

public class Lis {
	public static int[] getdp1(int[] arr) {
		int[] dp = new int[arr.length];
		for(int i = 0 ; i < arr.length ; i++) {
			dp[i] = 1;
			for(int j = 0 ;j < i ;j++) {
				if(arr[i] > arr[j]) {
					dp[i] = Math.max(dp[j] +1, dp[i]);
				}
			}
		}
		return dp;
	}
	public static int[] getdp2(int[] arr) {
		int[] dp = new int[arr.length];
		int[] ends = new int[arr.length];
		ends[0] = arr[0];
		dp[0] = 1;
		int right = 0;
		int l = 0;
		int r = 0;
		int m = 0;
		for(int i = 1;i < arr.length ; i++) {
			l = 0;
			r = right;
			while(l <= r) {
				m = (l + r) / 2;
				if(arr[i] >ends[m]) {
					l = m+1;
				}else {
					r = m - 1;
				}
			}
			right = Math.max(right, l);
			ends[l] = arr[i];
			dp[i] = l+1;
		}
		return dp;
	}
	public static int[] generateLIS(int[] arr, int[] dp) {
		int len = 0;
		int index = 0;
		for(int i = 0; i < dp.length;i++) {
			if(dp[i] > len) {
				len = dp[i];
				index = i;
			}
		}
		int[] lis = new int[len];
		lis[--len] = arr[index];
		for(int i = index; i>=0;i--) {
			if(arr[i] < arr[index] && dp[i] == dp[index] -1) {
				lis[--len] = arr[i];
				index = i;
			}
		}
		return lis;
	}
	public static int[] lis1(int[] arr) {
		if(arr == null || arr.length == 0) {
			return null;
		}
		int[] dp = getdp1(arr);
		return generateLIS(arr, dp);
	}
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int len = Integer.valueOf(in.nextLine());
		String[] data = in.nextLine().split(" ");
		int[] arr = new int[len];
		for(int i = 0 ; i < len ; i++) {
			arr[i] = Integer.valueOf(data[i]);
		}
		int[] res = lis1(arr);
		for (int i = 0; i < res.length; i++) {
			System.out.print(res[i] + " ");
		}
		
	}
}
