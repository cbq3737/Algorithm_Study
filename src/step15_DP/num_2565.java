package step15_DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class num_2565 {
	public static int[][] arr;
	public static int[] dp;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int nNum =  Integer.parseInt(br.readLine());
		arr = new int[nNum][2];
		dp = new int[nNum];
		for(int i=0;i<nNum;i++) {
			StringTokenizer tk = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(tk.nextToken());
			arr[i][1] = Integer.parseInt(tk.nextToken());
		}
		Arrays.sort(arr,new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0] - o2[0];
			}
		});
		
		for(int i=0;i<dp.length;i++) {
			dp[i] = 1;
			for(int j=0;j<i;j++) {
				if(arr[i][1] > arr[j][1]) {
					dp[i] = Math.max(dp[i], dp[j]+1);
				}
			}
		}
		
		int max = 0;
		for(int i=0;i<nNum;i++) {
			max = Math.max(max, dp[i]);
		}
		System.out.println(nNum - max);
	}
}
