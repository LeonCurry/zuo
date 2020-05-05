package class_08;

import java.util.HashSet;

public class Print_All_Permutations {
	public static void printAllPermutations1(String str) {
		char[] ch = str.toCharArray();
		process1(ch, 0);
	}

	public static void process1(char[] chs, int i) {
		if(i == chs.length) {
			System.out.println(String.valueOf(chs));
		}
		for(int j = i; j<chs.length;j++) {
			swap(chs, i, j);
			process1(chs, i+1);
			swap(chs, i, j);
		}
	}
	public static void printAllPermutations2(String str) {
		char[] ch = str.toCharArray();
		process2(ch, 0);
	}
	public static void process2(char[] chs, int i) {
		if(i == chs.length) {
			System.out.println(String.valueOf(chs));
		}
		HashSet<Character> set = new HashSet<Character>();
		for(int j = i; j<chs.length;j++) {
			if(!set.contains(chs[j])) {
				System.out.println(i + "==> "+ j);
				System.out.println(chs[j]);
				set.add(chs[j]);
				System.out.println(set);
				swap(chs, i, j);
				process2(chs, i+1);
				swap(chs, i, j);
			}
			//System.out.println(set);

		}
	}
	
	public static void swap(char[] chs, int i, int j) {
		char tmp = chs[i];
		chs[i] = chs[j];
		chs[j] = tmp;
	}
	public static void main(String[] args) {
		String test1 = "abc";
//		printAllPermutations1(test1);
//		System.out.println("======");
		//printAllPermutations2(test1);
		//System.out.println("======");

		String test2 = "acc";
//		printAllPermutations1(test2);
//		System.out.println("======");
		printAllPermutations2(test2);
		//System.out.println("======");
	}

}
