package swea_im_test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class num_16935 {

	public static void operate_one(int[][] grid) {
		for (int i = 0; i < (grid.length / 2); i++) {
			for (int j = 0; j < grid[0].length; j++) {
				int temp = grid[i][j]; // 임시 변수 사용
				grid[i][j] = grid[(grid.length - 1) - i][j];
				grid[(grid.length - 1) - i][j] = temp;
			}
		}
	}

	public static void operate_two(int[][] grid) {
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length / 2; j++) {
				int temp = grid[i][j]; // 임시 변수 사용
				grid[i][j] = grid[i][(grid[0].length - 1) - j];
				grid[i][(grid[0].length - 1) - j] = temp;
			}
		}
	}

	public static int[][] operate_three(int[][] grid) { // 오른쪽 90도
		int[][] new_grid = new int[grid[0].length][grid.length]; // 새로운 배열 생성
		for (int i = 0; i < grid[0].length; i++) {
			for (int j = 0; j < grid.length; j++) {
				new_grid[i][j] = grid[(grid.length - 1) - j][i];
			}
		}
		return new_grid;
	}

	public static int[][] operate_four(int[][] grid) { // 왼쪽 90도
		int[][] new_grid = new int[grid[0].length][grid.length]; // 새로운 배열 생성
		for (int i = 0; i < grid[0].length; i++) {
			for (int j = 0; j < grid.length; j++) {
				new_grid[i][j] = grid[j][(grid[0].length - 1) - i];
			}
		}
		return new_grid;
	}

	public static int[][] operate_five(int[][] grid) {
		int[][] new_grid = new int[grid.length][grid[0].length];
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (i >= (grid.length / 2)) {
					if (j < grid[0].length / 2) {// 1 i = 3,4,5 j = 0,1,2,3
						new_grid[i - (grid.length / 2)][j] = grid[i][j];
					} else { // 4 i= 3,4,5 j= 4,5,6,7
						new_grid[i][j - (grid[0].length / 2)] = grid[i][j];
					}
				} else {
					if (j < grid[0].length / 2) {// 2 i=0,1,2 j = 0,1,2,3
						new_grid[i][j + (grid[0].length / 2)] = grid[i][j];
					} else { // 3 i=0,1,2 j = 4,5,6,7
						new_grid[i + (grid.length / 2)][j] = grid[i][j];
					}
				}
			}
		}
		return new_grid;
	}

	public static int[][] operate_six(int[][] grid) {
		int[][] new_grid = new int[grid.length][grid[0].length];
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (i >= (grid.length / 2)) {
					if (j < grid[0].length / 2) { // 3 i= 3,4,5 j= 0,1,2,3
						new_grid[i][j + (grid[0].length / 2)] = grid[i][j];
					} else { // 2 i= 3,4,5 j= 4,5,6,7
						new_grid[i - (grid.length / 2)][j] = grid[i][j];
					}
				} else {
					if (j < grid[0].length / 2) { // 4 i =0,1,2 j= 0,1,2,3
						new_grid[i + (grid.length / 2)][j] = grid[i][j];
					} else { // 1 i = 0,1,2 j= 4,5,6,7
						new_grid[i][j - (grid[0].length / 2)] = grid[i][j];
					}
				}
			}
		}
		return new_grid;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int nNum = Integer.parseInt(tk.nextToken());
		int mNum = Integer.parseInt(tk.nextToken());
		int rNum = Integer.parseInt(tk.nextToken());
		int[][] grid = new int[nNum][mNum];
		for (int i = 0; i < nNum; i++) {
			tk = new StringTokenizer(br.readLine());
			for (int j = 0; j < mNum; j++) {
				grid[i][j] = Integer.parseInt(tk.nextToken());
			}
		}
		tk = new StringTokenizer(br.readLine());
		for (int i = 0; i < rNum; i++) {
			int command = Integer.parseInt(tk.nextToken());
			switch (command) {
			case 1:
				operate_one(grid);
				break;
			case 2:
				operate_two(grid);
				break;
			case 3:
				grid = operate_three(grid);
				break;
			case 4:
				grid = operate_four(grid);
				break;
			case 5:
				grid = operate_five(grid);
				break;
			case 6:
				grid = operate_six(grid);
				break;
			}
		}
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				sb.append(grid[i][j] + " ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
