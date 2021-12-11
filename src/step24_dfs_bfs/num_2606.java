package step24_dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class num_2606 {//바이러스
	public static int cnt;
	public static boolean[] visited;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int nNum = Integer.parseInt(br.readLine());//컴퓨터 수
		int pair =Integer.parseInt(br.readLine());//쌍
		visited = new boolean[nNum+1];//방문체크
		
		ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
		for(int i=0;i<=nNum;i++) {
			list.add(new ArrayList<Integer>());
		}
		for(int i=0;i<pair;i++){
			StringTokenizer tk = new StringTokenizer(br.readLine());
			int from  = Integer.parseInt(tk.nextToken());
			int to = Integer.parseInt(tk.nextToken());
			list.get(from).add(to);
			list.get(to).add(from);
		}
		cnt = 0;
		dfs(1,list);
		System.out.println(cnt-1);//1번 컴퓨터는 빼기
	}
	public static void dfs(int node,ArrayList<ArrayList<Integer>> list) {
		if(visited[node]) {
			return;
		}
		
		visited[node]= true;//방문했다.
		cnt++;
		int size = list.get(node).size();
		for(int i=0;i<size;i++) {
			int to_node = list.get(node).get(i);
			if(!visited[to_node]) {//아직 방문하지 않았다면
				dfs(to_node,list);
			}
			
		}
	}
}
