import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class swea_1225 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for(int tc=0;tc<10;tc++) {
			Queue<Integer> queue = new LinkedList<>();
			int t_case = Integer.parseInt(br.readLine());
			StringTokenizer tk = new StringTokenizer(br.readLine());
			sb.append("#"+ (tc+1)+" ");
			for(int i=0;i<8;i++) {
				queue.offer(Integer.parseInt(tk.nextToken()));
			}
			int cnt =1;
			while(true) {
				int front = queue.poll();
				if(front-cnt<=0) {
					queue.offer(0);
					break;
				}else {						
					queue.offer(front-cnt);
				}
				if(cnt+1>5) {
					cnt=1;
				}else {					
					cnt++;
				}
			}
			for(int i=0;i<8;i++) {				
				sb.append(queue.poll()+" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
