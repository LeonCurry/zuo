package class_08;

public class Pring_All_Subsquences {
	public static void printAllSubsquence(String str) {
		char[] ch = str.toCharArray();
		process(ch, 0);
	}
	public static void process(char[] ch, int i) {
		if(i == ch.length) {
			System.out.println(String.valueOf(ch));
			return;
		}
		process(ch, i + 1);
		char tmp = ch[i];
		ch[i] = 0;
		process(ch, i + 1);
		ch[i] = tmp;
		
	}
	public static void printAllSub(char[] str, int i, String res) {
		if(i == str.length) {
			System.out.println(res);
			return;
		}
		printAllSub(str, i+1, res);
		printAllSub(str, i+1, res + String.valueOf(str[i]));
	}
	public static void main(String[] args) {
		String string = "acb";
		//printAllSubsquence(string);
		printAllSub(string.toCharArray(), 0, "");
	}
}
