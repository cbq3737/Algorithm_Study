import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class swea_1223 {
	public static int sum;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int tcase = Integer.parseInt(br.readLine());
		for(int t=0;t<tcase;t++) {
			Stack<Character> oper = new Stack<>();
			int nNum = Integer.parseInt(br.readLine());
			String origin = br.readLine();
			String back_oper="";
			for(int i=0;i<nNum;i++) {
				if(origin.charAt(i)=='+') { //+면 빼줌,-> *가 우선순위가 더 높으므로
					if(!oper.isEmpty()) { 
						while(!oper.isEmpty()) {
							back_oper+=oper.pop();
						}
						oper.push(origin.charAt(i));
					}else {						
						oper.push(origin.charAt(i));
					}
				}else if(origin.charAt(i)=='*') {
					oper.push(origin.charAt(i));
				}else {
					back_oper+=origin.charAt(i);					
				}
			}
			while(!oper.isEmpty()) {
				back_oper+=oper.pop();
			}
		sum = 0;
		Stack<Integer> num_stack = new Stack<>();
		makeOperation(back_oper,num_stack);
		sb.append("#"+(t+1)+" "+sum+"\n");
		}
		System.out.println(sb);
	}
	public static void makeOperation(String back_oper,Stack<Integer> num_stack) {
		for(int i=0;i<back_oper.length();i++) {
			char c = back_oper.charAt(i);
			if(c>='0'&&c<='9') {
				num_stack.push(c-'0');
			}else if(!num_stack.isEmpty()&&c=='+') {
				num_stack.push( num_stack.pop()+num_stack.pop());
			}else if(!num_stack.isEmpty()&&c=='*') {
				num_stack.push(num_stack.pop()*num_stack.pop());
			}
		}
		if(!num_stack.isEmpty()) {
			sum = num_stack.pop();
		}
		return;
	}
}
