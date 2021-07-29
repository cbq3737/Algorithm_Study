package step17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class num_17298 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int nNum = Integer.parseInt(br.readLine());
		Stack<Integer> stack = new Stack<>();
		StringBuilder sb = new StringBuilder();
		StringTokenizer tk= new StringTokenizer(br.readLine());
		int[] arr = new int[nNum];
		
		for(int i=0;i<nNum;i++) {			
			arr[i] = Integer.parseInt(tk.nextToken());
		}
		int cnt = 0;
		for(int i=0;i<nNum;i++) {
			boolean flag = true;
			while(flag) {
				if(stack.empty()) {
					stack.push(arr[i]);
					cnt++;
				}else if(arr[i] > stack.peek()){
					stack.pop();
					cnt--;
					arr[cnt] = stack.peek();
				}	
			}
		}
		System.out.println(sb.toString());
	}
}
