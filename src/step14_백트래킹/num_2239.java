package step13;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class num_2239 {//스도쿠
	public static int[][] sdoku;
	public static StringBuilder sb = new StringBuilder();
	public static List<int[]> zero = new ArrayList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sdoku = new int[9][9];
		for(int i=0;i<9;i++) {
			String str = br.readLine();		
			for(int j=0;j<9;j++) {
				sdoku[i][j] = str.charAt(j)-'0';
				if(sdoku[i][j]==0) {
					zero.add(new int[] {i,j});
				}
			}
		}
		
		dfs(0);
	}
	public static void dfs(int depth) {
		if(depth==zero.size()) {
			for(int i=0;i<9;i++) {
				for(int j=0;j<9;j++) {
					sb.append(sdoku[i][j]);
				}
				sb.append("\n");
			}
			System.out.println(sb);
			System.exit(0);
		}
		
		int r = zero.get(depth)[0];
		int c = zero.get(depth)[1];
		for(int i=1;i<=9;i++) {
			if(check(r,c,i)) {//빈공간 값들 체크
				sdoku[r][c]= i;
				dfs(depth+1);
				sdoku[r][c]=0;
			}
		}
		
	}
	public static boolean check(int row,int col,int num) {
		//가로 체크
		for(int i=0;i<9;i++) {
			if(sdoku[row][i]==num) {
				return false;
			}
		}
		//세로 체크
		for(int j=0;j<9;j++) {
			if(sdoku[j][col]==num) {
				return false;
			}
		}
		int r = (row/3)*3;
		int c = (col/3)*3;
		//3x3체크
		for(int i=r;i<r+3;i++) {
			for(int j=c;j<c+3;j++) {
				if(sdoku[i][j]==num) {
					return false;
				}
			}
		}
		return true;
	}
}
