package book_chapter5_string;

import java.util.Scanner;

public class IsDeformation {
	public static boolean isDeformation(String str1, String str2) {
		if(str1.length() != str2.length() || str1 == null || str2 == null) {
			return false;
		}
		char[] arr1 = str1.toCharArray();
		char[] arr2 = str2.toCharArray();
		int[] map = new int[256];
		for(int i = 0 ; i < str1.length(); i ++) {
			map[arr1[i]]++;
		}
		for(int i = 0 ; i < str2.length(); i++) {
			if(map[arr2[i]]-- == 0) {
				return false;
			}
		}
		return true;
	}
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String[] len = in.nextLine().split(" ");	
		String str1 = in.nextLine();
		String str2 = in.nextLine();
		boolean result = isDeformation(str1, str2);
		System.out.println(result);
	}
}
