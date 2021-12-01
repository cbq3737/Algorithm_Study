package step23_dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class num_16928 {
	public static int[][] grid = new int[10][10];
	public static int[][] grid_check = new int[10][10];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk = new StringTokenizer(br.readLine());
		int nNum = Integer.parseInt(tk.nextToken());//사다리 수 
		int mNum = Integer.parseInt(tk.nextToken());//뱀의 수
		for(int i=0;i<10;i++) {
			for(int j=0;j<10;j++) {
				grid_check[i][j] = Integer.MAX_VALUE;
			}
		}
		//i*10+j+1 = 숫자
		int start = 0, end= 0;
		//사다리 배치
		for(int i=0;i<nNum;i++) {
			tk = new StringTokenizer(br.readLine());
			start = Integer.parseInt(tk.nextToken());
			end = Integer.parseInt(tk.nextToken());
			//30,21
			int one = (grid.length-1)-(start/10);//6,7
			int ten = (start%10) -1;//-1,0
			if((start%10)-1<0) {
				one = (grid.length-1)-(start/10)+1;//7
				ten = (grid[one].length-1);
			}
			grid[one][ten]=end;//사다리 위치에가서 숫자가 있다면 거기 적혀있는 숫자칸으로 가라
		}//21~30 = 7,xxxx , 30:7,9
		//뱀의 배치
		for(int i=0;i<mNum;i++) {
			tk = new StringTokenizer(br.readLine());
			start = Integer.parseInt(tk.nextToken());
			end = Integer.parseInt(tk.nextToken());
			int one = (grid.length-1)-(start/10);
			int ten = (start%10) -1;
			if((start%10)-1<0) {
				one = (grid.length-1)-(start/10)+1;
				ten = (grid[one].length-1);
			}
			grid[one][ten]= end;//뱀의 그 위치에 가서 숫자가 있다면 적혀있는 칸으로 이동해라
		}
		Queue<int[]> queue = new LinkedList();
		queue.offer(new int[] {9,0});//1부터 시작
		grid_check[9][0]=0;
		bfs(queue);
		System.out.println(grid_check[0][9]);
	}
	public static void bfs(Queue<int[]> queue) {
		while(!queue.isEmpty()) {
			int[] arr = queue.poll();
			int r=arr[0];
			int c=arr[1];
			if(r==0&&c==9) {//100번째 칸에 갔다면
				break;
			}
			for(int[] row:grid_check) {
				System.out.println(Arrays.toString(row));
			}
			System.out.println("-----------------------");
			//주사위 칸이 어떤게 나올지 모름
			for(int d=1;d<7;d++) {
				int new_r = r;
				int new_c = c+d;
				
				if(new_c>grid[new_r].length) {//주사위를 던졋을 때 
					new_c = new_c - grid[new_r].length;//그 다음칸으로 이동
					new_r = r-1; //한칸 위로 올라가고
				}
				if(new_r>=0&&new_c<grid[new_r].length) {//100번째칸을 넘어가면 안되므로	
					if(grid[new_r][new_c]!=0) {//이동한 칸에 뱀이나 사다리가 있다면
						int num = grid[new_r][new_c];
						int one = (grid.length-1)-(num/10);
						int ten = (num%10) -1;
						if((num%10)-1<0) {
								one = (grid.length-1)-(num/10)+1;
								ten = (grid[one].length-1);
						}
						if(grid_check[new_r][new_c]>grid_check[r][c]+1) {
							grid_check[new_r][new_c] = grid_check[r][c]+1;//최솟값 갱신
							grid_check[one][ten]=grid_check[new_r][new_c];//사다리나 뱀 값 그대로 갱신
							queue.offer(new int[] {one,ten});//그 칸으로 이동해라.
						}
					}else {//사다리나 뱀이 없는 칸
						if(grid_check[new_r][new_c]>grid_check[r][c]+1) {//최솟값 비교
							grid_check[new_r][new_c] = grid_check[r][c]+1;//최솟값 값 갱신
							queue.offer(new int[] {new_r,new_c});							
						}
					}
				}
			}
		}
	}
}
