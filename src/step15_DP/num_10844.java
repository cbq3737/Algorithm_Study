package step15_DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class num_10844 {
	public static long mod = 1000000000;
	public static long[][] dp;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		int nNum = Integer.parseInt(br.readLine());
		dp = new long[nNum+1][10];
		for(int i=1;i<10;i++) { //첫번째 자릿수
			dp[1][i] = 1;//첫번째 자릿수 한번씩 올 수 있다.
		}	
		for(int i=2;i<nNum+1;i++) {
			for(int j=0;j<10;j++) {				
				if(j ==0) {
					dp[i][0] = dp[i-1][1] % mod;
				}
				else if(j == 9) {
					dp[i][9] = dp[i-1][8] % mod;
				}
				else {
					dp[i][j] = (dp[i-1][j-1]+dp[i-1][j+1]) % mod;
				}
			}
		}
		long result =0;
		for(int i=0;i<10;i++) {
			result += dp[nNum][i];
		}
		System.out.println(result&mod);
	}
}
