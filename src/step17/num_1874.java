package step17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class num_1874 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int nNum = Integer.parseInt(br.readLine());
		Stack<Integer> stack = new Stack();
		StringBuilder sb = new StringBuilder();
		int idx = 1;
		boolean flag = true;
		for (int i = 0; i < nNum; i++) {
			int number = Integer.parseInt(br.readLine());

			while (number >= idx) { // 그 수까지 +
				stack.push(idx++);
				sb.append("+\n");
			}
			System.out.println(stack.peek());
			if(number!=stack.peek()) {
				break;
			}
			if(!stack.empty()) {				
				while (stack.peek() >= number) { // 스택 top이 그 수까지 -
					stack.pop();
					sb.append("-\n");
					if (stack.empty()) {
						break;
					}
				}
			}
		}
		if (stack.empty()) {
			System.out.println(sb.toString());
		} else {
			System.out.println("NO");
		}
	}
}
