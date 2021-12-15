package step24_dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class num_13549 {//숨바꼭질3
	public static int[] grid = new int[100001];
	public static int[] deltas = {1,-1};
	public static void main(String[] args) throws IOException {
		BufferedReader br  =  new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk = new StringTokenizer(br.readLine());
		int nNum = Integer.parseInt(tk.nextToken());//수빈이 위치
		int kNum = Integer.parseInt(tk.nextToken());//동생 위치
		for(int i=0;i<grid.length;i++) {
			grid[i] = Integer.MAX_VALUE;
		}
		
		bfs(nNum,kNum);
		System.out.println(grid[kNum]);
	}
	public static void bfs(int nNum,int kNum) {
		Queue<Integer> queue = new LinkedList();
		queue.offer(nNum);//수빈이 위치
		grid[nNum] = 0;
		if((nNum*2)<grid.length) {//순간 이동한 위치, 처음 이동 가능 한지 넣어줘야 함.		
			grid[nNum*2] = 0;
			queue.offer(nNum*2);	
		}
		
		while(!queue.isEmpty()) {
			int N = queue.poll();//수빈이의 위치
			if(N==kNum) {//새로운 곳이 동생의 위치라면
				break;
			}
			if(N*2>=0&&N*2<grid.length) {//순간이동하는 장소 이동 가능하다면 
				grid[N*2] = grid[N];
				queue.offer(N*2);				
			}
			
			for(int d=0;d<2;d++) {
				int new_N = N+deltas[d];//1초 후
				if(new_N>=0&&new_N<grid.length) {//이동하는 수 가 범위안에 들어가고
					if(grid[new_N]>grid[N]+1) {//기존 값이 +1초보다 작다면 
						grid[new_N] = grid[N]+1;						
						queue.offer(new_N);
					}					
				}
			}
		}
	}

}
