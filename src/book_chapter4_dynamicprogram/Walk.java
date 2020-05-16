package book_chapter4_dynamicprogram;

public class Walk {
	public static int walk(int N, int cur, int rest, int P) {
		if(rest == 0) {
			return cur == P ? 1 : 0;
		}
		if(cur == 1) {
			return walk(N, 2 , rest - 1, P);
		}
		if(cur == N) {
			return walk(N, N - 1, rest - 1, P);
		}
		return walk(N, cur + 1, rest -1, P) + walk(N, cur - 1, rest - 1, P);
	}
	public static int ways1(int N, int M, int K, int P) {
		if(N < 2 || M <1 || M>N || K<1 || P <1|| P>N) {
			return 0;
		}
		return walk(N, M, K, P);
	}
	//动态规划，时间复杂度为O(N*K) 空间复杂度一样
	public static int ways2(int N, int M, int K, int P) {
		if(N<2 || M <1 || M >N || K < 1 || P <1 || P >N) {
			return 0;
		}
		int[][] dp = new int[K+1][N+1];
		dp[0][P] = 1;
		for(int i = 1; i <=K ;i++) {
			for(int j = 1; j <= N ;j++) {
				if(j == 1) {
					dp[i][j] = dp[i - 1][2];
				}else if(j == N) {
					dp[i][j] = dp[i - 1][N - 1];
				}else {
					dp[i][j] = dp[i - 1][j - 1]+ dp[i - 1][j + 1];
				}
			}
		}
		return dp[K][M];
	}
}
