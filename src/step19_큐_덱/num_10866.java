package step19_큐_덱;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class num_10866 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int nNum = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		int num = 0;
		Deque<Integer> deque = new LinkedList<Integer>();
		for (int i = 0; i < nNum; i++) {
			StringTokenizer tk = new StringTokenizer(br.readLine());
			String command = tk.nextToken();
			switch (command) {
			case "push_back":
				num = Integer.parseInt(tk.nextToken());
				deque.addLast(num);
				break;
			case "push_front":
				num = Integer.parseInt(tk.nextToken());
				deque.addFirst(num);
				break;
			case "front":
				if (!deque.isEmpty()) {
					sb.append(deque.peekFirst() + "\n");
				} else {
					sb.append(-1 + "\n");
				}
				break;
			case "back":
				if (!deque.isEmpty()) {
					sb.append(deque.peekLast() + "\n");
				} else {
					sb.append(-1 + "\n");
				}
				break;
			case "size":
				sb.append(deque.size()+"\n");
				break;
			case "empty":
				if (!deque.isEmpty()) {
					sb.append(0 + "\n");
				} else {
					sb.append(1 + "\n");
				}
				break;
			case "pop_front":
				if (!deque.isEmpty()) {
					sb.append(deque.pollFirst()+"\n");
				} else {
					sb.append(-1+"\n");
				}
				break;
			case "pop_back":
				if (!deque.isEmpty()) {
					sb.append(deque.pollLast()+"\n");
				} else {
					sb.append(-1+"\n");
				}
				break;
			default:
				break;
			}
		}
		System.out.println(sb);

	}
}
