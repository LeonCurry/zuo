package book_chapter5_string;

import java.util.Scanner;

public class MinDistance {
	public static int minDistance(String[] strs, String str1, String str2) {
		if(strs == null || strs.length == 0|| str1 == null || str2 == null) {
			return -1;
		}
		if(str1.equals(str2)) {
			return 0;
		}
		int last1 = -1;
		int last2 = -1;
		int min = Integer.MAX_VALUE;
		for(int i = 0 ; i<strs.length;i++) {
			if(strs[i].equals(str1)) {
				min = Math.min(min, last2 == -1 ? min : i - last2);
				last1 = i;
			}
			if(strs[i].equals(str2)) {
				min = Math.min(min,  last1 == -1 ? min : i - last1);
			}
		}
		return min == Integer.MAX_VALUE ? -1 : min;
	}
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int len = Integer.valueOf(in.nextLine());
		String[] str = in.nextLine().split(" ");
		String str1 = str[0];
		String str2 = str[1];
		String[] strs = new String[len];
		for(int i = 0 ; i < len ; i++) {
			strs[i] = in.nextLine();
		}
		int res = minDistance(strs, str1, str2);
		System.out.println(res);
	}
}
