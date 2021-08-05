import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class swea_1218 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for (int tc = 0; tc < 10; tc++) {
			int t_case = Integer.parseInt(br.readLine());
			String str = br.readLine();
			Stack<Character> stack = new Stack<>();
			for (int i = 0; i < t_case; i++) {
				char c = str.charAt(i);
			
				if (c == ')') {
					if (!stack.empty()&&stack.peek() == '(') {
						stack.pop();
					} else {
						stack.push(c);
					}
				} else if (c == '}') {
					if (!stack.empty()&&stack.peek() == '{') {
						stack.pop();
					} else {
						stack.push(c);
					}
				} else if (c == ']') {
					if (!stack.empty()&&stack.peek() == '[') {
						stack.pop();
					} else {
						stack.push(c);
					}
				} else if (c == '>') {
					if (!stack.empty()&&stack.peek() == '<') {
						stack.pop();
					} else {
						stack.push(c);
					}
				}else { //push를 나중에 넣은 이유 : 앞에다가 넣으면 peek이 방금넣은애를 보게됨.
					stack.push(c);
				}
			}
			sb.append("#" + (tc + 1) + " ");
			if (!stack.isEmpty()) {
				sb.append(0 + "\n");
			} else {
				sb.append(1 + "\n");
			}
		}
		System.out.println(sb);
	}
}
