package step13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class num_15649 {
	public static StringBuilder sb = new StringBuilder();
	public static void dfs(int[] arr,boolean[] visit,int nNum,int mNum,int count) {
		if(count == mNum) {
			for(int i=0;i<arr.length;i++) {
				sb.append(arr[i]).append(' ');
			}
			sb.append("\n");
			return;
		}
		
		for(int i=0;i<nNum;i++) {
			if(!visit[i]) {
				visit[i] = true;
				arr[count] = i+1;
				dfs(arr,visit,nNum,mNum,count+1);
				visit[i] = false;
			}
		}
		
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk = new StringTokenizer(br.readLine());
		int nNum = Integer.parseInt(tk.nextToken());
		int mNum = Integer.parseInt(tk.nextToken());
		
		int[] arr = new int[mNum];
		boolean[] visit = new boolean[nNum];
		dfs(arr,visit,nNum,mNum,0);
		System.out.println(sb);
	}
}
