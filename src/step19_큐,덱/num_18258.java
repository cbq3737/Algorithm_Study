package step18;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class num_18258 {
	public static int x = -1;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int nNum = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		Queue<Integer> queue = new LinkedList(); // 아예LinkedList로 
		for(int i=0;i<nNum;i++) {
			StringTokenizer tk = new StringTokenizer(br.readLine());
			String command = tk.nextToken();
			switch(command) {
				case "push" :
					x = Integer.parseInt(tk.nextToken());
					queue.offer(x);
					break;
				case "pop":
					if(!queue.isEmpty()) {
						sb.append(queue.poll()+"\n");
					}else {
						sb.append(-1+"\n");
					}
					break;
				case "size":
					sb.append(queue.size()+"\n");
					break;
				case "empty":
					if(!queue.isEmpty()) {
						sb.append(0+"\n");
					}else {
						sb.append(1+"\n");
					}
					break;
				case "front":
					if(!queue.isEmpty()) {
						sb.append(queue.peek()+"\n");
					}else {
						sb.append(-1+"\n");
					}
					break;
				case "back":
					if(!queue.isEmpty()) {
						sb.append(x+"\n");
					}else {
						sb.append(-1+"\n");
					}
					break;
				default :
					break;
			}
		}
		System.out.println(sb);
	}

}
