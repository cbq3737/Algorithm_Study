package step11_브루트포스;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class num_15686 {
	public static int result_score = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk = new StringTokenizer(br.readLine());
		int nNum = Integer.parseInt(tk.nextToken());
		int mNum = Integer.parseInt(tk.nextToken());
		int home_num = 0;
		int chicken_num = 0;
		int[][] grid = new int[nNum][nNum];
		for (int i = 0; i < nNum; i++) {
			tk = new StringTokenizer(br.readLine());
			for (int j = 0; j < nNum; j++) {
				int num = Integer.parseInt(tk.nextToken());
				grid[i][j] = num;
				if (num == 1) {
					home_num++;
				} else if (num == 2) {
					chicken_num++;
				}
			}
		}
		int[][] home = new int[home_num][2];
		int[][] chicken = new int[chicken_num][2];
		int home_idx = 0;
		int chicken_idx = 0;
		for (int i = 0; i < nNum; i++) {
			for (int j = 0; j < nNum; j++) {
				int num = grid[i][j];
				if (num == 1) {
					home[home_idx][0] = i;
					home[home_idx][1] = j;
					home_idx++;
				} else if (num == 2) {
					chicken[chicken_idx][0] = i;
					chicken[chicken_idx][1] = j;
					chicken_idx++;
				}
			}
		}
		makeCombi(0, new int[mNum], 0, home, chicken);
		System.out.println(result_score);
	}

	public static void makeCombi(int isSelect, int[] selected, int startIdx, int[][] home, int[][] chicken) {
		if (isSelect == selected.length) {
			check_distance(selected, home, chicken, 0); // 조합된 인덱스를 보냄
			return;
		}
		for (int i = startIdx; i < chicken.length; i++) {
			selected[isSelect] = i; // 인덱스 넣어주기
			makeCombi(isSelect + 1, selected, i + 1, home, chicken);
		}
	}

	public static void check_distance(int[] selected, int[][] home, int[][] chicken, int min_score) {
		for(int i=0;i<home.length;i++) {
			int min = Integer.MAX_VALUE;
			for(int idx =0;idx<selected.length;idx++) {
				int sub = Math.abs(home[i][0]-chicken[selected[idx]][0])+Math.abs(home[i][1]-chicken[selected[idx]][1]);
				min = Math.min(min, sub);
			}
			min_score+=min;
		}
		result_score = Math.min(min_score, result_score);
	}
}
