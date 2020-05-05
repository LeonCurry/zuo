package book_chapter5_string;

import java.util.Scanner;

public class MaxUnique {
	public static int maxUnique(String str) {
		if(str == null || str.length() == 0) {
			return 0;
		}
		char[] chas = str.toCharArray();
		int[] map = new int[256];
		for(int i = 0 ; i < 256;i++) {
			map[i] = -1;
		}
		int cur = 0;
		int pre = -1;
		int len = 0;
		for(int i = 0 ; i < chas.length; i++) {
			pre = Math.max(pre, map[chas[i]]);
			cur = i - pre;
			len = Math.max(cur, len);
			map[chas[i]] = i;
		}
		return len;
		
	}
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String str = in.nextLine();
		int res = maxUnique(str);
		System.out.println(res);
		
	}
}
