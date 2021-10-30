package step11;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class num_3085 {//사탕 게임
	public static int[][] deltas = {{0,1},{1,0}};//오른쪽, 아래쪽
	public static int max;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int nNum = Integer.parseInt(br.readLine());
		char[][] grid = new char[nNum][nNum];
		char[][] new_grid = new char[nNum][nNum];
		for(int i=0;i<nNum;i++) {
			String str = br.readLine();
			for(int j=0;j<nNum;j++) {
				grid[i][j] = str.charAt(j);
			}
		}
		max = Integer.MIN_VALUE;
		for(int i=0;i<nNum;i++) {
			for(int j=0;j<nNum;j++) {
				swap(grid,new_grid,i,j);//색상을 서로 바꿔줄 함수				
			}
		}
		System.out.println(max);
	}
	public static void swap(char[][] grid,char[][] new_grid,int r,int c) {	
		char color = grid[r][c]; //기존 색상
		for(int d=0;d<deltas.length;d++) {
			int new_r = r+deltas[d][0];//변경될 좌표
			int new_c = c+deltas[d][1];//변경될 좌표
			if(new_r>=0&&new_c>=0&&new_r<grid.length&&new_c<grid[new_r].length) { 
				for(int i=0;i<grid.length;i++) {
					System.arraycopy(grid[i], 0, new_grid[i], 0, grid[i].length);//새 배열 복사 
				}
				char new_color = grid[new_r][new_c];//인접한 색상
				if(new_color!=color) {//서로 다를때만 색상 변경					
					new_grid[r][c]= new_color; 
					new_grid[new_r][new_c] = color;
				}
				check_cnt(new_grid,1,1);//열 별 카운팅,행 별 카운팅 
			}
		}
	}
	//무조건 많은게 아닌, 연속된 수를 카운팅
	public static void check_cnt(char[][] new_grid,int col_cnt,int row_cnt) {
		for(int i=0;i<new_grid.length;i++) {//행,열 별로 세기
			char col_prev_color = new_grid[i][0]; //맨처음 색상
			for(int j=1;j<new_grid[i].length;j++) {
				char col_color = new_grid[i][j]; //행
				if(col_prev_color==col_color) { //행별 갯수 카운팅
					col_cnt+=1;
				}else {
					col_cnt=1;
				}
				col_prev_color = col_color;
				//max값 갱신
				max = Math.max(max, col_cnt);
			}
			//카운팅 변수 초기화
			col_cnt=1;
		}
		
		for(int j=0;j<new_grid.length;j++) {
			char row_prev_color = new_grid[0][j];
			for(int i=1;i<new_grid.length;i++) {
				char row_color = new_grid[i][j]; //열
				if(row_prev_color==row_color) {//열별 갯수 카운팅
					row_cnt+=1;
				}else {
					row_cnt =1;
				}
				row_prev_color = row_color;
				max = Math.max(max, row_cnt);
			}
			row_cnt=1;
		}
	}
}
