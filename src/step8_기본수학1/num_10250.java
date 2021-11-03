package step8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class num_10250 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for (int i = 0; i < t; i++) {
			StringBuilder sb = new StringBuilder();
			StringTokenizer tk = new StringTokenizer(br.readLine());
			int count = 0;
			int h = Integer.parseInt(tk.nextToken());
			int w = Integer.parseInt(tk.nextToken());
			int n = Integer.parseInt(tk.nextToken());
			int floor = n % h;
			if (n % h != 0) {
				count = (n / h)+1;
			}
			else if(n % h == 0) {
				floor = h;
				count = n / h;
			}
			else if((n / h)<1) {
				count = 1;
			}
			sb.append((floor*100)+count);
			System.out.println(sb.toString());
		}
	}
}
