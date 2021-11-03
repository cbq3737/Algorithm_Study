package step8_기본수학1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class num_1011 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for(int i=0;i<t;i++) {
			StringTokenizer tk = new StringTokenizer(br.readLine());
			int xNum = Integer.parseInt(tk.nextToken());
			int yNum = Integer.parseInt(tk.nextToken());
			int x_count =0;
			int y_count =0;
			int dist = 0;
			while(true) {
				dist++;
				
				xNum+=dist;
				x_count++;
				if(xNum>=yNum) {
					break;
				}
				yNum-=dist;
				y_count++;
				if(yNum<=xNum)
				{
					break;
				}
			}
			System.out.println(x_count+y_count);
		}
	}
}
