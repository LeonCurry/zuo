package book_chapter5_string;

import java.util.Scanner;

public class GetCountString {
	public static String getCountString(String str) {
		if(str == null || str.equals("")) {
			return "";
		}
		char[] chas = str.toCharArray();
		String res = String.valueOf(chas[0]);
		int num = 1;
		for(int i = 1 ; i < chas.length ; i++) {
			if(chas[i] != chas[i - 1]) {
				res = res + "_" + num + "_" + chas[i];
				num = 1;
			}else {
				num++;
			}			
		}
		return res + "_" + num;
	}
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String str = in.nextLine();
		String res = getCountString(str);
		System.out.println(res);
	}
}
