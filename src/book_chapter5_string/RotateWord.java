package book_chapter5_string;

import java.util.Scanner;

public class RotateWord {
	public static void rotateWord(char[] chas) {
		if(chas == null || chas.length == 0) {
			return;
		}
		reverse(chas , 0, chas.length-1);
		int l = -1;
		int r = -1;
		for(int i = 0 ; i < chas.length; i++) {
			if(chas[i] !=' ') {
				l = i == 0 || chas[i-1] == ' ' ? i : l;
				r = i == chas.length-1 || chas[i+1] == ' '? i : r;
			}
			if(l!=-1 && r != -1) {
				reverse(chas, l, r);
				l = -1;
				r = -1;
			}
		}
	}
	
	public static void reverse(char[] chas, int start, int end) {
		char temp = 0;
		while(start < end) {
			temp = chas[start];
			chas[start] = chas[end];
			chas[end] = temp;
			start++;
			end--;
		}
	}
	
	public static void rotate1(char[] chas, int size) {
		if(chas == null || chas.length == 0) {
			return;
		}
		reverse(chas, 0, size-1);
		reverse(chas, size, chas.length-1);
		reverse(chas, 0, chas.length-1);
	}
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in) ;
		int len = Integer.valueOf(in.nextLine());
		String str = in.nextLine();
		char[] chas = str.toCharArray();
		rotate1(chas , len);
		for(int i = 0 ; i < chas.length ; i++) {
			System.out.print(chas[i]);
		}		
	}
}
