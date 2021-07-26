package step11;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class num_2615 {
	public static int[][] grid;

	public static int find_omok(int[][] deltas, int ni, int nj, int cnt, int d, int num) {
		ni = ni + deltas[d][0];
		nj = nj + deltas[d][1];
		if (ni >= 0 && ni < grid.length && nj >= 0 && nj < grid.length && grid[ni][nj] == num) {
			cnt = find_omok(deltas, ni, nj, cnt + 1, d, num);
		}
		return cnt;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		grid = new int[19][19];
		// 오른쪽, 오른족 위, 오른족 아래, 아래, 5개가 충족되면 스타트 지점 반대 방향
		int[][] deltas = { { 0, 1 }, { -1, 1 }, { 1, 1 }, { 1, 0 } };
		int[][] deltas_del = { { 0, -1 }, { 1, -1 }, { -1, -1 }, { -1, 0 } }; //반대방향

		StringTokenizer tk = null;
		for (int i = 0; i < grid.length; i++) {
			tk = new StringTokenizer(br.readLine());
			for (int j = 0; j < grid[i].length; j++) {
				grid[i][j] = tk.nextToken().charAt(0) - '0';
			}
		}
		boolean flag = true;
		// 처음 이긴 좌표, 돌 색
		int win_i = 19;
		int win_j = 19;
		int win_num = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				if (grid[i][j] != 0) {
					int cnt = 1;
					for (int d = 0; d < deltas.length; d++) {
						int ni = i + deltas[d][0];
						int nj = j + deltas[d][1];
						if (ni >= 0 && ni < grid.length && nj >= 0 && nj < grid.length && grid[ni][nj] == grid[i][j]) {
							cnt = find_omok(deltas, ni, nj, cnt + 1, d, grid[i][j]);
							win_num = grid[i][j];
							if ((cnt == 5) && (win_num == grid[i][j])) { //오목을 찾고, 같은색이라면(=동시 승x)
								int ni_del =0;
								int nj_del =0;//반대 방향 검사
								if(i>0 && j>0) {									
									ni_del = i + deltas_del[d][0];
									nj_del = j + deltas_del[d][1];
								}else if(j==0) {
									 ni_del = i + deltas_del[d][0];
								}else if(i==0){
									nj_del = j + deltas_del[d][1];
								}
								if (grid[ni_del][nj_del] != win_num) { //반대방향이 오목색과 다르다면
									win_num = grid[i][j];
									win_i = i;
									win_j = j;
									flag = false;
								}
							} else {
								// 초기화
								cnt = 1;
							}
						}
					}
				}
			}			
		}
		if (flag == true) { //이긴 사람이 없다면
			System.out.println(0);
		} else {
			System.out.println(win_num);
			System.out.println((win_i + 1) + " " + (win_j + 1));
		}
	}
}
