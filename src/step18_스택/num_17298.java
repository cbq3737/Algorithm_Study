package step18_스택;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class num_17298 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int nNum = Integer.parseInt(br.readLine());
		Stack<Integer> stack = new Stack<>();

		StringTokenizer tk = new StringTokenizer(br.readLine());
		int[] arr = new int[nNum];

		for (int i = 0; i < nNum; i++) {
			arr[i] = Integer.parseInt(tk.nextToken());
		}
		for (int i = 0; i < nNum; i++) {
			while (true) {
				if (!stack.empty() && arr[i] > arr[stack.peek()]) {
					arr[stack.peek()] = arr[i];
					stack.pop();
				} else {
					stack.push(i);
					break;
				}
			}
		}
		while (!stack.empty()) {
			arr[stack.pop()] = -1;
		}

		for (int i = 0; i < nNum; i++) {
			bw.write(arr[i] + " ");
		}
		bw.flush();
	}
}