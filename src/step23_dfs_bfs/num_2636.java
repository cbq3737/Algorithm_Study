package step23_dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class num_2636 {
	public static int last_size;
	public static int nNum;
	public static int mNum;
	public static int[][] deltas = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

//	public static int[][] grid;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk = new StringTokenizer(br.readLine());
		nNum = Integer.parseInt(tk.nextToken());
		mNum = Integer.parseInt(tk.nextToken());
		int[][] grid = new int[nNum][mNum];
		Queue<int[]> queue = new LinkedList();
		for (int i = 0; i < nNum; i++) {
			tk = new StringTokenizer(br.readLine());
			for (int j = 0; j < mNum; j++) {
				grid[i][j] = Integer.parseInt(tk.nextToken());
			}
		}
		int cnt = 0;
		int size = 0;
		while (checkCheese(grid)) {
			queue.add(new int[] { 0, 0 });
			queue.add(new int[] { nNum - 1, 0 });
			queue.add(new int[] { 0, mNum - 1 });
			queue.add(new int[] { nNum - 1, mNum - 1 });
			cnt++;
			size = last_size;
			bfs(grid, queue);
		}
		System.out.println(cnt);
		System.out.println(size);
	}
	public static boolean checkCheese(int[][] grid) {
		boolean flag = false;
		int size = 0;
		for (int i = 0; i < nNum; i++) {
			for (int j = 0; j < mNum; j++) {
				if (grid[i][j] == -1 || grid[i][j] == 2) {
					grid[i][j] = 0;
				} else if (grid[i][j] == 1) {
					size++;
					flag = true;
				}
			}
		}
		last_size = size;
		return flag;
	}
	public static void bfs(int[][] grid, Queue<int[]> queue) {
		while (!queue.isEmpty()) {
			int[] arr = queue.poll();
			int nr = arr[0];
			int nc = arr[1];
			for (int d = 0; d < 4; d++) {
				int ni = nr + deltas[d][0];
				int nj = nc + deltas[d][1];
				if (ni >= 0 && nj >= 0 && ni < grid.length && nj < grid[ni].length) {
					if (grid[ni][nj] == 0) {
						grid[ni][nj] = -1;
						queue.offer(new int[] { ni, nj });
					} else if (grid[ni][nj] == 1) {
						grid[ni][nj] = 2;
					}
				}
			}
		}
	}
}
