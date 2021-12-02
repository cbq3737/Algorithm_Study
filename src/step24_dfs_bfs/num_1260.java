package step23_dfs_bfs;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class num_1260 {
	public static int nNum;
	public static boolean[][] map;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk = new StringTokenizer(br.readLine());
		nNum = Integer.parseInt(tk.nextToken());
		int mNum = Integer.parseInt(tk.nextToken());
		int startNode = Integer.parseInt(tk.nextToken());
		map = new boolean[nNum+1][nNum+1];
		boolean[] visited = new boolean[nNum+1];
		for(int i=0;i<mNum;i++) {
			tk = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(tk.nextToken());
			int end = Integer.parseInt(tk.nextToken());
			map[start][end] = true;
			map[end][start]= true;
		}
		dfs(visited,startNode);
		System.out.println();
		visited = new boolean[nNum+1];
		bfs(startNode,visited);
	}
	public static void bfs(int startNode,boolean[] visited) {
		Queue<Integer> queue =  new LinkedList<>();
		queue.offer(startNode);
		visited[startNode]= true;
		while(!queue.isEmpty()) {
			int node = queue.poll();
			System.out.print(node +" ");
			for(int i=1;i<=nNum;i++) {
				if(map[node][i]&&!visited[i]) {
					visited[i] =true;
					queue.offer(i);
				}
			}
		}
	}
	public static void dfs(boolean[] visited,int current) {
		visited[current] = true;
		System.out.print(current+" ");
		for(int i=1;i<=nNum;i++) {
			if(!visited[i]&&map[current][i]) {
				dfs(visited,i);
			}
		}
	}
}
