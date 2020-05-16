package book_chapter4_dynamicprogram;

public class MinCost {
	public static int minCost1(String str1, String str2,int ic, int dc, int rc) {
		if(str1 == null || str2 == null) {
			return 0;
		}
		char[] chas1 = str1.toCharArray();
		char[] chas2 = str2.toCharArray();
		int row = chas1.length+1;
		int col = chas2.length+1;
		int[][] dp = new int[row][col];
		for(int i = 1; i < row; i++) {
			dp[i][0] = i * dc;
		}
		for(int i = 1; i < col;i++) {
			dp[0][i] = i * ic;
		}
		for(int i = 1; i < row;i++) {
			for(int j = 1; j < col; j++) {
				if(chas1[i -1] ==chas2[j-1]) {
					dp[i][j] = dp[i-1][j-1];
				}else {
					dp[i][j] = dp[i - 1][j - 1]+1;
				}
				dp[i][j] = Math.min(dc + dp[i -1][j], dp[i][j]);
				dp[i][j] = Math.min(ic + dp[i][j -1], dp[i][j]);
				
			}
		}
		return dp[row-1][col-1];
	}
}
