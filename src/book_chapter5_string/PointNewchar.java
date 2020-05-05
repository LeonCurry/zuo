package book_chapter5_string;

import java.util.Scanner;
import java.util.Stack;

public class PointNewchar {
	public static String pointNewchar(String s, int k) {
		if(s == null || s.length() == 0 || k < 0 || k>=s.length()) {
			return "";
		}
		char[] chas = s.toCharArray();
		int num = 0 ;
		Stack<String> res = new Stack<String>();
		String str = "";
		while(num <= k) {
			if(chas[num] >='a' && chas[num] <= 'z') {
				str = str + chas[num];				
				res.push(str);
				str = "";
				num += 1;
			}
			if(chas[num] >='A' && chas[num] <= 'Z') {
				str = str + chas[num]+chas[num+1];
				res.push(str);
				str = "";
				num+=2;
			}
		}
		return res.pop();
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String[] str = in.nextLine().split(" ");
		//int len = Integer.valueOf(str[0]);
		int k = Integer.valueOf(str[1]);
		String s = in.nextLine();
		String res = pointNewchar(s , k);
		System.out.println(res);
	}
}
