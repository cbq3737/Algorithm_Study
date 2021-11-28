package step18;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class num_1158 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer tk = new StringTokenizer(br.readLine());
		int nNum = Integer.parseInt(tk.nextToken());
		int mNum = Integer.parseInt(tk.nextToken());
		
		Queue<Integer> queue = new LinkedList<Integer>();
		for(int i=0;i<nNum;i++) {
			queue.offer(i+1);
		}
		sb.append("<");
		
		int cnt =0;
		while(!queue.isEmpty()) {
			cnt++;
			int front = queue.poll();
			if(cnt%mNum==0) {				
				sb.append(front+", ");
			}else {				
				queue.offer(front);
			}
		}
		sb.setLength(sb.length() - 2);
		sb.append(">");
		System.out.println(sb);
	}
}
