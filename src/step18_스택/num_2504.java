package step18_스택;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class num_2504 {//괄호의 값
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<String> stack = new Stack();
		Stack<String> new_stack = new Stack();
		String str = br.readLine();
		for(int i=0;i<str.length();i++) {
			stack.push(Character.toString(str.charAt(i)));
		}
		check_oper(stack,new_stack);
	}
	public static void check_oper(Stack<String> stack,Stack<String> new_stack) {
		if(stack.size()<2) {
			if(stack.peek().equals("(")||stack.peek().equals(")")||stack.peek().equals("[")||stack.peek().equals("]")) {
				System.out.println(0);
			}else {
				System.out.println(stack.pop());
			}
			return;
		}
		boolean flag=false;
		//새로운 스택으로 옮기면서 올바른 괄호 숫자로 한번 바꿔주고
		String pre_c="";
		while(!stack.isEmpty()) {
			String c = stack.pop();
			if(new_stack.size()>0) {				
				pre_c=new_stack.peek();
			}
			if(c.equals("[")&&pre_c.equals("]")) {
				new_stack.pop();
				new_stack.push("3");
				flag= true;
			}else if(c.equals("(")&&pre_c.equals(")")) {
				new_stack.pop();
				new_stack.push("2");
				flag= true;
			}else {
				new_stack.push(c);
			}
		}
		
		
		//다시 스택으로 변환하면서 숫자 변환
		
		String open = "";//여는 괄호 
		int num =0;
		while(!new_stack.isEmpty()) {
			String c = new_stack.pop();
			if(c.equals("(")){//여는 괄호
				open= c;
				stack.push(c);
			}else if(c.equals("[")) {//여는 괄호
				open= c;
				stack.push(c);
			}else if(stack.size()>0&&c.equals(")")&&isNum(stack.peek())&&open.equals("(")) {//여는괄호, 숫자판단
				num = Integer.parseInt(stack.pop())*2;
				stack.pop();//열려있는괄호 빼기
				if(stack.size()>0&&isNum(stack.peek())) {//stack에 있는것이 이미 숫자라면
					int peek = Integer.parseInt(stack.pop());
					num+=peek;
				}
				flag= true;
				stack.push(Integer.toString(num));//다시 문자형으로
			}else if(stack.size()>0&&c.equals("]")&&isNum(stack.peek())&&open.equals("[")) {
				num = Integer.parseInt(stack.pop())*3;
				stack.pop();//
				if(stack.size()>0&&isNum(stack.peek())) {//stack에 있는것이 이미 숫자라면
					int peek = Integer.parseInt(stack.pop());
					num+=peek;
				}
				flag = true;
				stack.push(Integer.toString(num));//다시 문자형으로				
			}else if(stack.size()>0&&isNum(c)&&isNum(stack.peek())){//숫자만 남은 경우
				num = Integer.parseInt(c);
				int peek = Integer.parseInt(stack.pop());
				num+=peek;
				flag= true;
				stack.push(Integer.toString(num));
			}else {
				stack.push(c);
			}
		}
		if(!flag) {//변경된 게 없다??
			System.out.println(0);
			return;
		}else {			
			check_oper(stack,new_stack);
		}
	}
	public static boolean isNum(String str) {//숫자인지 판단
		for(int i=0;i<str.length();i++) {
			if(!Character.isDigit(str.charAt(i))) {
				return false;
			}
		}
		return true;
	}
}
