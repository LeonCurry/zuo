package book_chapter5_string;

import java.util.Scanner;

public class IsRotation {
	public static boolean isRotation(String str1, String str2) {
		if(str1 == null || str2 == null || str1.length() != str2.length()) {
			return false;
		}
		String b = str2 + str2;
		return getIndexOf(b , str1) != -1;
	}
	public static int getIndexOf(String s, String m) {
		char[] ss = s.toCharArray();
		char[] ms = m.toCharArray();
		int si = 0;
		int mi = 0;
		int[] next = getNextArray(ms);
		while(si < ss.length && mi < ms.length) {
			if(ss[si] == ms[mi]) {
				si++;
				mi++;
			}else if(next[mi] == -1) {
				si++;
			}else {
				mi = next[mi];
			}
		}
		return mi == ms.length ? si - mi : -1;
	}
	
	public static int[] getNextArray(char[] ms) {
		if(ms.length == 1) {
			return new int[] {-1};
		}
		int[] next = new int[ms.length];
		next[0] = -1;
		next[1] = 0;
		int pos = 2;
		int cn = 0;
		while(pos < next.length) {
			if(ms[pos -1 ] == ms[cn]) {
				next[pos++] = ++cn;
			}else if(cn > 0) {
				cn = next[cn];
			}else {
				next[pos++] = 0;
			}
		}
		return next;
	}
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String[] len = in.nextLine().split(" ");	
		String str1 = in.nextLine();
		String str2 = in.nextLine();
		boolean result = isRotation(str1, str2);
		System.out.println(result);
	}
}
