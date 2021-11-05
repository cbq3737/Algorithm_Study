package step9_기본수학2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class num_1002 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tNum = Integer.parseInt(br.readLine());
		for(int i=0;i<tNum;i++) {
			StringTokenizer tk = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(tk.nextToken());
			int y1 = Integer.parseInt(tk.nextToken());
			int r1 = Integer.parseInt(tk.nextToken());
			int x2 = Integer.parseInt(tk.nextToken());
			int y2 = Integer.parseInt(tk.nextToken());
			int r2 = Integer.parseInt(tk.nextToken());
			int dist = (int)Math.pow(x2-x1,2)+(int)Math.pow(y2-y1, 2);
			if(x1==x2&&y1==y2&&r1==r2) {
				System.out.println(-1);
			}
			else if(dist>(int)Math.pow(r2+r1, 2) || dist < (int)Math.pow(r2-r1,2)) {
				System.out.println(0);
			}
			else if(dist==(int)Math.pow(r2-r1,2) || dist == (int)Math.pow(r2+r1, 2)) {
				System.out.println(1);
			}
			else {
				System.out.println(2);
			}
		}
	}
}
