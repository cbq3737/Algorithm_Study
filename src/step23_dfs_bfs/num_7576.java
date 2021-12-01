package step23_dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class num_7576 {
	public static int[][] deltas = {{-1,0},{0,1},{1,0},{0,-1}};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk = new StringTokenizer(br.readLine());
		int mNum = Integer.parseInt(tk.nextToken());
		int nNum = Integer.parseInt(tk.nextToken());
		int[][] grid = new int[nNum][mNum];
		boolean zero_flag = false;
		Queue<int[]> queue = new LinkedList();
		for(int i=0;i<nNum;i++) {
			tk = new StringTokenizer(br.readLine());
			for(int j=0;j<mNum;j++) {
				grid[i][j]= Integer.parseInt(tk.nextToken());
				if(grid[i][j]==0) {
					zero_flag = true;
				}else if(grid[i][j]==1) {
					queue.offer(new int[]{i,j});					
				}
			}
		}
		int cnt =0;
		if(!zero_flag) {
			System.out.println(0);
		}else {
			while(!queue.isEmpty()) {
				cnt++;			
				int size = queue.size();
				for(int i=0;i<size;i++) {
					int[] arr = queue.poll();
					int row = arr[0];
					int col = arr[1];
					for(int d =0;d<deltas.length;d++) { //4방 탐색
						int ni = row + deltas[d][0];
						int nj = col + deltas[d][1];
						if(ni>=0&&nj>=0&&ni<grid.length&&nj<grid[ni].length&&grid[ni][nj]==0) {
							grid[ni][nj]= 1;
							queue.offer(new int[] {ni,nj});
						}
					}
				}
			}
			zero_flag = false;
			for(int i=0;i<nNum;i++) {
				for(int j=0;j<mNum;j++) {
					if(grid[i][j]==0) {
						zero_flag = true;
					}
				}
			}
			if(zero_flag) {
				System.out.println(-1);
			}else {				
				System.out.println(cnt-1);
			}
		}
	}
}
