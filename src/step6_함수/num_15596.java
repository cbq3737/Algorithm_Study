package step6_함수;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class num_15596 {
	public static long sum(int[] a) {
		long ans = 0;
		for(int i =0;i<a.length;i++) {
			ans += a[i];
		}
		return ans;
	}
	public static void  main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		long hap = sum(arr);
	}
}
