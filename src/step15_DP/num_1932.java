package step15_DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class num_1932 {
	public static int[][] arr;
	public static Integer[][] sum;
	public static int nNum;

	public static int sum_score(int depth, int index) {
		if (depth == nNum - 1) {
			return sum[depth][index];
		}
		if (sum[depth][index] == null) {
			return sum[depth][index] = Math.max(sum_score(depth + 1, index), sum_score(depth + 1, index + 1))
					+ arr[depth][index];
		}
		return sum[depth][index];
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		nNum = Integer.parseInt(br.readLine());
		arr = new int[nNum][nNum];
		sum = new Integer[nNum][nNum];

		for (int i = 0; i < nNum; i++) {
			StringTokenizer tk = new StringTokenizer(br.readLine());
			for (int j = 0; j < i + 1; j++) {
				arr[i][j] = Integer.parseInt(tk.nextToken());
			}
		}

		for (int i = 0; i < nNum; i++) {
			sum[nNum - 1][i] = arr[nNum - 1][i];
		}

		System.out.println(sum_score(0, 0));
	}
}
