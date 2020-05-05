package book_chapter5_string;

import java.util.Scanner;

public class IsValid {
	public static boolean isValid(String str) {
		if(str == null || str.equals("")) {
			return false;
		}
		char[] chas = str.toCharArray();
		int status = 0;
		for(int i = 0 ; i < chas.length ; i++) {
			if(chas[i] != '(' && chas[i] != ')') {
				return false;
			}
			if(chas[i] == ')' && --status < 0) {
				return false;
			}
			if(chas[i] == '(') {
				status++;
			}
		}
		return status == 0;
	}
	public static int maxLength(String str) {
		char[] chas = str.toCharArray();
		int[] dp = new int[chas.length];
		int pre = 0 ;
		int res = 0;
		for(int i = 1; i < chas.length ; i++) {
			if(chas[i] == ')') {
				pre = i - dp[i-1] -1;
				if(pre >=0 && chas[pre] == '(') {
					dp[i] = dp[i-1]+2+(pre > 0 ? dp[pre -1] : 0);
				}
			}
			res = Math.max(res, dp[i]);
		}
		return res;
	}
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String str = in.nextLine();
		int res = maxLength(str);
//		boolean res = isValid(str);
//		if(res) {
//			System.out.println("YES");
//		}else {
//			System.out.println("NO");
//		}
		System.out.println(res);
	}
}
