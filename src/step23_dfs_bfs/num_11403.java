package step23_dfs_bfs;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class num_11403 {//경로찾기,dfs
	public static boolean[][] new_grid;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int nNum = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		boolean[][] grid = new boolean[nNum][nNum];
		new_grid = new boolean[nNum][nNum];
		for(int i=0;i<nNum;i++) {
			StringTokenizer tk  =new StringTokenizer(br.readLine());
			for(int j=0;j<nNum;j++) {
				int num = Integer.parseInt(tk.nextToken());
				if(num==1) {
					grid[i][j]= true;
				}
			}
		}
		for(int i=0;i<grid.length;i++) { 
			for(int j=0;j<grid[i].length;j++) {				
				if(grid[i][j]) { //이어져있는애로 타가야하니까
					dfs(grid,i,j,new boolean[nNum]);					
				}
			}
		}
		for(int i=0;i<grid.length;i++) {
			for(int j=0;j<grid[i].length;j++) {
				if(new_grid[i][j]) {
					sb.append(1+" ");
				}else {
					sb.append(0+" ");
				}
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
	public static void dfs(boolean[][] grid,int r,int c,boolean[] visited) {
		new_grid[r][c] = true;//깊이 들어오는것 자체가 이미 연결된 간선이라는 뜻.
		visited[c]= true;//방문했다.
		
		for(int j=0;j<grid.length;j++) {
			if(grid[c][j]&&!visited[j]) {//자기 자신 또 방문할 수 있음.
				dfs(grid,r,j,visited);
			}
		}
	}
}
