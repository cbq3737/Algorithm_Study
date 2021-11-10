package step15_DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class num_2579_repeat {
	public static int[] arr;
	public static int[] sum;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int nNum = Integer.parseInt(br.readLine());
		arr = new int[nNum+1];
		sum = new int[nNum+1];
		for(int i=1;i<nNum+1;i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		arr[0] =0;
		sum[0] = arr[0];
		sum[1] = arr[1];
		if(nNum>=2) {			
			sum[2] = arr[1]+arr[2];
		}
		for(int i=3;i<nNum+1;i++) {
			sum[i] = Math.max(sum[i-3]+arr[i-1], sum[i-2])+arr[i];
		}
		System.out.println(sum[nNum]);
	}
}
