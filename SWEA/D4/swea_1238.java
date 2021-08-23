import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class swea_1238 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for (int t = 0; t < 10; t++) {
			StringTokenizer tk = new StringTokenizer(br.readLine());
			int nNum = Integer.parseInt(tk.nextToken());
			int startNode = Integer.parseInt(tk.nextToken());

			boolean[][] map = new boolean[nNum][nNum];
			tk = new StringTokenizer(br.readLine());
			for (int i = 0; i < nNum / 2; i++) {
				int start = Integer.parseInt(tk.nextToken());
				int end = Integer.parseInt(tk.nextToken());
				map[start][end] = true;
			}

			Queue<Integer> queue = new LinkedList<>();
			queue.offer(startNode);
			int[] cnt = new int[nNum]; //방문여부
			boolean[] visited= new boolean[nNum];
			visited[startNode] = true;
			cnt[startNode] =1;
			int max = 0;
			while (!queue.isEmpty()) {
				int node = queue.poll();
				for (int i = 0; i < nNum; i++) {
					if (!visited[i]&&map[node][i]) {
						map[node][i]= false;// 방문하기위한 곳. false로 변경
						visited[i] = true;
						cnt[i] = cnt[node]+1; //나를 부른곳 +1
						max = Math.max(cnt[i],max);//최대값
						queue.offer(i);
					}
				}

			}
			int max_element =0;
			for(int i=0;i<cnt.length;i++) {
				if(cnt[i]==max) {
					max_element = Math.max(i, max_element);
				}
			}
			queue.clear();
			sb.append("#"+(t+1)+" "+max_element+"\n");
		}
		System.out.println(sb);
	}
}
