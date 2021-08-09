import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class swea_5215 {
	static int[] score;
	static int[] cal_score;
	static int min_score;

	private static void powerSet(int cnt, int maxScore, boolean[] flag, int sum_score, int max) {
		if (cnt == score.length) {
			if (maxScore <= max) {
				min_score = Math.max(min_score, sum_score);
				return;
			}
			return;
		}
//		flag[cnt] = true;
		powerSet(cnt + 1, maxScore + cal_score[cnt], flag, sum_score + score[cnt], max);
//		flag[cnt] = false;
		powerSet(cnt + 1, maxScore, flag, sum_score, max);

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int t = 0; t < tc; t++) {
			StringTokenizer tk = new StringTokenizer(br.readLine());
			int nNum = Integer.parseInt(tk.nextToken());
			int cal = Integer.parseInt(tk.nextToken());
			score = new int[nNum];
			cal_score = new int[nNum];
			boolean[] flag = new boolean[nNum];
			min_score = 0;
			for (int i = 0; i < nNum; i++) { // 부분집합
				tk = new StringTokenizer(br.readLine());
				score[i] = Integer.parseInt(tk.nextToken());
				cal_score[i] = Integer.parseInt(tk.nextToken());
			}
			powerSet(0, 0, flag, 0, cal);
			sb.append("#" + (t + 1) + " " + min_score + "\n");
		}
		System.out.println(sb);
	}
}
