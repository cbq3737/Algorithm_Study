package step14_백트래킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class num_14889_1 {
	private static int[][] arr;
	private static int N;
	private static int min;
	private static int[] link;
	private static int[] start;
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk;
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		for (int i = 0; i < N; i++) {
			tk = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(tk.nextToken());
			}
		}
		
		min=Integer.MAX_VALUE;
		link = new int[N/2];
		start = new int[N/2];
		find(0,0,0,0,0);
		System.out.println(min);
	}
	private static void find(int i, int Link, int Start, int l_count, int s_count) {
		if (i==N) {
			int stat_term = Math.abs(Link-Start);
			if (min>stat_term) {
				min=stat_term;
			}
			return;
		}
		if (l_count<N/2) {
			link[l_count]=i;
			int dstat =0;
			for (int j = 0; j < l_count; j++) {
				dstat += arr[i][link[j]] + arr[link[j]][i];	
			}
			find(i+1,Link+dstat,Start,l_count+1,s_count); //여기루프를 돌고 나서 반환이되면 아래 조건문으로 들어가 재귀를 호출하게 된다.
		}
		if (s_count<N/2) {
			start[s_count]=i;
			int dstat = 0;
			for (int j = 0; j < s_count; j++) {
				dstat += arr[i][start[j]] + arr[start[j]][i];
			}
			find(i+1,Link,Start+dstat,l_count,s_count+1);
		}
	}
}
