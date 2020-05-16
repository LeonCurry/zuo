package book_chapter7_bit;

public class PrintOddTimesNum {
	public static int printOddTimesNum1(int[] arr) {
		int eO = 0;
		for(int num : arr) {
			eO ^= num;
		}
		return eO;
	}
	public static void printOddTimesNum2(int[] arr) {
		int eO = 0 , eOhasOne = 0;
		for(int num : arr) {
			eO ^= num;
		}
		int rightOne = eO &(~eO +1);
		for(int cur : arr) {
			if((cur & rightOne) != 0) {
				eOhasOne ^= cur;
			}
		}
		System.out.println(eOhasOne +" " + (eO ^ eOhasOne));
	}
}
