package book_chapter5_string;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class GetValue {
	public static int getValue(String exp) {
		return value(exp.toCharArray(), 0)[0];
	}
	public static int[] value(char[] chas, int i) {
		Deque<String> deq = new LinkedList<String>();
		int pre = 0;
		int[] bra = null;
		while(i < chas.length && chas[i] != ')') {
			if(chas[i] >='0' && chas[i] <='9') {
				pre = pre *10 +( chas[i++] -'0');
			}else if(chas[i] != '(') {
				addNum(deq, pre);
				deq.addLast(String.valueOf(chas[i++]));
				pre = 0 ;
			}else {
				bra = value(chas, i+1);
				pre = bra[0];
				i = bra[1] +1;
			}
		}
		addNum(deq, pre);
		return new int[] { getNum(deq) , i};
	}
	public static void addNum(Deque<String> deq, int num) {
		
		if(!deq.isEmpty()) {
			int cur = 0;
			String top = deq.pollLast();
			if(top.equals("+") || top.equals("-")) {
				deq.addLast(top);
			}else {
				cur = Integer.valueOf(deq.pollLast());
				num = top.equals("*") ? (num * cur) : (cur / num);
			}			
		}		
		deq.addLast(String.valueOf(num));
	}
	public static int getNum(Deque<String> deq) {
		int res = 0;
		boolean add = true;
		String cur = null;
		int num = 0;
		while(!deq.isEmpty()) {
			cur = deq.pollFirst();
			if(cur.equals("+")) {
				add = true;
			}else if(cur.equals("-")) {
				add = false;
			}else {
				num = Integer.valueOf(cur);
				res += add? num : (-num);
			}
		}
		return res;
	}
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String str = in.nextLine();
		int res = getValue(str);
		System.out.println(res);
	}
}
