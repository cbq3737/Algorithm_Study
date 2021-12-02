package step25_최단경로;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class num_1261 {
	public static int[][] deltas= {{1,0},{-1,0},{0,1},{0,-1}};
	public static int[][] new_grid;
	public static boolean[][] grid;
	public static Queue<int[]> queue = new LinkedList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int mNum = Integer.parseInt(tk.nextToken());
		int nNum = Integer.parseInt(tk.nextToken());
		grid = new boolean[nNum][mNum];
		new_grid = new int[nNum][mNum];
		for(int i=0;i<nNum;i++) {
			String str = br.readLine();
			for(int j=0;j<mNum;j++) {
				if(str.charAt(j)-'0'>0) {
					grid[i][j] = true;
				}
				new_grid[i][j] = Integer.MAX_VALUE;
			}
		}
		new_grid[0][0] = 0;
		queue.offer(new int[] {0,0});
		bfs(grid);
		sb.append(new_grid[nNum-1][mNum-1]);
		System.out.println(sb);
	}
	public static void bfs(boolean[][] grid) {
		while(!queue.isEmpty()) {
			int[] arr = queue.poll();
			int ni = arr[0];
			int nj = arr[1];
			for(int d=0;d<4;d++) {
				int new_ni = ni+deltas[d][0];
				int new_nj = nj+deltas[d][1];
				if(new_ni>=0&&new_nj>=0&&new_ni<grid.length&&new_nj<grid[new_ni].length) {
					if(grid[new_ni][new_nj]&&new_grid[new_ni][new_nj]>new_grid[ni][nj]+1) {
						new_grid[new_ni][new_nj]= new_grid[ni][nj]+1;
						queue.offer(new int[] {new_ni,new_nj});
					}
					else if(!grid[new_ni][new_nj]&&new_grid[new_ni][new_nj]>new_grid[ni][nj]) {
						new_grid[new_ni][new_nj]= new_grid[ni][nj];
						queue.offer(new int[] {new_ni,new_nj});
					}
				}
			}
		}
	}
}
