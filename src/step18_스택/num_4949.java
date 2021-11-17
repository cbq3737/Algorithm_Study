package step17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class num_4949 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = 0;
		while (t == 0) {
			String line = br.readLine();
			if (line.equals("."))
				break;
			boolean chk = true;
			Stack<Character> stack = new Stack<Character>();
			for (int i = 0; i < line.length(); i++) {
				char c = line.charAt(i);
				if (c == '(' || c == '[') {
					stack.add(c);
				} else if (c == ')') {
					if (!stack.empty() && stack.pop() == '(')
						continue;
					else {
						chk = false;
						break;
					}
				} else if (c == ']') {
					if (!stack.empty() && stack.pop() == '[')
						continue;
					else {
						chk = false;
						break;
					}
				}
			}
			if (chk && stack.isEmpty()) {
				System.out.println("yes");
			} else {
				System.out.println("no");
			}

		}
	}
}
