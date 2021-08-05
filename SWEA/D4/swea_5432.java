import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class swea_5432 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tcase = Integer.parseInt(br.readLine());
		for(int i=0;i<tcase;i++) {
			String str= br.readLine();
			Stack<Character> stack = new Stack<>();
		
			int sum=0;
			for(int j=0;j<str.length();j++) {
				char c = str.charAt(j);
				if(c==')'&&str.charAt(j-1)=='(') { //레이저 세기
						stack.pop();
						sum+= stack.size();
				}else if(c==')'&& str.charAt(j-1)==')'){ //앞에 레이저가 있었으면 
					stack.pop();
					sum+=1;
				}else {
					stack.push(c);
				} 
				
			}
			System.out.println("# "+(i+1)+sum);
		}
	}
}
