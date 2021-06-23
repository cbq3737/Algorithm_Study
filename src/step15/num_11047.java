package step15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class num_11047 {
	public static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk = new StringTokenizer(br.readLine());
		int nNum = Integer.parseInt(tk.nextToken());
		int kNum = Integer.parseInt(tk.nextToken());
		arr = new int[nNum];
		for (int i = 0; i < nNum; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		int count = 0;
		for(int i =(nNum-1) ; i>=0 ; i--) {
			if(arr[i] <= kNum) {
				count = count + (kNum / arr[i]);
				kNum = kNum % arr[i];
			}
		}
		System.out.println(count);
	}
}
