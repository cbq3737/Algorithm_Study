package step14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class num_9084 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tcase = Integer.parseInt(br.readLine());
		for(int i=0;i<tcase;i++) {
			int mNum = Integer.parseInt(br.readLine());
			int[] arr = new int[mNum+1];
			StringTokenizer tk= new StringTokenizer(br.readLine());
			for(int t=1;t<=mNum;t++) {
				arr[t] = Integer.parseInt(tk.nextToken());
			}
			int weight = Integer.parseInt(br.readLine());
			int[] dp = new int[weight+1]; //1차원 오름차순으로 올라가면 중복 DP
			dp[0] = 1;
			for(int r=1;r<=mNum;r++) {
				for(int c=arr[r];c<=weight;c++) {
					dp[c] = dp[c]+dp[c-arr[r]];
				}
			}
			System.out.println(dp[weight]);
		}
	}
}
