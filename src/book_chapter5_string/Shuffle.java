package book_chapter5_string;

import java.util.Arrays;
import java.util.Scanner;


public class Shuffle {
	public static void shuffle(int[] arr) {
		if(arr != null && arr.length != 0 && arr.length % 2 == 0) {
			shuffle(arr, 0 , arr.length-1);
		}
	}
	public static void wiggleSort(int [] arr) {
		if(arr == null || arr.length == 0) {
			return;
		}
		Arrays.sort(arr);
		if((arr.length & 1) == 1) {
			shuffle(arr, 1, arr.length-1);
		}else {
			shuffle(arr, 0, arr.length-1);
			for(int i = 0 ; i <arr.length ; i +=2) {
				int temp = arr[i];
				arr[i] = arr[i+1];
				arr[i+1] = temp;
			}
		}
	}
	public static void shuffle(int[] arr, int L, int R) {
		while(R-L+1 > 0) {
			int len = R - L +1;
			int base = 3;
			int k = 1;
			while(base <= (len+1)/3) {
				base *= 3;
				k++;
			}
			int half = (base -1) /2;
			int mid = (R + L)/2;
			rotate(arr, L + half , mid, mid +half);
			cycles(arr, L , base -1,k);
			L = L+base -1;
		}		 
	}
	public static void cycles(int[] arr, int start, int len, int k) {
		for(int i = 0 , trigger = 1; i < k;i++, trigger*=3) {
			int preValue = arr[trigger + start - 1];
			int cur = modifyIndex(trigger, len);
			while(cur != trigger) {
				int temp = arr[cur + start -1];
				arr[cur + start - 1] = preValue;
				preValue = temp;
				cur = modifyIndex(cur, len);
			}
			arr[cur + start -1] = preValue;
		}
	}
	public static int modifyIndex(int i, int len) {
		return (2 * i) % (len + 1);
	}
	public static void rotate(int[] arr, int L, int M, int R) {
		reverse(arr, L , M);
		reverse(arr, M+1, R);
		reverse(arr, L, R);
	}
	public static void reverse(int[] arr, int L, int R) {
		while(L < R) {
			int temp = arr[L];
			arr[L++] = arr[R];
			arr[R--] = temp;
		}
		
	}
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in) ;
		int len = Integer.valueOf(in.nextLine());
		String[] str = in.nextLine().split(" ");
		int[] data = new int[len];
		for(int i = 0 ; i < len ; i++) {
			data[i] = Integer.valueOf(str[i]);
		}
		wiggleSort(data);
		for(int i = 0 ; i < len; i++) {
			System.out.print(data[i] + " ");
		}
	}
}
