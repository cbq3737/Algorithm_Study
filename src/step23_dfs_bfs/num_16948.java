package step23_dfs_bfs;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class num_16948 {// 데스 나이트
	public static int[][] deltas = { { -2, -1 }, { -2, +1 }, { 0, -2 }, { 0, 2 }, { 2, -1 }, { 2, 1 } };
	public static int[][] check_grid;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int nNum = Integer.parseInt(br.readLine());
		int[][] grid = new int[nNum][nNum];
		check_grid = new int[nNum][nNum];// 이동횟수 체크 판
		StringTokenizer tk = new StringTokenizer(br.readLine());
		int r1 = 0, c1 = 0, r2 = 0, c2 = 0;

		r1 = Integer.parseInt(tk.nextToken());
		c1 = Integer.parseInt(tk.nextToken());
		r2 = Integer.parseInt(tk.nextToken());
		c2 = Integer.parseInt(tk.nextToken());

		for (int i = 0; i < nNum; i++) {
			for (int j = 0; j < nNum; j++) {
				check_grid[i][j] = Integer.MAX_VALUE;
			}
		}
		check_grid[r1][c1] = 0;// 출발점
		Queue<int[]> queue = new LinkedList();
		queue.offer(new int[] { r1, c1 });
		bfs(queue, grid);
		if (check_grid[r2][c2] == Integer.MAX_VALUE) {
			System.out.println(-1);
		} else {
			System.out.println(check_grid[r2][c2]);
		}
	}

	public static void bfs(Queue<int[]> queue, int[][] grid) {

		while (!queue.isEmpty()) {
			int[] arr = queue.poll();
			int r = arr[0];
			int c = arr[1];
			for (int d = 0; d < deltas.length; d++) {
				int new_r = r + deltas[d][0];
				int new_c = c + deltas[d][1];
				if (new_r >= 0 && new_c >= 0 && new_r < grid.length && new_c < grid[new_r].length) {
					if (check_grid[new_r][new_c] > check_grid[r][c] + 1) {// 최솟값 갱신
						check_grid[new_r][new_c] = check_grid[r][c] + 1;
						queue.offer(new int[] { new_r, new_c });
					}
				}
			}
		}
	}
}
