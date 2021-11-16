package step17_정수_조합론;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class num_1037 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int nNum = Integer.parseInt(br.readLine());
		int[] arr = new int[nNum];
		StringTokenizer tk = new StringTokenizer(br.readLine());
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		for(int i=0;i<nNum;i++) {
			arr[i]= Integer.parseInt(tk.nextToken());
			min = Math.min(min, arr[i]);
			max = Math.max(max, arr[i]);
		}
		
//		Arrays.sort(arr);		
//		N = arr[0] * arr[nNum-1];
		int N = min*max;
		System.out.println(N);
	}
}
