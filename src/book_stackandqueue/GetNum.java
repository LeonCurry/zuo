package book_stackandqueue;

import java.util.LinkedList;
import java.util.Scanner;

public class GetNum {
	public static int getNum(int[] arr, int num) {
		if(arr == null || arr.length == 0 || num < 0) {
			return 0;
		}
		LinkedList<Integer> qmin = new LinkedList<Integer>();
		LinkedList<Integer> qmax = new LinkedList<Integer>();
		int res = 0;
		int i = 0;
		int j = 0;
		while(i < arr.length) {
			while(j < arr.length) {
				if(qmin.isEmpty() || qmin.peekLast() != j) {
					while(!qmin.isEmpty() && arr[qmin.peekLast()] >= arr[j]) {
						qmin.pollLast();
					}
					qmin.addLast(j);
					while(!qmax.isEmpty() && arr[qmax.peekLast()] <= arr[j]) {
						qmax.pollLast();
					}
					qmax.addLast(j);
				}
				if(arr[qmax.getFirst()] - arr[qmin.getFirst()] > num) {
					break;
				}
				j++;
				
			}
			//���ӵ�jʱ�Ѿ�������<=num�ˣ����Դ�j-1��j��
			res += j-i;
			if(qmin.peekFirst() == i) {
				qmin.pollFirst();
			}
			if(qmax.peekFirst() == i) {
				qmax.pollFirst();
			}
			i++;
		}
		return res;
	}
	/*
	 * ���룺
	 * 5 2 ��n ��num, nΪ���鳤�ȣ�
	 * 1 2 3 4 5 �����飩
	 * 
	 * �����12
	 */
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String[] row1 = in.nextLine().split(" ");
		int len = Integer.valueOf(row1[0]);
		int num = Integer.valueOf(row1[1]);
		String[] data = in.nextLine().split(" ");
		int[] arr = new int[len];
		for(int i = 0;i<len;i++) {
			arr[i] = Integer.valueOf(data[i]);
		}
		int res = getNum(arr, num);
		System.out.println(res);
	}
}
