package step14_백트래킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class num_3109 {
	public static int cnt;
	public static int nNum;
	public static int mNum;
	public static boolean flag;
	public static char[][] carr;
	public static int[][] deltas = { { -1, 1 }, { 0, 1 }, { 1, 1 } }; // 오른쪽 위, 오른쪽, 오른쪽 아래

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk = new StringTokenizer(br.readLine());
		nNum = Integer.parseInt(tk.nextToken());
		mNum = Integer.parseInt(tk.nextToken());
		carr = new char[nNum][mNum];

		for (int i = 0; i < nNum; i++) {
			String str = br.readLine();
			for (int j = 0; j < mNum; j++) {
				carr[i][j] = str.charAt(j);
			}
		}
		cnt = 0;
		for (int i = 0; i < nNum; i++) { // 열을 하나하나 처리해줌.
			flag = false;
			setPipe(i, 0);
		}
		System.out.println(cnt);
	}

	public static void setPipe(int rowNum, int colNum) {
		if (colNum == mNum - 1) {//종료 조건
			cnt++;
			flag = true;// 빵집 찍음.
			return;
		}
		for (int i = 0; i < 3; i++) {// 3방향 검사
			int new_rowNum = rowNum + deltas[i][0]; // 다음으로 진행할 좌표 변경
			int new_colNum = colNum + deltas[i][1];
			if (isMove(new_rowNum, new_colNum)) { // 갈 수 있는지 검사
				setPipe(new_rowNum, new_colNum);
				if (flag) { // 빵집 찍음?
					return;
				}
			}
		}
	}
	public static boolean isMove(int rowNum, int colNum) {
		if (colNum < 0 || rowNum < 0 || rowNum >= nNum || colNum >= mNum || carr[rowNum][colNum] == 'x') {
			return false;
		}
		carr[rowNum][colNum] = 'x';// 갈 수 있다면 표시
		return true; //갈 수 있다면
	}
}
