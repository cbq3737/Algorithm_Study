package step15_DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class num_12865_repeat {
	public static int[][] dp;
	public static int[] arr_w;
	public static int[] arr_v;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk = new StringTokenizer(br.readLine());
		int nNum = Integer.parseInt(tk.nextToken());
		int kNum = Integer.parseInt(tk.nextToken());
		dp = new int[nNum+1][kNum+1];
		arr_w = new int[nNum+1];
		arr_v = new int[nNum+1];
		for(int i=1;i<=nNum;i++) {
			tk = new StringTokenizer(br.readLine());
			arr_w[i] = Integer.parseInt(tk.nextToken());
			arr_v[i] = Integer.parseInt(tk.nextToken());
		}
		
		for(int i=1;i<=nNum;i++) {
			for(int j =1; j<=kNum;j++) {
				if(arr_w[i]>j) {
					dp[i][j] = dp[i-1][j];
				}else {
					dp[i][j]= Math.max(dp[i-1][j], dp[i-1][j-arr_w[i]]+arr_v[i]); //i-1인 이유는 하나넣었기때문에
				}
			}
		}
		System.out.println(dp[nNum][kNum]);
	}
}
