package step17;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class num_2504 {//괄호의 값
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Character> stack = new Stack();
		Stack<Character> new_stack = new Stack();
		String str = br.readLine();
		for(int i=0;i<str.length();i++) {
			stack.push(str.charAt(i));
		}
		check_oper(stack,new_stack);
	}
	public static void check_oper(Stack<Character> stack,Stack<Character> new_stack) {
		//마지막 뺏을때 size가 1인데 숫자라면 종료 
		
		
		//새로운 스택으로 옮기면서 올바른 괄호 숫자로 한번 바꿔주고
		while(!stack.isEmpty()) {
			char c = stack.pop();
			char pre_c=stack.peek();
			if(c=='['&&pre_c==']') {
				new_stack.pop();
				new_stack.push('3');
			}else if(c=='('&&pre_c==')') {
				new_stack.pop();
				new_stack.push('2');
			}else {
				new_stack.push(c);
			}
		}
	
		//다시 스택으로 변환하면서 숫자 변환
		while(!new_stack.isEmpty()) {
			
		}
		check_oper(stack,new_stack);
	}
}
