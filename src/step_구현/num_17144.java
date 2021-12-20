package step_구현;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class num_17144 {
	public static int[][] grid;
	public static Queue<int[]> queue;
	public static int[][] deltas = {{-1,0},{1,0},{0,1},{0,-1}};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk = new StringTokenizer(br.readLine());
		int r = Integer.parseInt(tk.nextToken());
		int c = Integer.parseInt(tk.nextToken());
		int t = Integer.parseInt(tk.nextToken());
		grid = new int[r][c];
		queue = new LinkedList<>();
		List<int[]> air= new ArrayList<>();
		for(int i=0;i<r;i++) {
			tk= new StringTokenizer(br.readLine());
			for(int j=0;j<c;j++) {
				grid[i][j] = Integer.parseInt(tk.nextToken());
				if(grid[i][j]!=0&&grid[i][j]!=-1) {
					queue.add(new int[] {i,j});
				}else if(grid[i][j]==-1) {
					air.add(new int[] {i,j});
				}
			}
		}
		for(int i=0;i<t;i++) {			
			dust(r,c,t);//미세먼지 전파
			operate_air(air,r,c);//공기청정기 작동
		}
		int sum=0;
		for(int i=0;i<r;i++) {
			for(int j=0;j<c;j++) {
				if(grid[i][j]!=0 &&grid[i][j]!=-1) {
					sum+=grid[i][j];
				}
			}
		}
		System.out.println(sum);
	}
	public static void operate_air(List<int[]> air,int r, int c) {
		for(int i=0;i<air.size();i++) {
			int[] arr = air.get(i);
			int ni = arr[0];
			if(i==0) {//위쪽
				  // 아래로 당기기
		        for (int j = ni - 1; j > 0; j--) 
		            grid[j][0] = grid[j-1][0];
		        // 왼쪽으로 당기기
		        for (int j = 0; j < c - 1; j++) 
		            grid[0][j] = grid[0][j+1];
		        // 위로 당기기
		        for (int j = 0; j < ni; j++) 
		            grid[j][c - 1] = grid[j + 1][c - 1];
		        // 오른쪽으로 당기기
		        for (int j = c - 1; j > 1; j--) 
		            grid[ni][j] = grid[ni][j-1];
		        grid[ni][1] = 0;
			}else {//아래쪽
					for (int j = ni + 1; j < r - 1; j++) 
			            grid[j][0] = grid[j + 1][0];
			        // 왼쪽으로 당기기
			        for (int j = 0; j < c - 1; j++) 
			            grid[r - 1][j] = grid[r - 1][j + 1]; 
			        // 아래로 당기기
			        for (int j = r - 1; j > ni; j--) 
			            grid[j][c - 1] = grid[j - 1][c - 1];
			        // 오른쪽으로 당기기
			        for (int j = c - 1; j > 1; j--) 
			            grid[ni][j] = grid[ni][j - 1];
			        // 공기청정기에서 부는 바람은 미세먼지가 없는 바람
			        grid[ni][1] = 0;
			}
		}
	}
	public static void dust(int r,int c,int t) { 
		int[][] new_grid = new int[r][c];
		while(!queue.isEmpty()) {
			int[] arr = queue.poll();
			int ni = arr[0];
			int nj = arr[1];
			int cnt =0;
			for(int d=0;d<deltas.length;d++) {
				int new_ni = ni+deltas[d][0];
				int new_nj = nj+deltas[d][1];
				if(new_ni>=0&&new_nj>=0&&new_ni<grid.length&&new_nj<grid[new_ni].length&&grid[new_ni][new_nj]!=-1) {
					//미세먼지 전파 가능
					cnt++; //미세먼지 전파 횟수
					new_grid[new_ni][new_nj] += grid[ni][nj]/5; //전파
				}
			}
			grid[ni][nj] = grid[ni][nj] - ((grid[ni][nj]/5) * cnt); //남는 미세먼지 양
		}
		for(int i=0;i<r;i++) { //합쳐주기
			for(int j=0;j<c;j++) {
				if(grid[i][j]!=-1) {
					grid[i][j] = grid[i][j]+new_grid[i][j];
					queue.add(new int[] {i,j}); //큐에 담아주기
				}
			}
		}
	}
}
