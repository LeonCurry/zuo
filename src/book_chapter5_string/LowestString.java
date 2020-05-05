package book_chapter5_string;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;


public class LowestString {
	public static String lowestString(String[] strs) {
		if(strs == null || strs.length == 0) {
			return "";
		}
		Arrays.sort(strs, new MyComparator());
		String res = "";
		for(int i = 0 ; i < strs.length ; i++) {
			res+=strs[i];
		}
		return res;
	}
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int len = Integer.valueOf(in.nextLine());
		String[] strs = new String[len];
		for(int i = 0 ; i < len ; i++) {
			strs[i] = in.nextLine();
		}
		String res = lowestString(strs);
		System.out.println(res);
	}
}
class MyComparator implements Comparator<String>{
	@Override
	public int compare(String a, String b) {
		return (a+b).compareTo(b+a);
	}
}
