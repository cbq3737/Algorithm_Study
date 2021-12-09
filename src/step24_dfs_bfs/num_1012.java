package step24_dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class num_1012 {// 유기농 배추
	public static int cnt;// 벌레 갯수
	public static int[][] grid;// 배추밭
	public static boolean[][] check;// 방문체크
	public static int[][] deltas = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int tcase = Integer.parseInt(br.readLine());
		for (int t = 0; t < tcase; t++) {
			StringTokenizer tk = new StringTokenizer(br.readLine());
			int row = Integer.parseInt(tk.nextToken());// 가로
			int col = Integer.parseInt(tk.nextToken());// 세로
			int baechu = Integer.parseInt(tk.nextToken());// 배추의 수
			grid = new int[row][col];
			check = new boolean[row][col];
			for (int i = 0; i < baechu; i++) {
				tk = new StringTokenizer(br.readLine());
				int b_row = Integer.parseInt(tk.nextToken());
				int b_col = Integer.parseInt(tk.nextToken());
				grid[b_row][b_col] = 1;
				check[b_row][b_col] = true;
			}
			cnt =0;
			for (int i = 0; i < row; i++) {
				for (int j = 0; j < col; j++) {
					if (grid[i][j] == 1 && check[i][j]) {
						dfs(i, j);
						cnt++;
					}
				}
			}
			sb.append(cnt + "\n");
		}
		System.out.println(sb);
	}

	public static void dfs(int r, int c) {
		for (int d = 0; d < 4; d++) {
			int new_r = r + deltas[d][0];
			int new_c = c + deltas[d][1];
			if (new_r >= 0 && new_c >= 0 && new_r < grid.length && new_c < grid[new_r].length && grid[new_r][new_c] == 1
					&& check[new_r][new_c]) {
				check[new_r][new_c] = false;
				dfs(new_r, new_c);
			}
		}

	}

}
