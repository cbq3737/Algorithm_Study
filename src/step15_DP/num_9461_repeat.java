package step15_DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class num_9461_repeat {
	public static long[] arr = new long[1000001];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tcase = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<tcase;i++) {
			int nNum = Integer.parseInt(br.readLine());
			
			arr[0] = 0;
			arr[1] = 1;
			arr[2] = 1;
			arr[3] = 1;
			for(int j=3;j<=nNum;j++) {
				arr[j] = arr[j-2]+arr[j-3];
			}
			sb.append(arr[nNum]+"\n");
		}
		System.out.println(sb);
	}
}
