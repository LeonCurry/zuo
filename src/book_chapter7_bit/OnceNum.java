package book_chapter7_bit;

public class OnceNum {
	public static int onceNum(int[] arr, int k) {
		int[] eO = new int[32];
		for(int i = 0 ; i < arr.length ; i++) {
			setExclusiveOr(eO, arr[i],k);
		}
		int res = getNumFromKSysNum(eO, k);
		return res;
	}
	//
	public static void setExclusiveOr(int[] eO, int value, int k) {
		int[] curKSysNum = getKSysNumFromNum(value, k);
		for(int i = 0 ; i != eO.length;i++) {
			eO[i] = (eO[i] + curKSysNum[i]) % k;
		}
	}
	public static int[] getKSysNumFromNum(int value , int k) {
		int[] res = new int[32];
		int index = 0;
		while(value != 0) {
			res[index++] = value %k;
			value = value / k;
		}
		return res;
	}
	public static int getNumFromKSysNum(int[] eO , int k) {
		int res = 0;
		for(int i = eO.length -1; i != -1 ; i--) {
			res = res * k + eO[i];
		}
		return res;
	}
}
