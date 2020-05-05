package book_chapter5_string;

import java.util.Scanner;


public class Replace {
	public static void replace(char[] chas) {
		if(chas == null || chas.length == 0) {
			return ;
		}
		int num = 0 ;
		int len = 0;
		for(len = 0 ; len <chas.length && chas[len] != '0' ; len++) {
			if(chas[len] == ' ') {
				num++;
			}
		}	
		int j = len + 2 * num-1;
		for(int i = len -1; i > -1; i--) {
			if(chas[i] != ' ') {
				chas[j--] = chas[i];
			}else {
				chas[j--] = '0';
				chas[j--] = '2';
				chas[j--] = '%';
			}
		}		
	}
	public static void modify(char[] chas) {
		if(chas == null || chas.length == 0) {
			return;
		}
		int j = chas.length - 1;
		for(int i = chas.length - 1; i >=0 ; i--) {
			if(chas[i] != '*') {
				chas[j--] = chas[i];
			}
		}
		for(; j >= 0 ;) {
			chas[j--] = '*';
		}
	}
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in) ;
		String str = in.nextLine();
		char[] chas = str.toCharArray();
		replace(chas);
		for(int i = 0 ; i < chas.length ; i++) {
			System.out.print(chas[i]);
		}		
	}
}
