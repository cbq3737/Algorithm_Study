package step_구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class num_16926 {
	public static int[][] grid;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer tk = new StringTokenizer(br.readLine());
		int nNum = Integer.parseInt(tk.nextToken());
		int mNum = Integer.parseInt(tk.nextToken());
		int num= Integer.parseInt(tk.nextToken());
		
		grid = new int[nNum][mNum];
		
		for(int i=0;i<nNum;i++) {
			tk = new StringTokenizer(br.readLine());
			for(int j=0;j<mNum;j++) {
				grid[i][j] = Integer.parseInt(tk.nextToken());
			}
		}
			int middle = mNum>nNum ? nNum/2:mNum/2;
		while(num>0) {			
			spin(0,mNum,nNum,middle);
			num--;
		}
		for(int i=0;i<nNum;i++) {
			for(int j=0;j<mNum;j++) {
				sb.append(grid[i][j]+" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
	public static void spin(int cnt,int mNum,int nNum,int middle) {
		if(cnt==middle) { 
			return;		
		}				
		int temp  = grid[cnt][cnt];
		for(int j=cnt+1;j<mNum-cnt;j++) { //왼쪽으로			
				grid[cnt][j-1] =grid[cnt][j];
		}
		for(int i=cnt+1;i<nNum-cnt;i++) {						
			//위쪽
				grid[i-1][mNum-cnt-1] = grid[i][mNum-cnt-1];
		}
		for(int j=mNum-(cnt+1);j>cnt;j--) {						
			//오른쪽
				grid[nNum-cnt-1][j] = grid[nNum-cnt-1][j-1];
		}
		for(int i=nNum-(cnt+1);i>cnt;i--) {
			 //아래쪽
				grid[i][cnt] = grid[i-1][cnt];						
		}
		grid[cnt+1][cnt] =temp;
		spin(cnt+1, mNum,nNum,middle);
	}
}
