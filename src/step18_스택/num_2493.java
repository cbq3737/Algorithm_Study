package step17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class num_2493 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int nNum = Integer.parseInt(br.readLine());
		int[] arr = new int[nNum + 1];
		StringTokenizer tk = new StringTokenizer(br.readLine());
		Stack<Integer> stack = new Stack<>();
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= nNum; i++) {
			arr[i] = Integer.parseInt(tk.nextToken());
		}
		for (int i = nNum; i > 0; i--) { // 반대로 인덱스 비교 없으면 그냥 0으로
				while (true) {
					if ( !stack.empty() && arr[stack.peek()] < arr[i]) {
						arr[stack.peek()] = i;
						stack.pop();
					} else {
						stack.push(i);
						break;
					}
				}
		}
		int size = stack.size();
		for(int i=0;i<size;i++) {
			arr[stack.peek()] =0;
			stack.pop();
		}
		for(int i=1;i<=nNum;i++) {
			sb.append(arr[i]+" ");
		}
		System.out.println(sb);
	}
}