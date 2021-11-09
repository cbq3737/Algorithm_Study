package step14_백트래킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class num_15652 {
	public static StringBuilder sb = new StringBuilder();
	public static void dfs(int[] arr,boolean[] visit,int nNum,int mNum,int count,int start) {
		if(count == mNum) {
			for(int i=0;i<mNum;i++) {
				sb.append(arr[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		for(int i=start;i<nNum;i++) {
			while(!visit[i]) {
				arr[count] = i+1;
				dfs(arr,visit,nNum,mNum,count+1,i);
				visit[i] = true; //while를 벗어나기위해
			}
			visit[i] = false; //모든 수를 돌리기 위해
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk = new StringTokenizer(br.readLine());
		int nNum = Integer.parseInt(tk.nextToken());
		int mNum = Integer.parseInt(tk.nextToken());
		int[] arr = new int[mNum];
		boolean[] visit = new boolean[nNum];
		dfs(arr,visit,nNum,mNum,0,0);
		System.out.println(sb);
	}
}
