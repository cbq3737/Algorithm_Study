
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_7236 {
	public static int[][] deltas= {{1,0},{-1,0},{0,1},{0,-1},{1,1},{-1,-1},{1,-1},{-1,1}};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tcase = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int t=0;t<tcase;t++) {
			int nNum = Integer.parseInt(br.readLine());
			char[][] grid = new char[nNum][nNum];
			for(int i=0;i<nNum;i++) {
				StringTokenizer tk = new StringTokenizer(br.readLine());
				for(int j=0;j<nNum;j++) {
					grid[i][j] = tk.nextToken().charAt(0);
				}
			}
			int sum =0;
			for(int i=0;i<nNum;i++) {
				for(int j=0;j<nNum;j++) {
					int cnt =0;
					if(grid[i][j]=='W') {
						for(int d=0;d<deltas.length;d++) {
							int ni=i+deltas[d][0];
							int nj=j+deltas[d][1];
							if(ni>=0&&nj>=0&&ni<grid.length&&nj<grid[ni].length&&grid[ni][nj]=='W') {
								cnt++;
							}
						}
						if(cnt<1) {
							sum = 1;
						}else {
							sum = Math.max(sum, cnt);
						}
					}
				}
			}
			sb.append("#"+(t+1)+" "+sum+"\n");
		}
		System.out.println(sb);
	}
}
