package step23_dfs_bfs;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class num_14502 {
	public static int nNum;
	public static int mNum;
	public static List<int[]> blank_list;
	public static int[][] deltas = {{-1,0},{1,0},{0,1},{0,-1}};
	public static int max;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk =new StringTokenizer(br.readLine());
		nNum = Integer.parseInt(tk.nextToken());
		mNum = Integer.parseInt(tk.nextToken());
		int[][] grid = new int[nNum][mNum];
		blank_list = new ArrayList();//벽 세울 빈공간 리스트
		List<int[]> virus_list = new ArrayList(); //바이러스
		for(int i=0;i<nNum;i++) {
			tk = new StringTokenizer(br.readLine());
			for(int j=0;j<mNum;j++) {
				grid[i][j] = Integer.parseInt(tk.nextToken());
				if(grid[i][j]==2) {
					virus_list.add(new int[] {i,j});
				}else if(grid[i][j]==0) {
					blank_list.add(new int[] {i,j});
				}
			}
		}
		max = Integer.MIN_VALUE;
		makeCombi(0,new int[3],0,grid,virus_list);
		System.out.println(max);
	}
	public static void makeCombi(int isSelect,int[] select,int startIdx,int[][] grid,List<int[]> virus_list) {
		if(isSelect==select.length) {
			int[][] new_grid = new int[nNum][mNum];
			for(int i=0;i<nNum;i++) {				
				System.arraycopy(grid[i], 0, new_grid[i], 0, grid[i].length);
			}
			for(int i=0;i<select.length;i++) {
				//빈 공간 리스트에서 가져온다.
				int x = blank_list.get(select[i])[0];
				int y = blank_list.get(select[i])[1];
				//새로운 벽 생성
				new_grid[x][y] = 1;
			}
			//virus_list의 값 큐에 넣기 
			Queue<int[]> queue=new LinkedList<int[]>();
			for(int i=0;i<virus_list.size();i++) {
				queue.offer(virus_list.get(i));
			}
			int cnt = bfs(new_grid,queue);
			if(cnt>max) {
				max = cnt;
			}
			return;
		}
		
		for(int i=startIdx;i<blank_list.size();i++) {
			select[isSelect] = i;
			makeCombi(isSelect+1,select,i+1,grid,virus_list);
		}
	}
	public static int bfs(int[][] new_grid,Queue<int[]> queue) {
		while(!queue.isEmpty()) {
			int[] virus = queue.poll();
			int ni = virus[0];
			int nj = virus[1];
			for(int d=0;d<4;d++) {
				int new_ni = ni+deltas[d][0];
				int new_nj = nj+deltas[d][1];
				if(new_ni>=0&&new_nj>=0&&new_ni<new_grid.length&&new_nj<new_grid[new_ni].length&&new_grid[new_ni][new_nj]==0) {
					new_grid[new_ni][new_nj]=2; //오염
					queue.offer(new int[] {new_ni,new_nj});
				}
			}
		}
//		for(int[] row:new_grid) {
//			System.out.println(Arrays.toString(row));
//		}
//		System.out.println("-----------------------------------------------");
		int cnt=0;
		for(int i=0;i<nNum;i++) { //안전구역 세기
			for(int j=0;j<mNum;j++) {
				if(new_grid[i][j]==0) {
					cnt++;
				}
			}
		}
		return cnt;
	}
}
