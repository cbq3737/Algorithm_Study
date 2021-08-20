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
		if (ni >= 0 && ni < grid.length && nj >= 0 && nj < grid.length && (grid[ni][nj] == num)) {
			cnt = find_omok(deltas, ni, nj, cnt + 1, d, num);
		}
		return cnt;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		grid = new int[19][19];
							// 오른쪽 위, 오른쪽, 오른족 아래, 아래,
		int[][] deltas = {  { -1, 1 },{ 0, 1 }, { 1, 1 }, { 1, 0 } };
		int[][] deltas_del = {  { 1, -1 },{ 0, -1 }, { -1, -1 }, { -1, 0 } }; //반대방향

		StringTokenizer tk = null;
		for (int i = 0; i < grid.length; i++) {
			tk = new StringTokenizer(br.readLine());
			for (int j = 0; j < grid[i].length; j++) {
				grid[i][j] = tk.nextToken().charAt(0) - '0';
			}
		}
		boolean flag = true;
		boolean zero_flag= false;
		// 처음 이긴 좌표, 돌 색
		int win_i = 0; //우승 i 좌표
		int win_j = 0; //우승 j 좌표
		int win_color = 0; //돌의 색상
		int ni_del = 0;
		int nj_del = 0;
		int win_num=0; //이긴 돌의 색상
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				if (grid[i][j] != 0) { //색있는 돌 발견
					int cnt = 1;
					for (int d = 0; d < deltas.length; d++) {
						int ni = i + deltas[d][0]; //주위 i
						int nj = j + deltas[d][1]; //주위 j
						if (ni >= 0 && ni < grid.length && nj >= 0 && nj < grid.length && grid[ni][nj] == grid[i][j]) {
							cnt = find_omok(deltas, ni, nj, cnt + 1, d, grid[i][j]); //같은색깔 발견해서 5개까지 찾았다면
							win_color = grid[i][j];// 돌의 색
							if (cnt == 5) { //오목을 찾고, 같은색이라면(=동시 승x)
								
								if(i==0 && j==0) { //그냥 0,0
									zero_flag = true;
								}else if((j==0 && j+deltas_del[d][1] < 0) || (i==0 && i+deltas_del[d][0] < 0)) {
									ni_del = i;//벽쪽에 붙어있는 경우 검사할때 -1이라면
									nj_del = j;
									zero_flag = true;
								}else {									
									ni_del = i+deltas_del[d][0];
									nj_del = j+deltas_del[d][1];
								} 
								if(flag == true &&ni_del>=0&&nj_del>=0&&ni_del<grid.length&&nj_del<grid.length&&grid[ni_del][nj_del]!=win_color||zero_flag==true) {										
									win_i = i;
									win_j = j;
									win_num = win_color;
									flag= false;
									zero_flag = false;
									break;
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
