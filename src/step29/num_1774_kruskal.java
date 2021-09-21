package step29;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

//Kruskal_ver
public class num_1774_kruskal {
	public static int[] parents;
	public static Node[] node;
	public static ArrayList<Node> nodelist;
	public static class Node implements Comparable<Node>{
		int s;
		int v;
		double len;
		public Node(int s,int v,double len) {
			this.s= s;
			this.v = v;
			this.len= len;
		}
		@Override
		public int compareTo(Node o) {
			return Double.compare(this.len, o.len);
		}
	}
	public static int find(int a) {
		if(parents[a]==a) {
			return a;
		}
		return parents[a]=find(parents[a]);
	}
	public static void union(int a,int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		if(aRoot!=bRoot) {			
			parents[bRoot] =aRoot;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk = new StringTokenizer(br.readLine());
		int nNum = Integer.parseInt(tk.nextToken());
		int mNum = Integer.parseInt(tk.nextToken());
		parents = new int[nNum+1];
		node = new Node[nNum+1];
		nodelist = new ArrayList<Node>();
		for(int i=1;i<=nNum;i++) {
			parents[i] = i;
		}
		for(int i=1;i<=nNum;i++) {//노드받기
			tk = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(tk.nextToken());
			int v = Integer.parseInt(tk.nextToken());
			node[i] = new Node(s,v,0);
		}
		for(int i=1;i<=mNum;i++) {
			tk = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(tk.nextToken());
			int y = Integer.parseInt(tk.nextToken());
			union(x,y); //이미 이어져있는애 이어주기
		}
		for(int i=1;i<=nNum;i++) { //노드 리스트 초기화
			Node node1 = node[i]; //출발 노드
			for(int j=i+1;j<=nNum;j++) {
				Node node2 = node[j];///목적 노드
				double weight = Math.sqrt(Math.pow(node1.s-node2.s, 2)+Math.pow(node1.v-node2.v,2));
				nodelist.add(new Node(i,j,weight));
			}
		}
		
		Collections.sort(nodelist);
		double result = 0;
		for(int i=0;i<nodelist.size();i++) {
			Node node = nodelist.get(i);
			if(find(node.s)!=find(node.v)) { //서로 동일한 집합내에 있지 않으면, 즉 서로 연결되어있지 않으면
				result+=node.len;
				union(node.s,node.v);
			}
		}
		System.out.printf("%.2f",result);
	}
}
