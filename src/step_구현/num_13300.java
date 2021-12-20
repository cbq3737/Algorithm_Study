package step_구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class num_13300 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk = new StringTokenizer(br.readLine());
		int nNum = Integer.parseInt(tk.nextToken());
		int kNum = Integer.parseInt(tk.nextToken());
		int[][] info = new int[2][7];
		for(int i=0;i<nNum;i++) {
			tk = new StringTokenizer(br.readLine());
			int gender = Integer.parseInt(tk.nextToken());
			int grade = Integer.parseInt(tk.nextToken());
			info[gender][grade]++;
		}
		int cnt =0;
		for(int i=0;i<2;i++) {
			for(int j=1;j<7;j++) {
				cnt+=info[i][j]/kNum;
				if(info[i][j]%kNum>0) {
					cnt++;
				}
			}
		}
		System.out.println(cnt);
	}
}
