package book_chapter4_dynamicprogram;

import java.util.Scanner;

public class Num {
	public static int num1(String str) {
		if(str == null || str.equals("")) {
			return 0;
		}
		char[] chas = str.toCharArray();
		return process(chas, 0);
	}
	public static int process(char[] chas, int i) {
		if(i == chas.length) {
			return 1;
		}
		if(chas[i] == '0') {
			return 0;
		}
		int res = process(chas, i+1);
		if(i + 1 <chas.length && (chas[i] - '0') * 10 + chas[i+1]-'0' <27) {
			res += process(chas, i + 2);
		}
		return res;
	}
	public static int num2(String str) {
		if(str == null || str.equals("")) {
			return 0;
		}
		char[] chas = str.toCharArray();
		int cur = chas[chas.length - 1] == '0' ? 0 : 1;
		int next = 1;
		int temp = 0;
		for(int i = chas.length - 2; i >= 0;i--) {
			if(chas[i] == '0') {
				next = cur;
				cur = 0;
			}else {
				temp = cur;
				if((chas[i] - '0')*10 + chas[i+1]-'0' < 27) {
					cur += next;
				}
				next = temp;
			}
		}
		return cur;
	}
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String str = in.nextLine();
		int res = num2(str);
		System.out.println(res);
	}
}
