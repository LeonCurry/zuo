package class_08;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.IconifyAction;

public class Hanoi {
	public static void solve(int n, String from, String help, String to) {
		if(n == 1) {
			System.out.println(n+ "从" + from +"移动到" + to);
		}else {
			solve(n-1, from, to, help);
			System.out.println(n + "从" + from +"移动到" + to);
			solve(n-1, help, from, to);
		}
	}
	public static void main(String[] args) {
		solve(3, "左", "中", "右");
	}
}
