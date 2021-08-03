import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_1210 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int[][] deltas = { { 1, 0 }, { 0, 1 }, { 0, -1 } };
		for (int tc = 0; tc < 10; tc++) {
			int[][] grid = new int[100][100];
			int number = Integer.parseInt(br.readLine());
			for (int i = 0; i < 100; i++) {
				StringTokenizer tk = new StringTokenizer(br.readLine());
				for (int j = 0; j < 100; j++) {
					grid[i][j] = Integer.parseInt(tk.nextToken());
				}
			}
			int x = 0;
			boolean flag = true;
			for (int s = 0; s < grid[0].length; s++) {
				if (grid[0][s] == 1) {
					int i = 0;
					int j = s;
					while (i + 1 < grid.length) {
						int k = 0;
						i = i + deltas[k][0];
						j = j + deltas[k][1]; // 아래로
						//왼쪽
						if (j + 1 < grid.length && grid[i][j + 1] == 1) {
							k = 1;
							while (j + 1 < grid.length) {
								if (grid[i][j + 1] == 1) {
									i = i + deltas[k][0];
									j = j + deltas[k][1];
								}else {
									break;
								}
							}
						}
						//오른쪽
						else if (j - 1 >= 0 && grid[i][j - 1] == 1) {
							k = 2;
							while (j - 1 >= 0) {
								if (grid[i][j - 1] == 1) {
									i = i + deltas[k][0];
									j = j + deltas[k][1];
								} else {
									break;
								}
							}
						}
						if (grid[i][j] == 2) {// 출구
							x = s;
							flag = false;
							break;
						}
					}
					
				}
			}
			if (!flag) {
				sb.append("#" + number + " " + x + "\n");
			}
		}
		System.out.println(sb);
	}
}