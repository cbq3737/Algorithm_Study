
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class swea_7465 {
	public static int nNum;
	public static int[] parents;
	public static void make() {
		for(int i=1;i<=nNum;i++) {
			parents[i] = i;
		}
	}
	public static int find(int a) {
		if(a==parents[a]) return a;
		return parents[a] = find(parents[a]);
	}
	public static void union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		if(aRoot==bRoot) return ;
		
		parents[bRoot] = aRoot;
		return;
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb= new StringBuilder();
		int tcase= Integer.parseInt(br.readLine());
		for(int t=0;t<tcase;t++) {
			StringTokenizer tk = new StringTokenizer(br.readLine());
			nNum = Integer.parseInt(tk.nextToken());
			int mNum = Integer.parseInt(tk.nextToken());
			parents = new int[nNum+1];
			make();
			for(int i=0;i<mNum;i++) {
				tk = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(tk.nextToken());
				int b= Integer.parseInt(tk.nextToken());
				union(a,b);
			}
			int[] root = new int[nNum+1];
			for(int i=1;i<=nNum;i++) {
				root[find(i)]++;
			}
			int cnt =0;
			for(int i=1;i<=nNum;i++) {
				if(root[i]>0) {
					cnt++;
				}
			}
			sb.append("#"+(t+1)+" "+cnt+"\n");
		}
		System.out.println(sb);
	}
}

