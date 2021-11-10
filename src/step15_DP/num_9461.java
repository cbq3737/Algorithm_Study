package step15_DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class num_9461 {
	public static long[] arr = new long[101];
	public static long Fibo(int N) {
		if(arr[N]== -1) {
			return arr[N] = Fibo(N-2)+Fibo(N-3);
		}
		return arr[N];
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb= new StringBuilder();
		for(int i=0;i<101;i++) {
			arr[i] = -1;
		}
		arr[0] = 0;
		arr[1] = 1;
		arr[2] = 1;
		arr[3] = 1;
		
		for(int i=0;i<T;i++) {
			int N = Integer.parseInt(br.readLine());
			sb.append(Fibo(N)).append("\n");
		}
		System.out.println(sb);
	}
}
