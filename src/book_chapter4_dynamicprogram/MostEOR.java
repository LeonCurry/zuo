package book_chapter4_dynamicprogram;

import java.util.HashMap;
import java.util.Scanner;

public class MostEOR {
	public static int mostEOR(int[] arr) {
		if(arr == null || arr.length == 0) {
			return 0;
		}
		int[] dp = new int[arr.length];
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		int eor = 0;
		map.put(0, -1);
		dp[0] = arr[0] == 0 ? 1 : 0;
		map.put(arr[0], 0);
		eor ^= arr[0];
		for(int i = 1 ; i < arr.length ; i++) {
			eor ^= arr[i];
			if(map.containsKey(eor)) {
				int preEorIndex = map.get(eor);
				dp[i] = preEorIndex == -1 ? 1 : (dp[preEorIndex] + 1);
			}
			map.put(eor , i);
			dp[i] = Math.max(dp[i - 1], dp[i]);
		}
		return dp[dp.length - 1];
	}
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int len = Integer.valueOf(in.nextLine());
		String[] data = in.nextLine().split(" ");
		int[] arr = new int[len];
		for(int i = 0 ; i < len; i++) {
			arr[i] = Integer.valueOf(data[i]);
		}
		int res = mostEOR(arr);
		System.out.println(res);
	}
}
