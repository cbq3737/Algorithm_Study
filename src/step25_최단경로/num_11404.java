package step25_최단경로;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class num_11404 {
	public static int INF =987654321;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int nNum = Integer.parseInt(br.readLine());
		int[][] arr = new int[nNum][nNum];
		int mNum = Integer.parseInt(br.readLine());
		for(int[] row:arr) {
			Arrays.fill(row, INF);
		}
		for(int i=0;i<mNum;i++) {
			StringTokenizer tk = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(tk.nextToken());
			int c = Integer.parseInt(tk.nextToken());
			int cost = Integer.parseInt(tk.nextToken());
			if(arr[r-1][c-1]!=0) {
				arr[r-1][c-1] = Math.min(arr[r-1][c-1], cost);
			}else {
				arr[r-1][c-1] = cost;
			}
		}
		for(int k=0;k<nNum;k++) {
			for(int i=0;i<nNum;i++) {
				if(k==i) {
					continue;
				}
				for(int j=0;j<nNum;j++) {
					if(k==j) {
						continue;
					}
					if(arr[i][k]+arr[k][j] <arr[i][j]) {
						arr[i][j] = arr[i][k]+arr[k][j];
					}
				}	
			}
		}
		
		for(int i=0;i<nNum;i++) {
			for(int j=0;j<nNum;j++) {
				if(i==j || arr[i][j]==INF) {
					arr[i][j]=0;
				}
				sb.append(arr[i][j]+" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);

	}
}
