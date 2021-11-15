package step15_DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class num_9465 {//스티커
	public static int[][] sticker;
	public static int[][] dp;
	public static int max;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tcase = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int t=0;t<tcase;t++) {
			int nNum = Integer.parseInt(br.readLine());
			sticker = new int[2][nNum+1];
			dp = new int[2][nNum+1];
			for(int i=0;i<2;i++) {
				StringTokenizer tk = new StringTokenizer(br.readLine());
				for(int j=1;j<=nNum;j++) {
					sticker[i][j] = Integer.parseInt(tk.nextToken());
				}
			}
			//처음 시작 지점 정해주기
			dp[0][1] = sticker[0][1];
			dp[1][1] = sticker[1][1];
			
			
			for(int j=2;j<=nNum;j++) {
				dp[0][j] = Math.max(dp[1][j-1], dp[1][j-2])+sticker[0][j];
				dp[1][j] = Math.max(dp[0][j-1], dp[0][j-2])+sticker[1][j];
			}
			int result = Math.max(dp[0][nNum],dp[1][nNum]);
			sb.append(result+"\n");
		}
		System.out.println(sb);
	}
	
}
