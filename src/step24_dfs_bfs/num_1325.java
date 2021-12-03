package step24_dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class num_1325 {
	public static boolean[] visited;
	public static int max = -1;
	public static int nNum;
	static Node[] adjList ;
	public static Queue<Integer> queue ;
	static class Node{
		int vertex; //인접정점 인덱스
		Node link;
		public Node(int vertex,Node link) {
			this.vertex=vertex;
			this.link = link;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		nNum = Integer.parseInt(tk.nextToken());
		int mNum = Integer.parseInt(tk.nextToken());
		adjList = new Node[nNum+1];
		for(int i=0;i<mNum;i++) {
			tk = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(tk.nextToken());
			int to = Integer.parseInt(tk.nextToken());
			adjList[to] = new Node(from,adjList[to]); 
		}
		queue = new LinkedList();
		int[] arr = new int[nNum+1];
		for(int i=1;i<=nNum;i++) {
			int cnt = bfs(i);
			arr[i] = cnt;	
		}
		for(int i=1;i<=nNum;i++) {
			if(max==arr[i]) {
				sb.append(i+" ");
			}
		}
		sb.setLength(sb.length()-1);
		System.out.println(sb);
	}
	public static int bfs(int startNode) {
		int cnt = 0;
		
		visited =new boolean[nNum+1];
		visited[startNode] = true;
		queue.offer(startNode);
		while(!queue.isEmpty()) {
			int current = queue.poll();
			cnt++;					
			for(Node temp =adjList[current];temp!=null;temp = temp.link) {	
				if(!visited[temp.vertex]) {
					queue.offer(temp.vertex);
					visited[temp.vertex] = true;
				}
			}
		}
		if(cnt>max) {
			max = cnt;
		}
		return cnt;
	}
}
