package step24_dfs_bfs;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class num_2206 {
	public static int[][] deltas = {{1,0},{-1,0},{0,1},{0,-1}};
	public static int nNum;
	public static int mNum;
	static class Point{
		int i,j;
		public Point(int i,int j) {
			this.i = i;
			this.j = j;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		nNum = Integer.parseInt(tk.nextToken());
		mNum = Integer.parseInt(tk.nextToken());
		int[][] grid = new int[nNum][mNum];
		int[][] new_grid = new int[nNum][mNum];
		for(int i=0;i<nNum;i++) {
			String str = br.readLine();
			for(int j=0;j<mNum;j++) {
				grid[i][j] = str.charAt(j)-'0';
				new_grid[i][j] = Integer.MAX_VALUE;
			}
		}
		new_grid[0][0] = 1;
		Queue<Point> queue = new LinkedList<>();
		queue.offer(new Point(0,0));
		int result = bfs(grid,new_grid,queue);
		sb.append(result);
		System.out.println(result);
	}
	public static int bfs(int[][] grid, int[][] new_grid,Queue<Point> queue) {
		boolean[][] pass = new boolean[nNum][mNum];//해당 장소 벽 파괴 여부 판단
		while(!queue.isEmpty()) {
			Point p = queue.poll();
			int ni = p.i;
			int nj = p.j;
			if(ni==nNum-1&&nj==mNum-1) { //없으면 값 덮어씌워짐.
				break;
			}
			for(int d=0;d<4;d++) {
				int new_ni = ni+deltas[d][0];
				int new_nj = nj+deltas[d][1];
				if(new_ni>=0&&new_nj>=0&&new_ni<grid.length&&new_nj<grid[new_ni].length) {
					if(grid[new_ni][new_nj]==0) {//바로 진행
						if(new_grid[new_ni][new_nj]>new_grid[ni][nj]+1) {
							new_grid[new_ni][new_nj] = new_grid[ni][nj]+1;
							pass[new_ni][new_nj] = pass[ni][nj];//해당 장소 파괴 여부 양도
							queue.offer(new Point(new_ni,new_nj));//기존 정보 그대로
						}else if(pass[new_ni][new_nj]&&!pass[ni][nj]) {//파괴 한번도 안된곳에서 된 적 있는 곳으로 갈 때
							new_grid[new_ni][new_nj] = new_grid[ni][nj]+1;
							pass[new_ni][new_nj] = pass[ni][nj]; //해당 장소 파괴 여부 양도
							queue.offer(new Point(new_ni,new_nj));
						}//최솟값이지만 파괴 전적이 있는 구역보다 값이 더 크더라도 아직 전적 없는 곳이 더 우선순위가 높다.
					}else if(grid[new_ni][new_nj]==1&&!pass[ni][nj]) {//벽이냐,벽을 파괴한 적있냐 없냐
						if(new_grid[new_ni][new_nj]>new_grid[ni][nj]+1) {
							new_grid[new_ni][new_nj] = new_grid[ni][nj]+1;
							pass[new_ni][new_nj] = true;//이제부터 벽 파괴한 전적이 있는 공간
							queue.offer(new Point(new_ni,new_nj));
						}
					}
				}
			}
			for(int[] row:new_grid) {				
				System.out.println(Arrays.toString(row));
			}
			System.out.println("--------------------------------");			
		}
		if(new_grid[nNum-1][mNum-1]!=Integer.MAX_VALUE) {
			return new_grid[nNum-1][mNum-1]; 
		}
		return -1;
	}
}

//8 8
//01000100
//01010100
//01010100
//01010100
//01010100
//01010100
//01010100
//00010100
