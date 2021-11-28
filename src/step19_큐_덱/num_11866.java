package step19_큐_덱;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class num_11866 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk = new StringTokenizer(br.readLine());
		int nNum = Integer.parseInt(tk.nextToken());
		int kNum = Integer.parseInt(tk.nextToken());
		StringBuilder sb = new StringBuilder();
		Queue<Integer> queue = new LinkedList();
		for(int i=1;i<=nNum;i++) {
			queue.offer(i);
		}
		int cnt =0;
		sb.append("<");
		while(!queue.isEmpty()) {
			cnt++;
			if(cnt%kNum==0) {	
				sb.append(queue.poll()+", ");
				cnt=0;
			}else {				
				queue.offer(queue.poll());
			}
		}
		sb.deleteCharAt(sb.lastIndexOf(","));
		sb.deleteCharAt(sb.lastIndexOf(" "));
		sb.append(">");
		System.out.println(sb);
	}
}
