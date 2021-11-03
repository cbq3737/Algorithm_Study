package step8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class num_2775 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());

		for (int i = 0; i < t; i++) {
			int k = Integer.parseInt(br.readLine());
			int n = Integer.parseInt(br.readLine());
			int[] farr = new int[n];
			int sum = 0;
			for (int j = 0; j < n; j++) {
				sum += (j + 1);
				if (sum == 1) {
					farr[j] = sum;
				} else {
					farr[j] = sum;
				}
			}
			for (int j = 1; j < k; j++) {
				for (int a = 0; a < n; a++) {
					if (a < n - 1) {
						farr[a + 1] += farr[a];
					}
				}
			}
			System.out.println(farr[n-1]);
		}
	}
}
