package jungol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class jungol_1037 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		int nNum = Integer.parseInt(br.readLine());
		int[][] grid = new int[nNum][nNum];
		for(int i=0;i<nNum;i++) {
			StringTokenizer tk= new StringTokenizer(br.readLine());
			for(int j=0;j<nNum;j++) {
				grid[i][j] = Integer.parseInt(tk.nextToken());
			}
		}
		boolean flag= false;
		int row = -1;
		int col = -1;
		for(int i=0;i<nNum;i++) {
			int sum_row = 0;
			int sum_col = 0;
			
			for(int j=0;j<nNum;j++) {
				sum_col += grid[i][j];
				sum_row += grid[j][i];
			}
			if(sum_col%2!=0) {
				if(row==-1) {					
					row = i;
				}else {
					flag = true;
				}
			}
			if(sum_row%2!=0) {
				if(col==-1) {					
					col = i;
				}else {
					flag= true;
				}
			}
		}
		if(!flag) {
			if(row==-1&&col==-1) {
				System.out.println("OK");
			}else {
				System.out.println("Change bit ("+(row+1)+","+(col+1)+")");
			}
		}else {
				System.out.println("Corrupt");
		}
	}

}
