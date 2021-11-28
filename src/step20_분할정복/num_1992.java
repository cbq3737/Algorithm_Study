package step19;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class num_1992 {
	public static StringBuilder sb = new StringBuilder();
	public static int[][] grid;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int nNum = Integer.parseInt(br.readLine());
		grid = new int[nNum][nNum];
		for(int i=0;i<grid.length;i++) {
			String str = br.readLine();
			for(int j=0;j<grid[i].length;j++) {
				grid[i][j]= str.charAt(j)-'0';
			}
		}
		devide(0,0,nNum);
		System.out.println(sb);
	}
	public static boolean check_section(int start_i,int start_j,int end) {
		int start = grid[start_i][start_j];
		for(int i=start_i;i<start_i+end;i++) {
			for(int j=start_j;j<start_j+end;j++) {
				if(grid[i][j]!=start) {
					return false;
				}
			}
		}
		return true;
	}
	public static void devide(int start_i,int start_j,int end) {
	
		if(check_section(start_i,start_j,end)) {
			sb.append(grid[start_i][start_j]);
			return;
		}
		if(end==2) {
				sb.append("(");
				for(int i=start_i;i<start_i+end;i++) {
					for(int j=start_j;j<start_j+end;j++) {
						sb.append(grid[i][j]);
					}
				}
				sb.append(")");
			return;
		}
		for(int i=start_i;i<start_i+end;i++) {
			for(int j=start_j;j<start_j+end;j++) {
				sb.append("(");
				devide(start_i,start_j,end/2);  // 0 0 ,2
				devide(start_i,start_j+end/2,end/2); // 0, 2 , 2
				devide(start_i+end/2,start_j,end/2); //2,0 , 2
				devide(start_i+end/2,start_j+end/2,end/2); //2,2  , 2     
				sb.append(")");
				return;
			}
		}
	}
}

