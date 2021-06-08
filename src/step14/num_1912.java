package step14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class num_1912 {
	public static int[] arr;
	public static int[] dp;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int nNum = Integer.parseInt(br.readLine());
		arr = new int[nNum];
		dp = new int[nNum];
		StringTokenizer tk = new StringTokenizer(br.readLine());
		for(int i=0;i<nNum;i++) {
			arr[i] = Integer.parseInt(tk.nextToken());
		}
		dp[0] = arr[0];   
		int max = arr[0];
		for(int i=1;i<nNum;i++) {
			dp[i] =Math.max(dp[i-1]+arr[i], arr[i]);
			max= Math.max(dp[i], max);
		}
		System.out.println(max);
	}
}
