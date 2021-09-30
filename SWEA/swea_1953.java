import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class swea_1953 {
	public static int nNum;// 크기
	public static int mNum;
	public static int r;// 맨홀
	public static int c;
	public static int time;// 시간
	public static int[][] map;// 맵
	public static boolean[][] new_map;
	public static Queue<int[]> queue = new LinkedList<int[]>();
	public static int[][] deltas = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };// 상하좌우

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int tcase = Integer.parseInt(br.readLine());
		for (int t = 0; t < tcase; t++) {
			StringTokenizer tk = new StringTokenizer(br.readLine());
			nNum = Integer.parseInt(tk.nextToken());
			mNum = Integer.parseInt(tk.nextToken());
			r = Integer.parseInt(tk.nextToken());
			c = Integer.parseInt(tk.nextToken());
			time = Integer.parseInt(tk.nextToken());
			map = new int[nNum][mNum];
			new_map = new boolean[nNum][mNum];
			for (int i = 0; i < nNum; i++) {
				tk = new StringTokenizer(br.readLine());
				for (int j = 0; j < mNum; j++) {
					map[i][j] = Integer.parseInt(tk.nextToken());
				}
			}
			// 큐 비우기
			queue.clear();
			queue.offer(new int[] { r, c });// 터널
			new_map[r][c] = true;// 터널
			time--;
			bfs();
			int sum = 0;
			for (int i = 0; i < nNum; i++) {
				for (int j = 0; j < mNum; j++) {
					if (new_map[i][j]) {
						sum++;
					}
				}
			}
			sb.append("#" + (t + 1) + " " + sum + "\n");
		}
		System.out.println(sb);
	}

	public static boolean isCheck(int ni, int nj) {
		if (ni >= 0 && nj >= 0 && ni < map.length && nj < map[ni].length && map[ni][nj] != 0) {
			return true;
		}
		return false;
	}

	public static boolean connect(int d, int ni, int nj) {// 연결되어있는지 체크
		if (d == 0 && (map[ni][nj] == 1 || map[ni][nj] == 2 || map[ni][nj] == 5 || map[ni][nj] == 6)) {// 상
			return true;
		}
		if (d == 1 && (map[ni][nj] == 1 || map[ni][nj] == 2 || map[ni][nj] == 4 || map[ni][nj] == 7)) {// 하
			return true;
		}
		if (d == 2 && (map[ni][nj] == 1 || map[ni][nj] == 3 || map[ni][nj] == 4 || map[ni][nj] == 5)) {// 좌
			return true;
		}
		if (d == 3 && (map[ni][nj] == 1 || map[ni][nj] == 3 || map[ni][nj] == 6 || map[ni][nj] == 7)) {// 우
			return true;
		}
		return false;
	}

	public static void bfs() {
		while (!queue.isEmpty()) {
			if (time == 0) {
				break;
			} else {
				int size = queue.size();
				for (int t = 0; t < size; t++) {
					int[] arr = queue.poll();
					int i = arr[0];
					int j = arr[1];
					switch (map[i][j]) {
					case 1:// 상하좌우
						for (int d = 0; d < 4; d++) {
							boolean flag = false;
							int ni = i + deltas[d][0];
							int nj = j + deltas[d][1];// 서로 이어져있어야댐
							if (isCheck(ni, nj)&&!new_map[ni][nj]) {// 방문하지않았고,0이아니면
								flag = connect(d, ni, nj);
								if (flag) { // 이동할 수 있다.
									new_map[ni][nj] = true;
									queue.offer(new int[] { ni, nj });
								}
							}
						}
						break;
					case 2:// 상하
						for (int d = 0; d < 2; d++) {
							boolean flag = false;
							int ni = i + deltas[d][0];
							int nj = j + deltas[d][1];
							if (isCheck(ni, nj)&&!new_map[ni][nj]) {
								flag = connect(d, ni, nj);
								if (flag) { // 이동할 수 있다.
									new_map[ni][nj] = true;
									queue.offer(new int[] { ni, nj });
								}
							}
						}
						break;
					case 3:// 좌우
						for (int d = 2; d < 4; d++) {
							boolean flag = false;
							int ni = i + deltas[d][0];
							int nj = j + deltas[d][1];
							if (isCheck(ni, nj)&&!new_map[ni][nj]) {
								flag = connect(d, ni, nj);
								if (flag) { // 이동할 수 있다.
									new_map[ni][nj] = true;
									queue.offer(new int[] { ni, nj });
								}
							}
						}
						break;
					case 4:// 상우, 0,3
						for (int d = 0; d < 4; d += 3) {
							boolean flag = false;
							int ni = i + deltas[d][0];
							int nj = j + deltas[d][1];
							if (isCheck(ni, nj)&&!new_map[ni][nj]) {
								flag = connect(d, ni, nj);
								if (flag) { // 이동할 수 있다.
									new_map[ni][nj] = true;
									queue.offer(new int[] { ni, nj });
								}
							}
						}
						break;
					case 5:// 하우 , 1,3
						for (int d = 1; d < 4; d += 2) {
							boolean flag = false;
							int ni = i + deltas[d][0];
							int nj = j + deltas[d][1];
							if (isCheck(ni, nj)&&!new_map[ni][nj]) {
								flag = connect(d, ni, nj);
								if (flag) { // 이동할 수 있다.
									new_map[ni][nj] = true;
									queue.offer(new int[] { ni, nj });
								}
							}
						}
						break;
					case 6:// 하좌 1,2
						for (int d = 1; d < 3; d++) {
							boolean flag = false;
							int ni = i + deltas[d][0];
							int nj = j + deltas[d][1];
							if (isCheck(ni, nj)&&!new_map[ni][nj]) {
								flag = connect(d, ni, nj);
								if (flag) { // 이동할 수 있다.
									new_map[ni][nj] = true;
									queue.offer(new int[] { ni, nj });
								}
							}
						}
						break;
					case 7:// 상좌 0,2
						for (int d = 0; d < 3; d += 2) {
							boolean flag = false;
							int ni = i + deltas[d][0];
							int nj = j + deltas[d][1];
							if (isCheck(ni, nj)&&!new_map[ni][nj]) {
								flag = connect(d, ni, nj);
								if (flag) { // 이동할 수 있다.
									new_map[ni][nj] = true;
									queue.offer(new int[] { ni, nj });
								}
							}
						}
						break;
					default:
						break;
					}
				}
				time--;
			}
		}
	}
}
