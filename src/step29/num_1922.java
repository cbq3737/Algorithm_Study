package step29;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class num_1922 {//네트워크 연결 , 크루스칼, 최소 신장 트리
	public static int[] parent;
	static class Edge implements Comparable<Edge> {
		int from, to, weight;

		public Edge(int from, int to, int weight) {
			super();
			this.from = from;
			this.to = to;
			this.weight = weight;
		}
		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.weight, o.weight); // 양수나 음수 일수도 있기 때문에
		}
	}
	public static void makeSet(int num) {
		parent = new int[num+1];
		for(int i=1;i<=num;i++) {
			parent[i] = i; //자기 자신을 가르킨다.
		}
	}
	public static int Findset(int a) {
		if(a==parent[a]) {
			return a;
		}
		return parent[a] = Findset(parent[a]);
	}
	public static boolean Union(int a, int b) {
		int aRoot = Findset(a);
		int bRoot = Findset(b);
		if(aRoot==bRoot) {
			return false;
		}
		parent[aRoot] = bRoot;
		return true;
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int nNum = Integer.parseInt(br.readLine());//컴퓨터 수 
		int mNum = Integer.parseInt(br.readLine());//선 수
		makeSet(nNum);
		Edge[] edgelist = new Edge[mNum];
		for(int i=0;i<mNum;i++) {
			StringTokenizer tk = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(tk.nextToken());
			int b = Integer.parseInt(tk.nextToken());
			int cnt = Integer.parseInt(tk.nextToken());
			edgelist[i] = new Edge(a,b,cnt);
		}
		Arrays.sort(edgelist);//오름차순 정렬
		int cnt = 0;
		int sum =0;
		for(Edge edge:edgelist) {
			if(Union(edge.from,edge.to)) {
				sum+=edge.weight;
			}			
		}
		System.out.println(sum);
	}
}
