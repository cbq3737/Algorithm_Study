package step9_기본수학2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class num_1085 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk = new StringTokenizer(br.readLine());
		int x = Integer.parseInt(tk.nextToken());
		int y = Integer.parseInt(tk.nextToken());
		int w = Integer.parseInt(tk.nextToken());
		int h = Integer.parseInt(tk.nextToken());
		int min_w = Math.min(w-x, x);
		int min_h = Math.min(h-y, y);
		System.out.println(Math.min(min_w, min_h));
	}
}
