package step18;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class num_2164 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int nNum= Integer.parseInt(br.readLine());
		Queue<Integer> deque = new LinkedList();
		for(int i=1;i<=nNum;i++) {
			deque.offer(i);
		}
		int card = 1;
		int bottom = -1;
		while(!deque.isEmpty()) {
			deque.poll();
			if(!deque.isEmpty()) {				
				bottom = deque.poll();
			}else {
				break;
			}
			deque.offer(bottom);
			card = deque.peek();
		}
		System.out.println(card);
	}
}
