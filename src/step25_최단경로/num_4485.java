package step25_최단경로;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class num_4485 {
	public static Queue<int[]> queue = new LinkedList<int[]>();
	public static int nNum;
	public static int[][] grid;
	public static int[][] new_grid;
	public static int min;
	public static int[][] deltas = {{1,0},{-1,0},{0,1},{0,-1}};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int cnt=0;
		while((nNum= Integer.parseInt(br.readLine()))!=0) { //nNum값이 0이아닐때까지
			cnt++;
			grid = new int[nNum][nNum];
			new_grid = new int[nNum][nNum]; //거리를 저장하는 배열
			for(int i=0;i<grid.length;i++) {
				StringTokenizer tk = new StringTokenizer(br.readLine());
				for(int j=0;j<grid[i].length;j++) {
					grid[i][j] = Integer.parseInt(tk.nextToken());
					new_grid[i][j] = Integer.MAX_VALUE;
				}
			}
			min = Integer.MAX_VALUE;
			bfs();
			sb.append("Problem "+cnt+": "+min+"\n");
		}
		System.out.println(sb);
	}
	public static void bfs() { 
		queue.offer(new int[] {0,0});
		new_grid[0][0] = grid[0][0];
		while(!queue.isEmpty()) {
			int[] arr = queue.poll();
			int ni = arr[0]; 
			int nj = arr[1];
			for(int d=0;d<deltas.length;d++) {
				int new_ni = ni+deltas[d][0];
				int new_nj = nj+deltas[d][1];
				if(new_ni>=0&&new_nj>=0&&new_ni<grid.length&&new_nj<grid[new_ni].length&&new_grid[new_ni][new_nj]>new_grid[ni][nj]+grid[new_ni][new_nj]) {
					new_grid[new_ni][new_nj] = new_grid[ni][nj]+grid[new_ni][new_nj];
					queue.offer(new int[] {new_ni,new_nj});
				}
			}
		}
		min = new_grid[nNum-1][nNum-1];
	}
}
