package swea_im_test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class num_10163 {
	public static int[][] grid = new int[1001][1001];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int nNum = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		int max_width =0;
		int max_height =0;
		for (int i = 0; i < nNum; i++) {
			StringTokenizer tk = new StringTokenizer(br.readLine());
			int col = Integer.parseInt(tk.nextToken());
			int row = Integer.parseInt(tk.nextToken());
			int width = Integer.parseInt(tk.nextToken());
			int height = Integer.parseInt(tk.nextToken());
			max_width = Math.max(max_width, col+width);
			max_height = Math.max(max_height, row+height);
			for (int j = row; j < row + height; j++) {
				for (int k = col; k < col + width; k++) {
					grid[j][k] = (i + 1);
				}
			}
		}
		for (int i = 0; i < nNum; i++) {
			int cnt = 0;
			for (int n = 0; n < max_height; n++) {
				for (int j = 0; j < max_width; j++) {
					if (grid[n][j] == (i + 1)) {
						cnt++;
					}
				}
			}
			sb.append(cnt + "\n");
		}
		System.out.println(sb);
	}
}
