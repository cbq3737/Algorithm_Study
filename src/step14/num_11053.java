package step14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class num_11053 {
	public static int[] arr;
	public static int[] dp;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int nNum = Integer.parseInt(br.readLine());
		arr= new int[1001];
		dp = new int[1001];
		StringTokenizer tk = new StringTokenizer(br.readLine());
		for(int i=0;i<nNum;i++) {
			arr[i] = Integer.parseInt(tk.nextToken());
		}		
		for(int i=0;i<nNum;i++) {
			dp[i] = 1;
			for(int j = 0;j<i;j++) {
				if(arr[i]>arr[j] && dp[i] < dp[j]+1) {
					dp[i] = dp[j]+1;
				}
			}
		}
		int max = -1;
		for(int i=0;i<nNum;i++) {
			if(max<dp[i]) {
				max = dp[i];
			}
		}
		System.out.println(max);
	}
}
