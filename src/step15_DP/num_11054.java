package step14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class num_11054 {
	public static int[] arr;
	public static int[] dp_r;
	public static int[] dp_l;
	public static int[] dp_sum;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int nNum = Integer.parseInt(br.readLine());
		arr = new int[nNum];
		dp_r = new int[nNum];
		dp_l = new int[nNum];
		dp_sum = new int[nNum];
		StringTokenizer tk = new StringTokenizer(br.readLine());
		for(int i=0;i<nNum;i++) {
			arr[i] = Integer.parseInt(tk.nextToken());
		}
		
		dpright(nNum);
		dpleft(nNum);
		
		int max = 0;
		for(int i=0;i<nNum;i++) {
			dp_sum[i] = dp_r[i]+dp_l[i]-1;
			if(dp_sum[i]>max) {
				max= dp_sum[i];
			}
		}
		System.out.println(max);
	}
	public static void dpright(int num) {
		for(int i=0;i<num;i++) {
			dp_r[i] = 1;
			for(int j=0;j<i;j++) {
				if(arr[i]> arr[j] && dp_r[i]<dp_r[j]+1) {
					dp_r[i] = dp_r[i]+1;
				}
			}
		}
	}
	public static void dpleft(int num) {
		for(int i=num-1;i>=0;i--) {
			dp_l[i] = 1;
			for(int j=num-1;j>=i;j--) {
				if(arr[i] >arr[j] && dp_l[i] < dp_l[j]+1) {
					dp_l[i] = dp_l[i]+1;
				}
			}
		}
	}
}
