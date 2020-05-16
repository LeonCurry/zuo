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
	//ֻ����������е�1�й�ϵ
	public static int count2(int n) {
		int res = 0 ; 
		while(n !=0) {
			n &= (n -1);
			res++;
		}
		return res;
	}
	//�뷽��2����
	public static int count3(int n) {
		int res = 0;
		while(n != 0) {
			n -= n&(~n + 1);
		}
		return res;
	}
}
