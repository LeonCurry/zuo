package class_08;

public class Factorial {
	public static long getFactorial(int n) {
		if(n == 1) {
			return 1L;
		}
		return (long) n * getFactorial(n-1);
	}
	public static void main(String[] args) {
		long result = getFactorial(5);
		System.out.println(result);
	}
}
