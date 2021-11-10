package step15_DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class num_23601 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk = new StringTokenizer(br.readLine());
		int nNum = Integer.parseInt(tk.nextToken()); //물품의 수
		int mNum = Integer.parseInt(tk.nextToken());// 가방의 수
		int[] weight = new int[nNum+1]; //무게 
		int[] value = new int[nNum+1]; //가치
		for(int i=1;i<=nNum;i++) {
			tk = new StringTokenizer(br.readLine());
			weight[i] = Integer.parseInt(tk.nextToken());
			value[i] = Integer.parseInt(tk.nextToken());
		}
		int[] bag = new int[mNum+1];//가방
		for(int i=1;i<=mNum;i++) {
			tk = new StringTokenizer(br.readLine());
			bag[i] = Integer.parseInt(tk.nextToken());
		}
		
		double max =0;
		int idx =0;
		
//		for(int i=1;i<=mNum;i++) { //2차원배열
//			double[][] dp = new double[nNum+1][bag[i]+1]; //가방크기만큼 테이블 생성
//			for(int r=1;r<=nNum;r++) {
//				for(int c=1;c<=bag[i];c++) {
//					if(weight[r]<=c) { //해당 물건을 가방에 담을 수 잇는지 						
//						dp[r][c] = Math.max(dp[r-1][c], (dp[r-1][c-weight[r]]+value[r])); //담을 수 있다면 효율적인 것으로 넣자.
//					}else {
//						dp[r][c] = dp[r-1][c];
//					}
//				}
//			}
//			if(max<dp[nNum][bag[i]]/bag[i]) {
//				max = dp[nNum][bag[i]]/bag[i];
//				idx = i;
//			}
//		}
		
		for(int i=1;i<=mNum;i++) { //1차원배열
			double[] dp = new double[bag[i]+1]; //가방크기만큼 테이블 생성
			for(int r=1;r<=nNum;r++) {
				for(int c=bag[i];c>=weight[r];c--) {
					if(weight[r]<=c) { //해당 물건을 가방에 담을 수 잇는지 						
						dp[c] = Math.max(dp[c], (dp[c-weight[r]]+value[r])); //담을 수 있다면 효율적인 것으로 넣자.
					}
				}
			}
			if(max<dp[bag[i]]/bag[i]) {
				max = dp[bag[i]]/bag[i];
				idx = i;
			}
		}

		System.out.println(idx);
	}
}
