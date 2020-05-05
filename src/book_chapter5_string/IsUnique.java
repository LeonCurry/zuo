package book_chapter5_string;

import java.util.HashSet;
import java.util.Scanner;



public class IsUnique {
	public static boolean isUnique1(char[] chas) {
		if(chas == null) {
			return true;
		}
		HashSet<Character> set = new HashSet<Character>();
		for(int i = 0 ; i < chas.length ; i++) {
			if(set.contains(chas[i])) {
				return false;
			}
			set.add(chas[i]);
		}
		return true;
	}
	
	/*********************方法二空间复杂度为O(1),时间复杂度为O（NlogN）**********************/
	public static boolean isUnique2(char[] chas) {
		if(chas == null) {
			return true;
		}
		heapSort(chas);
		for(int i = 1 ; i < chas.length ; i++) {
			if(chas[i] == chas[i-1]) {
				return false;
			}
		}
		return true;
	}
	public static void heapSort(char[] chas) {
		for(int i = 0 ; i < chas.length ; i++) {
			heapInsert(chas, i);
		}
		for(int i = chas.length-1; i >0 ; i--) {
			swap(chas, 0 , i);
			heapify(chas , 0 , i);
		}
	}
	//构建大根堆
	public static void heapInsert(char[] chas, int i) {
		int parent = 0;
		while(i != 0) {
			parent = (i-1)/2;
			if(chas[parent] < chas[i]) {
				swap(chas, parent, i);
				i = parent;
			}else {
				break;
			}
		}
	}
	public static void heapify(char[] chas, int i, int size) {
		int left = i*2+1;
		int right = i*2+2;
		int largest = i;
		while(left<size) {
			if(chas[largest] < chas[left]) {
				largest = left;
			}
			if(right < size && chas[largest] < chas[right]) {
				largest = right;
			}
			if(i != largest) {
				swap(chas, i, largest);
			}else {
				break;
			}
			i = largest;
			left = i*2 +1;
			right = i*2+2;
		}
	}
	
	public static void swap(char[] chas , int index1, int index2) {
		char temp = chas[index1];
		chas[index1] = chas[index2];
		chas[index2]  = temp;
	}
	
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String str = in.nextLine();
		char[] chas = str.toCharArray();
		boolean res = isUnique1(chas);
		System.out.println(res);
	}
}
