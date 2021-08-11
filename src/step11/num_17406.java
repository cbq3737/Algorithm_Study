package step11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class num_17406 {
	public static int kNum;//회전 횟수
	public static int[] k_index; //인덱스만 저장
	public static int[][] k_arr;//r,c,s
	public static int min = Integer.MAX_VALUE;
	public static void spin(int cnt,int idx,int middle,int[][] grid) {
		if(cnt == middle ) {
			return;
		}
		int r = k_arr[idx][0];
		int c = k_arr[idx][1];
		int s = k_arr[idx][2];
		
		int left_r = r-s-1;
		int left_c = c-s-1;
		//왼쪽 위 : (left_r,left_c)
		int right_r = r+s-1;
		int right_c = c+s-1;
		//오른쪽 아래: (right_r,right_c)
		
		int temp  = grid[left_r+cnt][right_c-cnt];
		for(int j=right_c-cnt;j>left_c+cnt;j--) {						
			//오른쪽으로
			grid[left_r+cnt][j] = grid[left_r+cnt][j-1];
		}
		for(int i=left_r+(1+cnt);i<=right_r-cnt;i++) {						
			//위쪽
			grid[i-1][left_c+cnt] = grid[i][left_c+cnt];
		}
		for(int j=left_c+(1+cnt);j<=right_c-cnt;j++) { 
			//왼쪽으로			
				grid[right_r-cnt][j-1] =grid[right_r-cnt][j];
		}
		for(int i=right_r-cnt;i>left_r+cnt;i--) {
			 //아래쪽으로
				grid[i][right_c-cnt] = grid[i-1][right_c-cnt];						
		}
		grid[left_r+cnt+1][right_c-cnt]= temp;
		spin(cnt+1,idx,middle,grid);
	}
	public static void check_sum(int[][] grid) { //최솟값 비교
		int min_num = Integer.MAX_VALUE;
		for(int i=0;i<grid.length;i++) {
			int sum =0;
			for(int j=0;j<grid[i].length;j++) {
				sum+= grid[i][j];
			}
			min_num = Math.min(sum,min_num);
		}
		min = Math.min(min_num, min);
	}
	private static void makePermutation(int toSelect,int[] selected, boolean[] visited,int[][] grid,int nNum,int mNum) {
	if(toSelect ==kNum) {
		int[][] new_grid= new int[nNum][mNum]; //새 배열 생성
		for(int i=0;i<grid.length;i++) {			
			System.arraycopy(grid[i], 0, new_grid[i], 0, grid[i].length);
		}
		for(int i=0;i<kNum;i++) {
			int r = k_arr[selected[i]][0];
			int c = k_arr[selected[i]][1];
			int s = k_arr[selected[i]][2];
			int m = (c+s-1) - (c-s-1);
			int n=  (r+s-1) - (r-s-1); //배열 크기 확인
			int middle = m>n? n/2 : m/2; //네모 갯수
			spin(0,selected[i],middle,new_grid);//새로운 배열을 준 뒤 순열에 따른 회전연산
		} 
		check_sum(new_grid); //최솟값
		return;
	}
	for(int i=0;i<k_index.length;i++) {
		if(!visited[i]) {
			visited[i] = true;
			selected[toSelect] = k_index[i]; //arr은 toSelected로 조절한다.
			makePermutation(toSelect+1,selected, visited,grid,nNum,mNum);
			visited[i] = false;
		}
	}
}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk = new StringTokenizer(br.readLine());
		int nNum = Integer.parseInt(tk.nextToken());
		int mNum = Integer.parseInt(tk.nextToken());
		kNum = Integer.parseInt(tk.nextToken());
		int[][] grid = new int[nNum][mNum];
		for(int i=0;i<nNum;i++) {
			tk = new StringTokenizer(br.readLine());
			for(int j=0;j<mNum;j++) {
				grid[i][j] = Integer.parseInt(tk.nextToken());
			}
		}
		k_arr = new int[kNum][3];
		k_index = new int[kNum];
		for(int i=0;i<kNum;i++) {
			tk = new StringTokenizer(br.readLine());
			k_arr[i][0]= Integer.parseInt(tk.nextToken());
			k_arr[i][1]= Integer.parseInt(tk.nextToken());
			k_arr[i][2]= Integer.parseInt(tk.nextToken());
			k_index[i] = i;
		}
		makePermutation(0,new int[kNum],new boolean[kNum],grid,nNum,mNum);
		System.out.println(min);
	}
}
