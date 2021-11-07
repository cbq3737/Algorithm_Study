package step11_브루트포스;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class num_15683 {
	public static int[][] deltas = {{0,1},{1,0},{0,-1},{-1,0}}; // 우 하 좌 상
	public static List<int[]> cctv;
	public static int nNum;
	public static int mNum;
	public static int max = Integer.MAX_VALUE;
	public static int[][] grid;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk= new StringTokenizer(br.readLine());
		nNum = Integer.parseInt(tk.nextToken());
		mNum = Integer.parseInt(tk.nextToken());
		
		grid = new int[nNum][mNum];
		cctv = new ArrayList<>();
		int cnt_max = 0;
		for(int i=0;i<nNum;i++) {
			tk = new StringTokenizer(br.readLine());
			for(int j=0;j<mNum;j++) {
				grid[i][j] = Integer.parseInt(tk.nextToken());
				if(grid[i][j]<6&&grid[i][j]>0) {
					cctv.add(new int[] {grid[i][j],i,j});
				}
				if(grid[i][j]==0) {
					cnt_max++; //맨처음 0의 갯수
				}
			}
		}
		check_square(0,new int[cctv.size()][4],0,0,cnt_max);
		System.out.println(max);
	}
	public static void check_square(int isSelect,int[][] isSelected,int idx,int cnt,int cnt_max) {
		if(isSelect == cctv.size()) {
			int[][] new_grid = new int[nNum][mNum];
			for (int i = 0; i < grid.length; i++) {
				System.arraycopy(grid[i], 0, new_grid[i], 0, grid[i].length);
			}
			cnt_max = getSquarePoint(new_grid,isSelected,cnt_max);
			if(cnt_max<max) max = cnt_max;
			return;
		}
		for(int i=0;i<4;i++) {
				isSelected[isSelect][0] = i; //각도
				isSelected[isSelect][1] =cctv.get(isSelect)[0]; //타입
				isSelected[isSelect][2] =cctv.get(isSelect)[1]; //row좌표				
				isSelected[isSelect][3] =cctv.get(isSelect)[2]; //col좌표
				check_square(isSelect+1,isSelected, idx, cnt,cnt_max);
		}
	}
	public static int getSquarePoint(int[][] new_grid,int[][] isSelected,int cnt_max) {
		for(int i=0;i<isSelected.length;i++) {
			int d = isSelected[i][0]; //각도
			int cctv_type = isSelected[i][1]; //타입
			int cctv_row = isSelected[i][2];  //row
			int cctv_col = isSelected[i][3];  //col
			int next_row = 	cctv_row ;  //초기화
			int next_col = cctv_col;  //초기
			switch(cctv_type) {
			case 1: //1번 cctv
				while(true) {
					int ni = next_row+deltas[d][0];
					int nj = next_col+deltas[d][1];
					if(ni>=0&&nj>=0&&ni<new_grid.length&&nj<new_grid[ni].length&&new_grid[ni][nj]!=6) {
						if(0<new_grid[ni][nj]&&new_grid[ni][nj]<6){ //cctv라면
							 	//넘어가라
						}else if(new_grid[ni][nj]!=-1) {
							cnt_max--;
							new_grid[ni][nj] = -1;
						}
						next_row = ni; //좌표 변경
						next_col = nj;
					}else {
						break;
					}
				}
				break;
			case 2: //2번 cctv
				while(true) { //한쪽 방향
					int ni = next_row+deltas[d][0];
					int nj = next_col+deltas[d][1];
					if(ni>=0&&nj>=0&&ni<new_grid.length&&nj<new_grid[ni].length&&new_grid[ni][nj]!=6) {
						if(0<new_grid[ni][nj]&&new_grid[ni][nj]<6){ //cctv라면
						 	//넘어가라
					}else if(new_grid[ni][nj]!=-1) {
						cnt_max--;
						new_grid[ni][nj] = -1;
					} //총개수에서 0이라면 빼줌
						next_row = ni;
						next_col = nj;
					}else {
						break;
					}
				}
				next_row = cctv_row;
				next_col = cctv_col;
				while(true) { //반대방향
					int ni = next_row-deltas[d][0];
					int nj = next_col-deltas[d][1];
					if(ni>=0&&nj>=0&&ni<new_grid.length&&nj<new_grid[ni].length&&new_grid[ni][nj]!=6) {
						if(0<new_grid[ni][nj]&&new_grid[ni][nj]<6){ //cctv라면
						 	//넘어가라
					}else if(new_grid[ni][nj]!=-1) {
						cnt_max--;
						new_grid[ni][nj] = -1;
					}
						next_row = ni;
						next_col = nj;
					}else {
						break;
					}
				}
				break;
			case 3: //3번 cctv
				
				while(true) { //한쪽 방향
					int ni = next_row+deltas[d][0];
					int nj = next_col+deltas[d][1];
					if(ni>=0&&nj>=0&&ni<new_grid.length&&nj<new_grid[ni].length&&new_grid[ni][nj]!=6) {
						if(0<new_grid[ni][nj]&&new_grid[ni][nj]<6){ //cctv라면
						 	//넘어가라
					}else if(new_grid[ni][nj]!=-1) {
						cnt_max--;
						new_grid[ni][nj] = -1;
					}
						next_row = ni;
						next_col = nj;
					}else {
						break;
					}
				}
				if(d+1==4) { //3이라면 0으로
					d=0;
				}else { //
					d= d+1;
				}
				next_row = cctv_row;
				next_col = cctv_col;
				while(true) { //직각 방향
					int ni = next_row+deltas[d][0];
					int nj = next_col+deltas[d][1];
					if(ni>=0&&nj>=0&&ni<new_grid.length&&nj<new_grid[ni].length&&new_grid[ni][nj]!=6) {
						if(0<new_grid[ni][nj]&&new_grid[ni][nj]<6){ //cctv라면
						 	//넘어가라
					}else if(new_grid[ni][nj]!=-1) {
						cnt_max--;
						new_grid[ni][nj] = -1;
					}
						next_row = ni;
						next_col = nj;
					}else {
						break;
					}
				}
				break;
			case 4://4번 cctv
				if(d+2<4) { //2,3,0,1이 없으면 됌.
					d = d+2;
				}else {
					d = d-2;
				}
				for(int j=0;j<4;j++) {
					if(j==d) {
						continue;
					}
					next_row = cctv_row;
					next_col = cctv_col;
					while(true) {
						int ni = next_row+deltas[j][0];
						int nj = next_col+deltas[j][1];
						if(ni>=0&&nj>=0&&ni<new_grid.length&&nj<new_grid[ni].length&&new_grid[ni][nj]!=6) {
							if(0<new_grid[ni][nj]&&new_grid[ni][nj]<6){ //cctv라면
							 	//넘어가라
						}else if(new_grid[ni][nj]!=-1) {
							cnt_max--;
							new_grid[ni][nj] = -1;
						}
							next_row = ni;
							next_col = nj;
						}else {
							break;
						}
					}
				}
				break;
			case 5: //5번cctv
				for(int j=0;j<4;j++) {
					next_row = cctv_row;
					next_col = cctv_col;
					while(true) {
						int ni = next_row+deltas[j][0];
						int nj = next_col+deltas[j][1];
						if(ni>=0&&nj>=0&&ni<new_grid.length&&nj<new_grid[ni].length&&new_grid[ni][nj]!=6) {
							if(0<new_grid[ni][nj]&&new_grid[ni][nj]<6){ //cctv라면
							 	//넘어가라
						}else if(new_grid[ni][nj]!=-1) {
							cnt_max--;
							new_grid[ni][nj] = -1;
						}
							next_row = ni;
							next_col = nj;
						}else {
							break;
						}
					}
				}
				break;
		}
	 }
		return cnt_max;
  }
}


