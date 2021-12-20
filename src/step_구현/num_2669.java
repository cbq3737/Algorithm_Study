package step_구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class num_2669 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[][] map = new int[101][101];
		for(int i=0;i<4;i++) {
			StringTokenizer tk = new StringTokenizer(br.readLine());
			int l_x = Integer.parseInt(tk.nextToken());
			int l_y = Integer.parseInt(tk.nextToken());
			
			int r_x = Integer.parseInt(tk.nextToken());
			int r_y = Integer.parseInt(tk.nextToken());
			
			for(int j=l_x;j<r_x;j++) {
				for(int k=l_y;k<r_y;k++) {
					map[j][k] = 1;
				}
			}
		}
		int sum =0;
		for(int i=0;i<map.length;i++) {
			for(int j=0;j<map[i].length;j++) {
				sum+=map[i][j];
			}
		}
		System.out.println(sum);
	}
}
