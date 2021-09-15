import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class swea_3124 {
	public static int[] parents;
	public static int nNum;
	public static  class Node{
		int[] node;
		int w;
		public Node(int start,int end,int w) {
			this.node = new int[] {start,end};
			this.w =w;
		}
	}
	public static void make() {
		for(int i=1;i<=nNum;i++) {
			parents[i] = i;
		}
	}
	public static int find(int a) {
		if(a ==parents[a]) return parents[a];
		return parents[a] = find(parents[a]);
	}
	public static boolean union(int a,int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		if(aRoot==bRoot) return false;
		parents[bRoot] = aRoot;
		return true;
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tcase = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<tcase;i++) {
			StringTokenizer tk =new StringTokenizer(br.readLine());
			nNum = Integer.parseInt(tk.nextToken());
			int mNum = Integer.parseInt(tk.nextToken());
			parents = new int[nNum+1];
			List<Node> list = new ArrayList();
			make();
			long sum =0;
			for(int j=1;j<=mNum;j++) {
				tk = new StringTokenizer(br.readLine());
				int start = Integer.parseInt(tk.nextToken());
				int end = Integer.parseInt(tk.nextToken());
				int w = Integer.parseInt(tk.nextToken());
				list.add(new Node(start,end,w));
			}
			Collections.sort(list,new Comparator<Node>() { //오름차순
				@Override
				public int compare(Node o1, Node o2) {
					return o1.w-o2.w;
				}
			});
			for(int j=0;j<list.size();j++) {	
				if(union(list.get(j).node[0],list.get(j).node[1])) {//같은 부모인지 판단 - 같은 부모면 싸이클 생김
					sum+=list.get(j).w;
				}
			}
			sb.append("#"+(i+1)+" "+sum+"\n");
		}
		System.out.println(sb);
	}
}
