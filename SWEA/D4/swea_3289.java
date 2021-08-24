import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_3289 {
	public static int[] parents;
	public static int nNum;
	public static void make() {
		for(int i=1;i<=nNum;i++) {
			parents[i] = i;
		}
	}
	private static int find(int a) {
		if(a==parents[a]) return a;
		return parents[a] = find(parents[a]);
	}
	private static boolean union(int a, int b) {
		int aRoot= find(a);
		int bRoot = find(b);
		if(aRoot == bRoot)return false; //이미 둘이 같다 == 소속이 같아서 합쳐지지 않음
			
		parents[bRoot] = aRoot;
		return true;
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tcase = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int t=0;t<tcase;t++) {
			StringTokenizer tk = new StringTokenizer(br.readLine());
			nNum = Integer.parseInt(tk.nextToken());
			int mNum = Integer.parseInt(tk.nextToken());
			parents = new int[nNum+1];
			make();
			sb.append("#"+(t+1)+" ");
			for(int i=0;i<mNum;i++) {
				tk = new StringTokenizer(br.readLine());
				int command = Integer.parseInt(tk.nextToken());
				int a = Integer.parseInt(tk.nextToken());
				int b = Integer.parseInt(tk.nextToken());
				if(command==0) {
					union(a,b); 	
				}else {
					int aRoot = find(a);
					int bRoot = find(b);
					sb.append(aRoot==bRoot? 1:0);
				}
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
