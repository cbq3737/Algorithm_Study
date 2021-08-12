import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
//boolean형으로 받는것으로 바꿔보기
public class swea_1974 {
	public static int flag;
	public static void check_num(int[][] grid) {

		boolean[] row_b ;
		boolean[] col_b ;
		//가로,세로 체크
		for(int i=0;i<9;i++) {
			row_b = new boolean[10];
			col_b = new boolean[10];
			for(int j=0;j<9;j++) {
				if(col_b[grid[i][j]]) {
					flag= 0;
					return;
				}else {					
					col_b[grid[i][j]]= true;
				}
				if(row_b[grid[j][i]]) {
					flag =0;
					return;
				}else {
					row_b[grid[j][i]]=true;
				}
			}
		}

		int i=0;
		int j=0;
		while(i<9&&j<9) {
			int ni = i;
			int nj = j;
			boolean[] block = new boolean[10];
			for(int r=0;r<3;r++) {
				for(int c=0;c<3;c++) {
					if(block[grid[ni+r][nj+c]]) {
						flag = 0;
						return ;
					}else {						
						block[grid[ni+r][nj+c]]=true;
					}
				}
			}
			i+=3;
			j+=3;
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		for(int t=0;t<tc;t++) {
			int[][] grid = new int[9][9];
			for(int i=0;i<9;i++) {
				StringTokenizer tk = new StringTokenizer(br.readLine());
				for(int j=0;j<9;j++) {
					grid[i][j] = Integer.parseInt(tk.nextToken());
				}
			}			
			flag=1;
			check_num(grid);
			System.out.println("#"+(t+1)+" "+flag);
		}
	}
}
