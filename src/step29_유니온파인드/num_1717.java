package step29_유니온파인드;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class num_1717 {
	public static int[] parents;
	public static int find(int a) {
		if(parents[a]==a) {
			return a;
		}
		return parents[a]= find(parents[a]);
	}
	public static void union(int a, int b) {
		if(isSame(a,b)) { //같은 집합
			return;
		}else { //같은 집합 아님
			int aRoot = find(a);
			int bRoot = find(b);
			if(aRoot>bRoot) {
				parents[aRoot] = bRoot;
			}else {
				parents[bRoot]= aRoot;
			}
		}
	}
	public static boolean isSame(int a, int b) {
		int aRoot = find(a); 
		int bRoot = find(b);
		if(aRoot==bRoot) return true;
		else return false;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer tk = new StringTokenizer(br.readLine());
		int nNum = Integer.parseInt(tk.nextToken());
		int mNum = Integer.parseInt(tk.nextToken());
		parents = new int[nNum+1];
		for(int i=0;i<=nNum;i++) {
			parents[i] = i;
		}
		for(int i=0;i<mNum;i++) {
			tk = new StringTokenizer(br.readLine());
			int command = Integer.parseInt(tk.nextToken());
			int a = Integer.parseInt(tk.nextToken());
			int b = Integer.parseInt(tk.nextToken());
			if(command==0) { //합집합
				union(a,b);
			}else {//비교
				if(isSame(a,b)) {
					sb.append("YES"+"\n");
				}else {

					sb.append("NO"+"\n");
				}
			}
		}
		System.out.println(sb);
	}
}
