package step24_dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class num_2667 {//단지번호붙이기
	public static boolean[][] check;
	public static int cnt;
	public static int[][] deltas = {{1,0},{-1,0},{0,1},{0,-1}};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int nNum = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		check  = new boolean[nNum][nNum];
		for(int i=0;i<nNum;i++) {
			String str = br.readLine();
			for(int j=0;j<nNum;j++) {
				int num = str.charAt(j)-'0';
				if(num==1) {
					check[i][j] = true; 
				}
			}
		}
		ArrayList<Integer> list = new ArrayList();
		for(int i=0;i<nNum;i++) {
			for(int j=0;j<nNum;j++) {
				if(check[i][j]) {
					cnt = 1;
					bfs(i,j);
					list.add(cnt);
				}
			}
		}
		Collections.sort(list);
		sb.append(list.size()+"\n");
		for(int i=0;i<list.size();i++) {
			sb.append(list.get(i)+"\n");
		}
		System.out.println(sb);
	}
	public static void bfs(int rr, int cc) {
		Queue<int[]> queue = new LinkedList();
		queue.offer(new int[] {rr,cc});	
		check[rr][cc] = false;//방문 표시
		while(!queue.isEmpty()) {
			int[] arr = queue.poll();
			int r = arr[0];
			int c = arr[1]; 
			for(int d = 0;d<4;d++) {
				int new_r = r+deltas[d][0];
				int new_c = c+deltas[d][1];
				if(new_r>=0&&new_c>=0&&new_r<check.length&&new_c<check[new_r].length&&check[new_r][new_c]) {
					cnt++;//갯수 세기
					queue.offer(new int[] {new_r,new_c});
					check[new_r][new_c]=false;
				}
				
			}
		}
	}
}

