package step10_재귀;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class num_1074 {
	public static int cnt = 0;
	public static int r;
	public static int c;
	public static boolean flag;
	public static int[][] deltas = { { 0, 0 }, { 0, 1 }, { 1, -1 }, { 0, 1 } };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk = new StringTokenizer(br.readLine());
		int nNum = Integer.parseInt(tk.nextToken());
		r = Integer.parseInt(tk.nextToken());
		c = Integer.parseInt(tk.nextToken());
		int multi = (int) Math.pow(2, nNum);
		move_z(multi, 0, 0);
	}

	public static void move_z(int multi, int start_i, int start_j) {
		if (multi == 2) {
			for (int i = 0; i < 4; i++) {
				cnt++;
				int ni = start_i + deltas[i][0];
				int nj = start_j + deltas[i][1];
				if (ni == r && nj == c) {
					System.out.println(cnt - 1);
					System.exit(0);
					return;
				}
				start_i = ni;
				start_j = nj;
			}
			return;
		}
		
		if(start_i<=r &&r<start_i+multi/2 && start_j<=c&&c<start_j+multi/2) {//1사분면
			move_z(multi/2, start_i, start_j);
		}else if(start_i<=r && r<start_i+multi/2 && start_j+multi/2<=c&& c<start_j+multi) {//2사분면
			int blockCnt= (int)Math.pow(multi/2, 2);
			cnt+=blockCnt;
			move_z(multi/2,start_i,start_j+multi/2);
		}else if(start_i+multi/2<=r && r<start_i+multi && start_j<=c&&c<start_j+multi/2) { //3사분면
			int blockCnt= (int)Math.pow(multi/2, 2);
			cnt+=blockCnt*2;
			move_z(multi/2,start_i+multi/2,start_j);
		}else if(start_i+multi/2<=r && r< start_i+multi && start_j+multi/2<=c && c< start_j+multi) {//4사분면
			int blockCnt= (int)Math.pow(multi/2, 2);
			cnt+=blockCnt*3;
			move_z(multi/2,start_i+multi/2,start_j+multi/2);
		}
	}
}
