package step24_dfs_bfs;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class num_2458 {
	public static int upcnt;
	public static int downcnt;
	public static int nNum;
	public static int[][] grid;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk = new StringTokenizer(br.readLine());
		nNum = Integer.parseInt(tk.nextToken());//노드
		int mNum = Integer.parseInt(tk.nextToken());//간선 횟수
		grid= new int[nNum+1][nNum+1];
		for(int i=1;i<=mNum;i++) {
			tk= new StringTokenizer(br.readLine());
			int from = Integer.parseInt(tk.nextToken());
			int to = Integer.parseInt(tk.nextToken());
			grid[from][to]= 1;
		}
		int cnt=0;
		for(int i=1;i<=nNum;i++) {
			upcnt=downcnt=0;
			updfs(i,new boolean[nNum+1]);//큰 학생
			downdfs(i,new boolean[nNum+1]);//작은 학생
			if(upcnt+downcnt==nNum-1) {
				cnt++;
			}
		}
		System.out.println(cnt);
	}
	public static void updfs(int idx,boolean[] visited) {
		//기저 조건
		visited[idx] = true;
		for(int i=1;i<=nNum;i++) {
			if(!visited[i]&&grid[idx][i]==1) {
				upcnt++;
				updfs(i,visited);
			}
		}
	}
	public static void downdfs(int idx,boolean[] visited) {
		visited[idx] = true;
		for(int i=1;i<=nNum;i++) {
			if(!visited[i]&&grid[i][idx]==1) {
				downcnt++;
				downdfs(i,visited);
			}
		}
	}
}
