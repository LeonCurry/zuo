package book_chapter4_dynamicprogram;

import book_chapter2_linkedlist.Convert.ReturnType;

public class Lcst {
	public static int[][] getdp(char[] str1, char[] str2){
		int[][] dp = new int[str1.length][str2.length];
		for(int i = 0 ; i < str1.length ; i++) {
			if(str1[i] ==str2[0]) {
				dp[i][0] = 1;
			}
		}
		for(int i = 0; i < str2.length;i++) {
			if(str1[0] == str2[i]) {
				dp[0][i] = 1;
			}
		}
		for(int i = 1 ; i < str1.length ; i++) {
			for(int j = 1; j < str2.length ; j++) {
				if(str1[i] == str2[j]) {
					dp[i][j] = dp[i-1][j-1] +1;
				}
			}
		}
		return dp;
	}
	public static String lcst(String str1, String str2) {
		if(str1 == null || str2 == null|| str1.equals("") || str2.equals("")) {
			return "";
		}
		char[] chas1 = str1.toCharArray();
		char[] chas2 = str2.toCharArray();
		int[][] dp = getdp(chas1, chas2);
		int max = 0 ;
		int end = 0;
		for(int i = 0 ; i < dp.length ; i++) {
			for(int j = 0 ; j < dp[0].length ; j++) {
				if(dp[i][j] > max) {
					end = i;
					max = dp[i][j];
				}
			}
		}
		return str1.substring(end - max+1, end+1);
	}
	public static String lcst2(String str1, String str2) {
		if(str1 == null || str2 == null || str1.equals("") || str2.equals("")) {
			return "";
		}
		char[] chas1 = str1.toCharArray();
		char[] chas2 = str2.toCharArray();
		int row = 0;
		int col = chas2.length - 1;
		int max = 0;
		int end = 0;
		while(row < chas1.length) {
			int i = row;
			int j = col;
			int len = 0;
			while(i < chas1.length && j < chas2.length) {
				if(chas1[i] != chas2[j]) {
					len = 0;
				}else {
					len++;
				}
				if(len > max) {
					max = len;
					end = i;
				}
				i++;
				j++;
			}
			if(col > 0) {
				col--;
			}else {
				row++;
			}
		}
		return str1.substring(end - max + 1, end + 1);
	}
}
