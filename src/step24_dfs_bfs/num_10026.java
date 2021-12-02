package step23_dfs_bfs;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class num_10026 {
	public static int[][] deltas = { { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 } };
	public static int cnt = 0;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int nNum = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		char[][] carr = new char[nNum][nNum];
		char[][] color_carr = new char[nNum][nNum];
		boolean[][] visited = new boolean[nNum][nNum];
		for (int i = 0; i < nNum; i++) {
			String str = br.readLine();
			for (int j = 0; j < nNum; j++) {
				carr[i][j] = str.charAt(j);
				if (carr[i][j] == 'G') {
					color_carr[i][j] = 'R';
				} else {
					color_carr[i][j] = carr[i][j];
				}
			}
		}	
		for (int i = 0; i < nNum; i++) { // 색 잘보는 친구
			for (int j = 0; j < nNum; j++) {
				if (!visited[i][j]) { // 색깔 바꿔주기
					visited[i][j] = true;
					bfs(carr, visited, nNum, i, j);
					cnt++;
				} else {
					continue;
				}
			}
		}
		sb.append(cnt + " ");
		visited = new boolean[nNum][nNum];
		cnt = 0;
		for (int i = 0; i < nNum; i++) { // 색약
			for (int j = 0; j < nNum; j++) {
				if (!visited[i][j]) { // 색깔 바꿔주기
					visited[i][j] = true;
					bfs(color_carr, visited, nNum, i, j);
					cnt++;
				} else {
					continue;
				}
			}
		}
		sb.append(cnt);
		System.out.println(sb);
	}
	public static void bfs(char[][] carr, boolean[][] visited, int nNum, int row, int col) {
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] { row, col });
		while (!queue.isEmpty()) {
			int[] arr = queue.poll();
			for (int j = 0; j < nNum; j++) {
				for (int d = 0; d < 4; d++) {
					int ni = arr[0]+deltas[d][0];
					int nj = arr[1]+deltas[d][1];
					if (ni>=0&&nj>=0&&ni<nNum&&nj<nNum&&!visited[ni][nj] && carr[ni][nj] == carr[arr[0]][arr[1]]) {
						visited[ni][nj] = true;
						queue.offer(new int[] { ni, nj });
					}
				}
			}
		}
	}
}
