package book_chapter7_bit;

import java.util.Scanner;

public class GetMax {
	public static int flip(int n) {
		return n ^ 1;
	}
	public static int sign(int n) {
		return flip((n>>31) & 1);
	}
	public int getMax(int a, int b) {
		int c = a - b;
		int scA = sign(c);
		int scB = flip(scA);
		return a*scA + b*scB;
	}
	//·ÀÖ¹Òç³ö
	public static int getMax2(int a, int b) {
		int c = a - b;
		int sa = sign(a);
		int sb = sign(b);
		int sc = sign(c);
		int difSab = sa ^ sb;
		int sameSab = flip(difSab);
		int returnA = difSab * sa + sameSab* sc;
		int returnB = flip(returnA);
		return a * returnA + b * returnB;
	}
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String[] data = in.nextLine().split(" ");
		int a = Integer.valueOf(data[0]);
		int b = Integer.valueOf(data[1]);
		int res = getMax2(a, b);
		System.out.println(res);
	}
}
