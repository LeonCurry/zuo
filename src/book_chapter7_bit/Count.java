package book_chapter7_bit;

public class Count {
	public static int count1(int n) {
		int res = 0;
		while(n != 0) {
			res += n & 1;
			n >>>= 1;
		}
		return res;
	}
	//只与二进制数中的1有关系
	public static int count2(int n) {
		int res = 0 ; 
		while(n !=0) {
			n &= (n -1);
			res++;
		}
		return res;
	}
	//与方法2类似
	public static int count3(int n) {
		int res = 0;
		while(n != 0) {
			n -= n&(~n + 1);
		}
		return res;
	}
}
