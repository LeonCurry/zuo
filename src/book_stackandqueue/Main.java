package book_stackandqueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
/*
 *  ‰»Î£∫
 * 5
 * 5 8 4 3 6
 *  ‰≥ˆ£∫
 * 8 6 5 4 3
 */
public class Main {
	
	public static void main(String[] args) throws IOException {
        Stack<Integer> stack = new Stack<>();
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int row = Integer.parseInt(in.readLine());
        
        String[] item = in.readLine().split(" ");       
        
        for (int i = 0; i < row; i++) {
            stack.push(Integer.parseInt(item[i]));
        }
 
        stack = SortStackByStack.sortStackByStack(stack);
 
        StringBuilder sb = new StringBuilder();
        while (!stack.empty()) {
            sb.append(stack.pop()).append(" ");
        }
        System.out.println(sb.substring(0, sb.length() - 1));
    }
}
