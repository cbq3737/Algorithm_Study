package step15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class num_11399 {
	public static int[] arr;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int nNum = Integer.parseInt(br.readLine());
		arr = new int[nNum+1];
		StringTokenizer tk = new StringTokenizer(br.readLine());
		for(int i=1;i<=nNum;i++) {
			arr[i] = Integer.parseInt(tk.nextToken());
		}
		Arrays.sort(arr);
		int count =0;
		int sum = 0;
		for(int i=1;i<=nNum;i++) {
			count+=arr[i];
			sum+=count;
		}
		System.out.println(sum);
	}
}
