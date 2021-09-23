package swea_test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class num_11659 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk= new StringTokenizer(br.readLine());
		int nNum = Integer.parseInt(tk.nextToken());
		int mNum = Integer.parseInt(tk.nextToken());
		int[] arr = new int[nNum+1];
		StringBuilder sb = new StringBuilder();
		tk = new StringTokenizer(br.readLine());
		arr[0] =0;
		for(int i=1;i<=nNum;i++) {
			arr[i]= arr[i-1]+Integer.parseInt(tk.nextToken());
		}
		for(int i=0;i<mNum;i++) {
			tk = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(tk.nextToken());
			int end = Integer.parseInt(tk.nextToken());
			sb.append(arr[end]-arr[start-1]+"\n");
		}
		System.out.println(sb);
	}
}
