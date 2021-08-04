import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_2001 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int tc = Integer.parseInt(br.readLine());
		for (int t = 0; t < tc; t++) {
			StringTokenizer tk = new StringTokenizer(br.readLine());
			int nNum = Integer.parseInt(tk.nextToken());
			int mNum = Integer.parseInt(tk.nextToken());

			int[][] grid = new int[nNum][nNum];
			for (int row = 0; row < nNum; row++) {
				tk = new StringTokenizer(br.readLine());
				for (int col = 0; col < nNum; col++) {
					grid[row][col] = Integer.parseInt(tk.nextToken());
				}
			}
			int max = Integer.MIN_VALUE;
			for (int i = 0; i < (nNum - mNum) + 1; i++) {
				for (int j = 0; j < (nNum - mNum) + 1; j++) {
					int sum = 0;
					// 파리채 범위
					for (int row = i; row < i+mNum; row++) {
						for (int col = j; col < j+mNum; col++) {
							sum += grid[row][col];
						}
					}
					if (max < sum) {
						max = Math.max(max, sum);
					}
				}
			}
			sb.append("#" + (t + 1) +" "+ max+"\n");
		}
		System.out.println(sb);
	}
}
