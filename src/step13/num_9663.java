package step13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class num_9663 {
	static int count_r =0;
	public static void check_func(boolean[][] check_arr,int nNum,int x,int y,int star_count) {
		boolean[][] check= new boolean[nNum][nNum];
	
		for(int i=0;i<nNum;i++) {
			for(int j=0;j<nNum;j++) {
				check[i][j] = check_arr[i][j];
			}
		}
			
		if(star_count == nNum) {
			count_r++;
			return;
		}
		
		for(int i = y;i<nNum;i++) {
			check[x][i]= false;
		}
		for(int i = x;i<nNum;i++) {
			check[i][y]= false;
		}
		
		for(int i=1;i<nNum;i++) {
			if((x+i<nNum) && (y+i<nNum)) {
				check[i+x][y+i] = false;
			}
			if((x+i<nNum) && (y-i>=0)) {
				check[i+x][y-i] = false;
			}
		}
		
		for(int i=(x+1);i<nNum;i++) {
			for(int j=0;j<nNum;j++) {
				if(check[i][j]==true) {
//					check[i][j]= false;
					check_func(check,nNum,i,j,star_count+1);
				}
			}
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int nNum = Integer.parseInt(br.readLine());
		
		boolean[][] check = new boolean[nNum][nNum]; 
		for(int i=0;i<nNum;i++) {
			for(int j=0;j<nNum;j++) {
				check[i][j]= true;
			}
		}
		for(int i=0;i<nNum;i++) {
			for(int j=0;j<nNum;j++) {				
				check_func(check,nNum,i,j,1);
			}
		}

		System.out.println(count_r);
	}
}
