package step15_DP;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class num_1149_repeat {
	public static int min = Integer.MAX_VALUE;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int nNum = Integer.parseInt(br.readLine());
		int[][] payments = new int[nNum][3]; //빨,초,파
		for(int i=0;i<nNum;i++) {
			StringTokenizer tk = new StringTokenizer(br.readLine());
			for(int j=0;j<3;j++) {
				payments[i][j]= Integer.parseInt(tk.nextToken());
			}
		}
		int[][] dp= new int[nNum+1][3];
		dp[1][0] = payments[0][0];
		dp[1][1] = payments[0][1];
		dp[1][2] = payments[0][2];


		for(int i=2;i<=nNum;i++) {
			for(int j=0;j<3;j++) {
				int num =Integer.MAX_VALUE;
				for(int k=0;k<3;k++) {					
					if(j!=k && num>dp[i-1][k]+payments[i-1][j]) {						
						num = dp[i-1][k]+payments[i-1][j];					
					}
				}
				dp[i][j] = num;
			}
		}
		int sum=Integer.MAX_VALUE;
		sum = Math.min(dp[nNum][0], Math.min(dp[nNum][1], dp[nNum][2]));
		System.out.println(sum);
		
	}
}
