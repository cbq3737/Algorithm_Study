package step24;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class num_1753 {
	public static class Node implements Comparable<Node>{
		int to;
		int weight;

		public Node(int to, int weight) {
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Node o) {
			return this.weight-o.weight;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk = new StringTokenizer(br.readLine());
		int v = Integer.parseInt(tk.nextToken());
		int e = Integer.parseInt(tk.nextToken());
		int startNode = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		List<Node>[] list = new ArrayList[v+1];
		boolean[] visited = new boolean[v + 1];

		int[] distance = new int[v + 1];
		for(int i=1;i<=v;i++) {
			list[i]=new ArrayList<>();
		}
		for (int i = 1; i <= e; i++) {
			tk = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(tk.nextToken());
			int to = Integer.parseInt(tk.nextToken());
			int weight = Integer.parseInt(tk.nextToken());
			list[from].add(new Node(to,weight));
		}
		Arrays.fill(distance, Integer.MAX_VALUE);

		distance[startNode] = 0;
		PriorityQueue<Node> queue = new PriorityQueue<>();
		queue.add(new Node(startNode,0));//시작 정점 초기화
		while(!queue.isEmpty()) {
			Node node = queue.poll();
			int from = node.to;
			if (visited[from]) continue;
		
			visited[from] = true;
			for(Node next : list[from]) {
				if(distance[next.to] >distance[from]+next.weight) {
					distance[next.to] = distance[from]+next.weight;
					queue.add(new Node(next.to,distance[next.to]));
				}
			}
		}
		for (int i = 1; i < distance.length; i++) {
			if (distance[i] == Integer.MAX_VALUE) {
				sb.append("INF").append("\n");
				continue;
			}
			sb.append(distance[i] + "\n");
		}
		System.out.println(sb);
	}
}
