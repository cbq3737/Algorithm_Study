package step11_브루트포스;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class num_17135 {
	public static int mNum;
	public static int nNum;
	public static int dNum;
	public static int enemy_kill = -1;
	public static boolean flag;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk = new StringTokenizer(br.readLine());
		nNum = Integer.parseInt(tk.nextToken());
		mNum = Integer.parseInt(tk.nextToken());
		dNum = Integer.parseInt(tk.nextToken());
		int[][] grid = new int[nNum][mNum];
		for (int i = 0; i < nNum; i++) {
			tk = new StringTokenizer(br.readLine());
			for (int j = 0; j < mNum; j++) {
				grid[i][j] = Integer.parseInt(tk.nextToken());
			}
		}
		makeCombi(grid, 0, new int[3], 0);
		System.out.println(enemy_kill);
	}

	public static void makeCombi(int[][] grid, int isSelect, int[] select, int startIdx) {
		if (isSelect == select.length) {
		
			killEnemy(grid, select);
			return;
		}
		for (int i = startIdx; i < mNum; i++) {
			select[isSelect] = i;
			makeCombi(grid, isSelect + 1, select, i + 1);
		}
	}

	public static void killEnemy(int[][] grid, int[] select) {
		int[][] new_grid = new int[nNum][mNum]; // 궁수 배치 케이스를 모두 검사해봐야하므로 계속 맵이 바뀜
		boolean[][] new_bool = new boolean[nNum][mNum];
		for (int i = 0; i < grid.length; i++) {
			System.arraycopy(grid[i], 0, new_grid[i], 0, grid[i].length);
		}
		int maxkill = 0;
		int cnt= 0;
		flag = true;
		while (flag) {
			maxkill += kill(new_bool,new_grid, select,cnt++);
		}
		enemy_kill = Math.max(maxkill, enemy_kill);
	}

	public static int kill(boolean[][] new_bool,int[][] grid, int[] select,int cnt) {
		int kill_cnt = 0;
		for (int i = 0; i < select.length; i++) {
			int archer = select[i]; // 궁수의 c위치
			int col = mNum;
			int row = nNum;
			int distance = dNum;
			for (int r = nNum - 1; r >=cnt; r--) { // 맵 아래에서부터 
				for (int c = 0; c < mNum; c++) { // 맵 왼쪽에서 부터
					if (grid[r][c] == 1) {
						int sub = Math.abs(nNum - r) + Math.abs(archer - c);// 궁수와의 거리
						if(sub<distance){				
							distance= sub;
							row = r;
							col = c;
						}else if(sub==distance && c<=col) {//가장 가까운놈중 왼쪽
							row = r;
							col = c;
						}
					}
				}
			}
			if(col!=mNum) {
				new_bool[row][col] = true;
			}
		}
		
		for(int i=0;i<nNum;i++) {
			for(int j=0;j<mNum;j++) {
				if(new_bool[i][j]) {
					kill_cnt++;
					grid[i][j] =0;
					new_bool[i][j] = false;
				}
			}
		}
		
		for (int i = nNum-1; i>0 ; i--) { // 한칸 땡겨줌
			for (int j = 0; j < mNum; j++) {
				grid[i][j] = grid[i-1][j];//아래부터 채움
				
			}
		}
		for(int c =0;c<mNum;c++) {
			grid[0][c] =0;
		}
		int sum = 0;
		for (int i = cnt; i < nNum; i++) { // 다 비었는지 확인
			for (int j = 0; j < mNum; j++) {
				sum += grid[i][j];
			}
		}
		if (sum < 1) {//sum에 1이 없다면 
			flag = false;
		}

		return kill_cnt;
	}

}
