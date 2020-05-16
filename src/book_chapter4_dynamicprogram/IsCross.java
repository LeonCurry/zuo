package book_chapter4_dynamicprogram;

public class IsCross {
	public static boolean isCross1(String str1, String str2, String aim) {
		if(str1 == null || str2 == null || aim == null) {
			return false;
		}
		char[] chas1 = str1.toCharArray();
		char[] chas2 = str2.toCharArray();
		char[] chasAim = aim.toCharArray();
		if(chasAim.length != chas1.length + chas2.length) {
			return false;
		}
		boolean[][] dp = new boolean[chas1.length+1][chas2.length+1];
		dp[0][0] = true;
		for(int i = 1; i < chas1.length + 1; i++) {
			if(chas1[i - 1] != chasAim[i - 1]) {
				break;
			}
			dp[i][0] = true;
		}
		for(int j = 1; j < chas2.length+1;j++) {
			if(chas2[j-1] != chasAim[j - 1]) {
				break;
			}
			dp[0][j] = true;
		}
		for(int i = 1 ; i <= chas1.length ; i++) {
			for(int j = 1; j <= chas2.length; j++) {
				if(chas1[i - 1] == chasAim[i + j - 1] && dp[i - 1][j] || chas2[j - 1] == chasAim[i + j - 1] && dp[i][j-1]) {
					dp[i][j] = true;
				}
			}
		}
		return dp[chas1.length - 1][chas2.length - 1];
	}
}
