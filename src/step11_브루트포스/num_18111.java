package step11;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
//마인크래프트 
public class num_18111 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk = new StringTokenizer(br.readLine());
		int nNum = Integer.parseInt(tk.nextToken());
		int mNum = Integer.parseInt(tk.nextToken());
		int bNum = Integer.parseInt(tk.nextToken());
		int[][] map = new int[nNum][mNum];
		Queue<Integer> queue = new LinkedList<>();
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		for(int i=0;i<nNum;i++) {
			tk = new StringTokenizer(br.readLine());
			for(int j=0;j<mNum;j++) {
				map[i][j] = Integer.parseInt(tk.nextToken());
				max = Math.max(max,map[i][j]);
				min = Math.min(min, map[i][j]);
			}
		}
		
		int second = Integer.MAX_VALUE;
		int h  = 0;
		for (int f = min; f <= max; f++) {
			int time = 0;
			int block = bNum;

			for (int i = 0; i < nNum; i++) {
				for (int j = 0; j < mNum; j++) {
					int dif = map[i][j] - f;

					if (dif > 0) {
						time += Math.abs(dif) * 2;
						block += Math.abs(dif);
					} else if (dif < 0) {
						time += Math.abs(dif);
						block -= Math.abs(dif);
					}

				}
			}
			if (block < 0)
				continue;
			if (second >= time) {
				second = time;
				h = f;
			}
		}
		System.out.println(second+" "+h);
	}
}
