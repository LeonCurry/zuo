package book_chapter5_string;

import java.util.Scanner;

public class GetIndex {
	public static int getIndex(String[] strs , String str) {
		if(strs == null || strs.length == 0 || str == null) {
			return -1;
		}
//		int res = 0;
		for(int i = 0 ; i < strs.length ; i++) {
			if(strs[i].equals(str)) {
				return i;
			}
		}
		return -1;
	}
	/*************二分法查找****************/
	public static int getIndex1(String[] strs, String str) {
		if(strs == null || strs.length == 0 || str == null) {
			return -1;
		}
		int res = -1;
		int left = 0;
		int right = strs.length - 1;
		int mid = 0;
		int i = 0;
		while(left <= right) {
			mid = (left + right) /2;
			if(strs[mid] != null && strs[mid].equals(str)) {
				res = mid;
				right = mid - 1;
			}else if(strs[mid] != null) {
				if(strs[mid].compareTo(str)<0) {
					left = mid + 1;
				}else {
					right = mid - 1;
				}
			}else {
				i = mid;
				while(strs[i] == null && --i >= left) {};
				if(i < left || strs[i].compareTo(str)<0) {
					left = mid + 1;
				}else {
					res = strs[i].equals(str) ? i : res;
					right = i -1;
				}
			}
		}
		return res;
	}
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int len = Integer.valueOf(in.nextLine());
		String str = in.nextLine();
		String[] strs = new String[len];
		for(int i = 0 ; i < len ; i++) {
			strs[i] = in.nextLine();
		}
		int res = getIndex(strs, str);
		System.out.println(res);
	}
}
