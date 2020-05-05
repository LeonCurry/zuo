package class_07;

import java.util.Arrays;
import java.util.Comparator;

public class Lowest {
	public static class MyComparator implements Comparator<String>{

		@Override
		public int compare(String a, String b) {
			return (a+b).compareTo(b + a);
		}
		
	}
	
	public static String lowestString(String[] str) {
		if(str == null) {
			return "";
		}
		Arrays.sort(str, new MyComparator());
		String	res = "";
		for(int i = 0;i<str.length;i++) {
			res += str[i];
		}
		return res;
	}
}
