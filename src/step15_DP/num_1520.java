package step15_DP;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class num_1520 {//내리막길
	public static int[][] map;
	public static int[][] deltas = {{1,0},{-1,0},{0,1},{0,-1}};
	public static int mNum;
	public static int nNum;
	public static int[][] new_map;//DP용
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk = new StringTokenizer(br.readLine());
		mNum = Integer.parseInt(tk.nextToken());//세로
		nNum = Integer.parseInt(tk.nextToken());//가로
		map = new int[mNum][nNum];
		new_map = new int[mNum][nNum];
		boolean[][] visited = new boolean[mNum][nNum];
		for(int i=0;i<mNum;i++) {
			tk = new StringTokenizer(br.readLine());
			for(int j=0;j<nNum;j++) {
				map[i][j] = Integer.parseInt(tk.nextToken());
			}
		}
		new_map[mNum-1][nNum-1] = 1;//목적지
		dfs(0,0,visited);//시작 좌표

		System.out.println(new_map[0][0]);
	} 
	//DP는 빠꾸를 치면서 더해준다.DP배열은 그 목적지로 갈 수잇는 경로의 수가 아닌, 경우의 수
	public static void dfs(int r,int c,boolean[][] visited) {
		if(r==mNum-1&&c==nNum-1||visited[r][c]) {//목적지 도착
			return;
		}	
		visited[r][c] = true;//방문체크
		for(int d=0;d<4;d++) {
			int new_r = r+deltas[d][0];
			int new_c = c+deltas[d][1];
			if(new_r>=0&&new_c>=0&&new_r<map.length&&new_c<map[new_r].length) {//범위
				if(map[r][c]>map[new_r][new_c]) {//더 작은 낮은 지점으로 갈 수 있다면
					if(new_map[new_r][new_c]==0) {			
						dfs(new_r,new_c,visited);
						new_map[r][c]+=new_map[new_r][new_c];
					}else {
						new_map[r][c]+=new_map[new_r][new_c];//목적지까지 갈 수 있는데 이미 있는 경우의수가 있을때					
					}

				}
			}
		}
	}
}
