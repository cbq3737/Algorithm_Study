package jungol;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class jungol_1681 { //프림은 갔다가 오는것까진 포함이 아님.
	public static int nNum;
	public static boolean[] visited;
	public static int[][] grid;
	public static int min;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		nNum = Integer.parseInt(br.readLine());
		grid = new int[nNum][nNum];
		
		List<Integer> list= new ArrayList<>();
		for(int i=0;i<nNum;i++) {
			StringTokenizer tk= new StringTokenizer(br.readLine());
			for(int j=0;j<nNum;j++) {
				grid[i][j] = Integer.parseInt(tk.nextToken()); 
			}
		}
		visited = new boolean[nNum];
		min = Integer.MAX_VALUE;
		dfs(0,0,0);
		System.out.println(min);
	}
	public static void dfs(int idx,int result,int cnt) {
		if(cnt==nNum-1) {
			if(grid[idx][0]==0) { //출발지로 이동할 방법이 없다면
				return;
			}
			result+=grid[idx][0];
			if(result<min) {
				min = result;
			}
			return;
		}
		visited[idx] = true;
		for(int i=0;i<nNum;i++) {
			if(!visited[i]&&grid[idx][i]!=0) { //방문한곳과 갈수없는 곳 제외
				result += grid[idx][i];
				if(result<min) {	//dfs체크, result넘어가면 무시			
					dfs(i,result,cnt+1);
				}
				visited[i] = false;
				result -= grid[idx][i];
			}
		}
	}
}
